/*
  mDNS (Multicast DNS) wird zur lokalen Peer-Erkennung im selben Netzwerk verwendet.
  Jeder Peer sendet regelmäßig Ankündigungen (Broadcasts) per mDNS und hört gleichzeitig auf solche Nachrichten.
  So können Peers einander automatisch erkennen, ohne dass ihre Adressen manuell bekannt sein müssen.

  Beispiel:
  - Zwei Nodes laufen im gleichen lokalen Netzwerk.
  - Durch mDNS entdecken sie sich gegenseitig und bauen eine Verbindung auf.
  - Besonders praktisch in Entwicklungsumgebungen oder bei LAN-basierten P2P-Anwendungen.

  Hinweis: mDNS funktioniert nur innerhalb desselben Subnetzes.
*/



import { gossipsub } from '@chainsafe/libp2p-gossipsub'
import { noise } from '@chainsafe/libp2p-noise'
import { yamux } from '@chainsafe/libp2p-yamux'
import { identify, identifyPush } from '@libp2p/identify'
import { tcp } from '@libp2p/tcp'
import { createLibp2p } from 'libp2p'
import { mdns } from '@libp2p/mdns'
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
    peerDiscovery: [
        mdns()
    ]
  })
  return node;
}

const topic = 'news';
const node = await createNode();

// If Peer discoverred, dial to it
node.addEventListener('peer:discovery', async (evt) => {
    console.info('peer:discovery', evt.detail);
    await node.dial(evt.detail.multiaddrs);
});

// subscribe to topics on PubSub
node.services.pubsub.subscribe(topic)
node.services.pubsub.addEventListener('message', (evt) => {
  console.log(`node received: ${uint8ArrayToString(evt.detail.data)} on topic ${evt.detail.topic}`)
});

// node publishes a message on the topic "news" every four seconds
setInterval(() => {
  node.services.pubsub.publish('news', uint8ArrayFromString('Latest News!')).catch(console.error)
}, 4000)

setInterval(() => {
  node.services.pubsub.publish('jokes', uint8ArrayFromString('Why do nodes love gossip? Because it spreads fast!')).catch(console.error)
}, 4000)
