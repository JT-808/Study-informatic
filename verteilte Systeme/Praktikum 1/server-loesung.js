var express  = require('express');
var userList = require('./userList');
var path     = require('path');
var app = express();
app.listen(3000);

// Setting up the routes

// Mit rxpress.Router kann noch eine Middleware zum Routenhandling eingefügt werden.

app.use(express.json()); // URL encoded bodies parsen
app.use(express.urlencoded()); //JSON bodies parsen

app.route('/')
  .get(function(req, res){
    res.sendFile(path.join(__dirname, './','browser.html'));
  })


// Rest-Api

app.route('/users')
  .get(userList.list_all_users)
  .post(userList.create_new_user);

app.route('/users/:userId')
  .get(userList.list_one_user) 
  .delete(userList.delete_user)
  .put(userList.update_user);

