var os = require('os');

var message = 'This script runs on Node.js ' + process.version +
			' on a ' + os.type() + '-based operating system.';

console.log(message);