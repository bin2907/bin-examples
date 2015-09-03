
/* Include express */
var express = require('express');
var app = express();

/* set the view engine to ejs */
app.set('view engine', 'ejs');
app.set("views","./views");
app.set('layout', 'user/layouts/default.ejs') /* defaults layout */  

/* express-ejs-layouts */ 
var expressLayouts = require("express-ejs-layouts");
app.use(expressLayouts)


/* index page */ 
app.get('/', function(req, res) {
    res.render('user/pages/index', {title : 'Test'});
});

/* index page with other layout */
app.get('/mobile', function(req, res) {
    res.render('user/pages/index', {layout : 'user/layouts/mobile.ejs', title : 'Test'});
});

app.listen(8080);
console.log('App started up on port 8080');