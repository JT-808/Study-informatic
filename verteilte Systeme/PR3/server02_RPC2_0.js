//JSON-RPC
const express    = require('express');
const path       = require('path');
const bodyParser = require('body-parser');
const methods    = require('./methods');

var app = express();
app.use(express.json());
app.listen(3000);

app.get('/', function(req, res){
    res.sendFile(path.join(__dirname,'./public', 'browser_RPC2_0.html'));
})

app.post('/rpcapi',function(req, res){
    console.log("Post-Request erhalten");
    
    let body = req.body;
    if(!body){
        res.send("Daten fehlen");
    }

    let methodResult;    

    methodName = body["method"];
    params     = body["params"];

        // optional    
        console.log(methodName);
        console.log(methods[methodName]);
            
        if(methods[methodName] && typeof (methods[methodName].exec) === 'function'){ // check if the method exists and whether it is a function
            methodResult = methods[methodName].exec(params);
            //methodResult = methods[key].exec.call(null, body[key]); Statt null könnte hier this mitgegeben werden.
        }else{
            
                //Fehlermeldung, dass Methode nicht gefunden wurde.
                methodResult = {"jsonrpc": "2.0", "error": {"code": -32601, "message": "Method not found"}, "id": params["id"]}
        }
        res.json(methodResult);   
})


