var connect = require('connect');

var app = connect()
	.use(function (req, res) {
		res.end("Forbidden");
	})
	.listen(3000);