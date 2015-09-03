var fs = require("fs");

var data = fs.readFileSync('npm.txt'); // npm.txt inside {node_install_folder}

console.log(data.toString());
console.log("Program Ended");