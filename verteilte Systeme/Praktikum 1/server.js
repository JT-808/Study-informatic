var express  = require('express');
var userList = require('./userList');
var mysql = require('mysql')
var path = require('path');
var app = express();

app.listen(3000);

app.route('/')
  .get(function(req, res){
    res.sendFile(path.join(__dirname, './','index.html'));
  })


  
// Rest-Api

app.route('/users')
  .get(userList.list_all_users)
  .post(userList.create_new_user);

app.route('/users/:userId')
  .get(userList.list_one_user) 
  .delete(userList.delete_user)
  .put(userList.update_user);



  var mysqlCon = mysql.createConnection({
    host: "Datenbankserver eingeben", // z. B. wdb2.hs-mittweida.de
    user: "Hier Nutzername eingeben",
    password: "Hier Passwort eingeben",
    database: "Hier Datenbankname eingeben"
   });
