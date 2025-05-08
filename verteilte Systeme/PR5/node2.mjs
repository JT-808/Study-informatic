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
      listen: ['/ip4/127.0.0.1/tcp/0']
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

const topic1 = 'jokes';
const node = await createNode();

// If peer is discovered, dial to this node
node.addEventListener('peer:discovery', async (evt) => {
    console.info('peer:discovery', evt.detail);
    await node.dial(evt.detail.multiaddrs);
});

// Subscribe to a topic
node.services.pubsub.subscribe(topic1);

// Handle received message
node.services.pubsub.addEventListener('message', (evt) => {
  console.log(`node2 received: ${uint8ArrayToString(evt.detail.data)} on topic ${evt.detail.topic}`)
})