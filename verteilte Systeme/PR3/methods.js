const userData = require('./usersDb');

let methods = { // JSON
    createUser:{ // Methodenname
        
        // Optional
        description: 'creates a new user and returns its id',
        params:['user:the user object'],
        returns:['userId'],
        
        // Funktion, die ausgeführt wird, um die Daten einzufügen, wenn der Client createUser aufruft.
        exec(userObject){ // Funktion namens exec.
            
            var userJSON  = JSON.parse(JSON.stringify(userObject));
            var name      = userObject.name;
            var age       = userObject.age;
            var requestId = userObject.id;
            var userId    = Math.random()*10000000 | 0; // Binary Or: Umwandlung in ein 32-Bit Integer. JS speichert Zahlen i.d.R als 64 Bit floating point numbers. Das ist für eine ID ungünstig.
            // https://www.w3schools.com/js/js_bitwise.asp
            
            // speichern des neuen Users in unserer "In-Storage-DB"
            userJSON = {name: name, age: age, userId: userId, requestId: requestId};           
            userData.push(userJSON);
            
            // Optional: Zur Kontrolle die Datenbankeinträge in der Konsole anzeigen lassen.
            for( var key in userData){
                if(userData.hasOwnProperty(key)){
                    console.log(key + " -> " + userData[key].name + " " + userData[key].userId + " " + userData[key].requestId);
                }
            }
            
            // Rückgabe der userId
            return({"jsonrpc": "2.0", "result": {"userId" : userId}, "id": requestId});
        }
    },

};
module.exports = methods;