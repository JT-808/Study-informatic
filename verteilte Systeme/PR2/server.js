const express         = require('express');
const {graphqlHTTP}   = require('express-graphql'); // = require('express-graphql').graphqlHTTP
var {buildSchema}     = require('graphql'); // Object decomposing, Auf korrekte Schreibweise achten.

// Root-Type oder Query-Type
// Beachten Sie den Backtick `.
//Dieser erlaubt in JavaScript TemplateStrings mit eingebetteten AusdrÃ¼cken.
// https://developer.mozilla.org/de/docs/Web/JavaScript/Reference/template_strings
var schema = buildSchema(`
    type Query { 
        user(id: Int!): User,
        users(job: String): [User]
    },
    
    type User{
        id: Int,
        first_name: String,
        last_name: String,
        height: Float,
        job: String
    }
`);

var usersData = [
    {
        id:1,
        first_name: "Thomas",
        last_name: "Meier",
        height: 182,
        job: "Lehrer"
    },
        {
        id:2,
        first_name: "Tina",
        last_name: "Oertel",
        height: 165,
        job: "Lehrer"
    },
        {
        id:3,
        first_name: "Sarah",
        last_name: "Mueller",
        height: 169,
        job: "Programmierer"
    },
        {
        id:4,
        first_name: "Toni",
        last_name: "Hinterhuber",
        height: 185,
        job: "Landwirt"
    },   
]

// root bietet eine Resolver-Funktion fÃ¼r jeden API-Endpoint.
// Hier ist der einzige Endpoint hello. Die Resolver-Funktion gibt 'Hello World' zurÃ¼ck.
var getUsers = function(args){
    if(args.job){ // Wenn ein Argument vorhanden ist, Daten filtern
        var job = args.job;
        return usersData.filter(user => user.job === job);
        // iteriert Ã¼ber usersData, Vergleicht fÃ¼r jeden
        // Eintrag, ob der job des Users gleich dem Query-Argument ist.
        // Gibt ein Array mit den 'user' zurÃ¼ck, bei denen der Vergleich true bringt.
        
        // Bei ===  mÃ¼ssen sowohl Wert als auch Typ der Variablen Ã¼bereinstimmen.
    }else{ // Wenn kein Argument vorhanden ist, alle Daten zurÃ¼ckgeben
        return usersData;
    } 
}

var getUser = function(args){
    var id = args.id;
    return usersData.filter(user => {
        return user.id == id; // mit == wird eine Typ-Korrektur durchgefÃ¼hrt.
        //Die Id kann also sowohl als String als auch als Integer angegeben werden.
    })[0];
}

var root = {
    user: getUser,
    users:getUsers,
}

var app = express();
app.use('/graphql', graphqlHTTP({
    schema: schema, // Einbinden des Schemas
    rootValue: root, // Einbinden der Resolver-Funktionen
    graphiql: true, // Interface zum Testen
}));
app.listen(3000);

console.log('Running on 3000 at http://localhost:3000/graphql');


/* Beispiel: Abfrage:

{
    users(job: "Lehrer") { 
      first_name
    }
  }
    
    */