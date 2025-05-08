/*
  Gossipsub ist ein skalierbares PubSub-Protokoll, das auf einem Mesh-Netzwerk basiert.
  Jeder Peer ist mit einer kleinen Anzahl anderer Peers (Mesh-Peers) verbunden.
  Nachrichten werden direkt an diese Mesh-Peers gesendet und zusätzlich "angekündigt" (Gossip)
  an andere Peers, die nicht direkt verbunden sind.

  Beispiel:
  - Peer A ist mit B verbunden, B mit C.
  - Wenn A etwas veröffentlicht, erhält B die Nachricht direkt.
  - B gibt sie dann an C weiter.
  - So entsteht eine verteilte, robuste Verteilung der Nachrichten ohne zentrale Instanz.

  Das ermöglicht ein effizientes, fehlertolerantes und dynamisches Nachrichtensystem in P2P-Netzwerken.
*/




import { gossipsub } from '@chainsafe/libp2p-gossipsub'
import { noise } from '@chainsafe/libp2p-noise'
import { yamux } from '@chainsafe/libp2p-yamux'
import { identify, identifyPush } from '@libp2p/identify'
import { tcp } from '@libp2p/tcp'
import { createLibp2p } from 'libp2p'
import { fromString as uint8ArrayFromString } from 'uint8arrays/from-string'
import { toString as uint8ArrayToString } from 'uint8arrays/to-string'

const createNode = async () => {
  const node = await createLibp2p({
    addresses: {
      listen: ['/ip4/0.0.0.0/tcp/0']
    },
    transports: [tcp()],
    streamMuxers: [yamux()],
    connectionEncrypters: [noise()],
    services: {
      pubsub: gossipsub(),
      identify: identify(),
      identifyPush: identifyPush()
    },
  })

  return node;
}

const topic = 'news';
const topic2 = 'jokes';

const node = await createNode();


// Subscribe to a topic
// Sender doesn't receive its own messages.
node.services.pubsub.subscribe(topic)
node.services.pubsub.addEventListener('message', (evt) => {
  console.log(`node received: ${uint8ArrayToString(evt.detail.data)} on topic ${evt.detail.topic}`)
})

// Outputs sender's address
node.getMultiaddrs().forEach((addr) => {
    console.log(addr.toString())
})

// node publishes "news" every four seconds
setInterval(() => {
    node.services.pubsub.publish(topic, uint8ArrayFromString('Latest News!')).catch(err => {
      console.error(err)
    });
    node.services.pubsub.publish(topic2, uint8ArrayFromString("What is the computer's favorite snack to eat? ...Microchips")).catch(err => {
        console.error(err)
    });
    console.log(node.peerStore.peerId)
}, 4000)