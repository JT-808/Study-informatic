import { gossipsub } from '@chainsafe/libp2p-gossipsub'
import { noise } from '@chainsafe/libp2p-noise'
import { yamux } from '@chainsafe/libp2p-yamux'
import { identify, identifyPush } from '@libp2p/identify'
import { tcp } from '@libp2p/tcp'
import { createLibp2p } from 'libp2p'
import process from 'node:process'
import { multiaddr } from 'multiaddr'
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

const topic1 = 'news';
const topic2 = 'jokes';
const node = await createNode();

// Output Multiaddr
node.getMultiaddrs().forEach((addr) => {
    console.log(addr.toString())
})


// Read address from terminal
if (process.argv.length >= 3) {
    const ma = multiaddr(process.argv[2]);

    // Connect the two nodes
    await node.dial(ma);

    // subscribe to two topics
    node.services.pubsub.subscribe(topic1);
    node.services.pubsub.subscribe(topic2);

    // react on receiving messages 
    node.services.pubsub.addEventListener('message', (evt) => {
        console.log(`node1 received: ${uint8ArrayToString(evt.detail.data)} on topic ${evt.detail.topic}`);
        console.log(evt.detail);
    })
}