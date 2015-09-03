
var mongodb = require('mongodb');

// MongoClient
var MongoClient = mongodb.MongoClient;

// Connection URL
var url = 'mongodb://localhost:27017/nodejs-mongodb-demo';

// Connect to server
MongoClient.connect(url, function (err, db) {
  if (err) {
	  
	 console.log('Connection error. Error:', err);
    
  } else {

	 // Connect successful
     console.log('Connection established to', url);

     // Get the documents collection
     var collection = db.collection('users');
     
     //Create some users
     var user1 = {name: 'Bin', age: 20};
     var user2 = {name: 'Bin2', age: 21};
     var user3 = {name: 'Bin3', age: 22};

     // Insert some users
     collection.insert([user1, user2, user3], function (err, result) {
       if (err) {
         console.log("ERROR: "+err);
       } else {
         console.log('SUCCESS');
       }
       
      // Close connection: NOTE CLOSE CONNECTION
       db.close();
       
     });
     
  }
});