// Chat Websockets

var express   = require('express');
var path      = require('path');
var WebSocket = require('ws');
var http      = require('http');
var crypto    = require('crypto');
var app       = express();
var server    = http.createServer(app);
var wss       = new WebSocket.Server({ server });
var chats     = new Map(); // chatId => [socket connection 1, socket connection 2, ...]


app.use(express.static(path.join(__dirname,'/public/'))); // um style.css im Order public einbinden zu können. Dateien z. B. css


// Weiterleitung auf eine individuelle Chatseite bei erstmaligem Betreten der Chatseite
app.get('/', function(req, res){
    // ChatId erstellen
    var rand = (Math.random()*100).toString();
    chatId = crypto.createHash("sha256").update(rand, "string").digest('hex');
    chatIdString = chatId.slice(0,7);
    chats.set(chatIdString,[]); // Hier evtl noch prÃ¼fen, ob dieser Chat schon existiert. Ansonsten wird dieser Ã¼berschrieben
    console.log("Website aufgerufen, Weiterleitung an Chat " + chatIdString );
    res.redirect('/chat/'+chatIdString);
});


// Senden der Chat-Seite, wenn diese explizit aufgerufen wurde
app.get('/chat/:chatId',function(req, res){
    chatId = req.params.chatId; // Chat Id aus der Url auslesen
    console.log("Website mit Param aufgerufen: " + chatId);
    if(!chats.has(chatId)){ // Wenn ChatId noch nicht vorhanden ist, neue anlegen
        chats.set(chatId, []);
        console.log("Neuer Mapeintrag ChatId => WS[] angelegt");
    }else{
        console.log("ChatId vorhanden: ");
    }
    res.sendFile(path.join(__dirname, '../WebSockets', 'chat.html'));
});

server.listen(3000);

