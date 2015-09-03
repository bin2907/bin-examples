var fs = require("fs");

fs.readFile('npm.txt', function (err, data) {// npm.txt inside {node_install_folder}
    if (err) return console.error(err);
    console.log(data.toString());
});

console.log("Program Ended");