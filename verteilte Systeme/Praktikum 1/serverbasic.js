var express  = require('express');
var path = require('path');
var app = express();

app.listen(3000);

app.route('/')
  .get(function(req, res){
    res.sendFile(path.join(__dirname, './','browser.html'));
  })
