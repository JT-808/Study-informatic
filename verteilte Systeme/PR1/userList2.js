/*
app.route('/users')
  .get(userList.list_all_users)
  .post(userList.create_new_user);
app.route('/users/:userId)
  .get(userList.list_one_user)
  .delete(userList.delete_user)
  .put(userList.update_new_user);
*/

var mysql = require('mysql');
var mysqlCon = mysql.createConnection({
  host: "Datenbankserver eingeben", // z. B. wdb2.hs-mittweida.de oder localhost mit entsprechendem Port
  user: "Hier Nutzername eingeben",
  password: "Hier Passwort eingeben",
  database: "Hier Datenbankname eingeben"
});

mysqlCon.connect(function(err){
  if(err) throw err;
  console.log("Mit MySQL verbunden");
})

exports.list_all_users = function(req, res){
  console.log("Route list all users");
  mysqlCon.query("SELECT * FROM vs_user", function(err, result){
    if(err) throw err;
    console.log(result);
    res.json(result);
  });
}

exports.create_new_user = function(req, res){
  console.log("Route create new users (POST)");
  req.on('data', chunk => {
    data = JSON.parse(chunk.toString());
    var name       = data.name;
    var desc       = data.desc;
    var permission = parseInt(data.permission);
    console.log(name + " " + desc + " "+ permission);
    
    //Prüfung der Nutzereingabe
    if(name == "" || !name || name.lenght < 3){
      // Bad Request
      res.status(400, "Es muss ein Name angegeben werden, er muss mindestens 3 Zeichen lang sein.");
      return; // Rest der Funktion soll nicht ausgeführt werden.
    }
    mysqlCon.query("INSERT INTO vs_user (name, descr, permission) VALUES (?,?,?)",[name, desc, permission],function(err, result){
      if(err) throw (err);
      console.log("Number of rows inserted: " + result);
      res.json("POST erfolgreich " + result + " " + err);
    })

  });
}


exports.list_one_user = function(req, res){
  console.log("Route list one user (GET)");
  var id = req.params.userId;  // Wenn als url mitgeschickt /user/2
  console.log(id);
  mysqlCon.query("SELECT * FROM vs_user WHERE id = ?", [id], function(err, result){
    if(err) throw err;
    console.log(result);
    res.json(result);
  });
}

exports.delete_user = function(req, res){
  console.log("Route delete one user (DELETE)");
  var id = req.params.userId;  // Wenn als url mitgeschickt /user/2
  console.log(id);
  mysqlCon.query("DELETE FROM vs_user WHERE id = ?", [id], function(err, result){
    if(err) throw err;
    console.log(result);
    res.json(result);
  });
}

exports.update_user = function(req, res){
  console.log("Route update one user (PUT)");
  var id = req.params.userId;  // Wenn als url mitgeschickt /user/2
  req.on('data', chunk => {
    data = JSON.parse(chunk.toString());
    var desc    = data.desc;
    console.log("ID: " + id + "DEscr: " + desc);
    mysqlCon.query("UPDATE vs_user SET descr = ? WHERE id = ?",[desc, id],function(err, result){
      if(err) throw (err);
      console.log("Number of rows updated: " + result);
      res.json("PUT erfolgreich " + result + " " + err);
    })

  });
}
