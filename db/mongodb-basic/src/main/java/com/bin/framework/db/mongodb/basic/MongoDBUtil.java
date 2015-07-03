package com.bin.framework.db.mongodb.basic;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class MongoDBUtil {
	
	static MongoClient mongoClient;
	static DB db;
	
	public static void connect() throws UnknownHostException{
		// Connect
        mongoClient = new MongoClient( "localhost" , 27017 );
	}
	
	public static void close(){
		mongoClient.close();
	}
	
	public static void setWriteConcern(){
		mongoClient.setWriteConcern(WriteConcern.JOURNALED);
	}
	
	public static void dropDB(){
		System.out.println("***Drop DB***");
		mongoClient.dropDatabase("test");
	}
	
	public static void useDB(){
		System.out.println("***User DB test***");
		db = mongoClient.getDB( "test" );
	}
	
	public static void createCollection(){
		System.out.println("***Create collection***");
		db.createCollection("profile", new BasicDBObject("title", "Binh"));
	}
	
	public static void dropCollection(){
		System.out.println("***Drop collection***");
		DBCollection coll = db.getCollection("profile");
		coll.drop();
	}
	
	public static void getCollectionNames(){
		System.out.println("***Get collection names***");
		Set<String> collections = db.getCollectionNames();
		for( String s : collections ){
			System.out.println(s);
		}
	}
	
	public static void getCollection(){
		System.out.println("***Get collection***");
		DBCollection collection = db.getCollection("post");
		System.out.println(collection.getName());
	}
	
	public static void insert(){
		System.out.println("***Insert***");
		DBCollection collection = db.getCollection("post");
		BasicDBObject object1 = new BasicDBObject();
		object1.append("title", "MongoDB part2").append("description", "Description mongodb part2");
		
		BasicDBObject object2 = new BasicDBObject();
		object2.append("title", "MongoDB part3").append("description", "Description mongodb part3");
		
		collection.insert(object1, object2);
	}
	
	public static void find(){
		System.out.println("***Find***");
		DBCollection collection = db.getCollection("post");
		BasicDBObject query = new BasicDBObject("title", "MongoDB part2");
		DBCursor dbCursor = collection.find(query);
		while(dbCursor.hasNext()){
			System.out.println(dbCursor.next());
		}
		dbCursor.close();
	}
	
	public static void findWithMaxTime(){
		System.out.println("***Find with max time***");
		DBCollection collection = db.getCollection("post");
		int count = collection.find().maxTime(1, TimeUnit.SECONDS).count();
		System.out.println("count: " + count);
	}
	
	public static void createIndex(){
		System.out.println("***Create index***");
		DBCollection collection = db.getCollection("post");
		collection.createIndex(new BasicDBObject("title", 1));
	}
	
	public static void createGeoIndexes(){
		System.out.println("***Geo indexes***");
		/*BasicDBList coordinates = new BasicDBList();
		coordinates.put(0, -73.97);
		coordinates.put(1, 40.77);
		coll.insert(new BasicDBObject("name", "Central Park")
		                .append("loc", new BasicDBObject("type", "Point").append("coordinates", coordinates))
		                .append("category", "Parks"));

		coordinates.put(0, -73.88);
		coordinates.put(1, 40.78);
		coll.insert(new BasicDBObject("name", "La Guardia Airport")
		        .append("loc", new BasicDBObject("type", "Point").append("coordinates", coordinates))
		        .append("category", "Airport"));


		// Find whats within 500m of my location
		BasicDBList myLocation = new BasicDBList();
		myLocation.put(0, -73.965);
		myLocation.put(1, 40.769);
		myDoc = coll.findOne(
		            new BasicDBObject("loc",
		                new BasicDBObject("$near",
		                        new BasicDBObject("$geometry",
		                                new BasicDBObject("type", "Point")
		                                    .append("coordinates", myLocation))
		                             .append("$maxDistance",  500)
		                        )
		                )
		            );
		System.out.println(myDoc.get("name"));*/
	}
	
	public static void createTextIndex(){
		System.out.println("***Create text index***");
		DBCollection collection = db.getCollection("post");
		// create a text index on the "content" field
		collection.createIndex(new BasicDBObject("content", "text"));
	}
	
	public static void getIndexesOnCollection(){
		System.out.println("***Get indexes on collection***");
		DBCollection collection = db.getCollection("post");
		List<DBObject> list = collection.getIndexInfo();

		for (DBObject o : list) {
		   System.out.println(o.get("key"));
		}
	}
	
	public static void bulkOperate(){
		/*// 1. Ordered bulk operation
		BulkWriteOperation builder = coll.initializeOrderedBulkOperation();
		builder.insert(new BasicDBObject("_id", 1));
		builder.insert(new BasicDBObject("_id", 2));
		builder.insert(new BasicDBObject("_id", 3));

		builder.find(new BasicDBObject("_id", 1)).updateOne(new BasicDBObject("$set", new BasicDBObject("x", 2)));
		builder.find(new BasicDBObject("_id", 2)).removeOne();
		builder.find(new BasicDBObject("_id", 3)).replaceOne(new BasicDBObject("_id", 3).append("x", 4));

		BulkWriteResult result = builder.execute();

		// 2. Unordered bulk operation - no guarantee of order of operation
		builder = coll.initializeUnorderedBulkOperation();
		builder.find(new BasicDBObject("_id", 1)).removeOne();
		builder.find(new BasicDBObject("_id", 2)).removeOne();

		result = builder.execute();*/
	}
	
	/**
	 * Allows reading an entire collection using multiple cursors. 
	 */
	public static void parallelScan(){
		
		//NOTE ParallelScan does not work via mongos.
		
		/*ParallelScanOptions parallelScanOptions = ParallelScanOptions
		        .builder()
		        .numCursors(3)
		        .batchSize(300)
		        .build();

		List<Cursor> cursors = coll.parallelScan(parallelScanOptions);
		for (Cursor pCursor: cursors) {
		    while (pCursor.hasNext()) {
		        System.out.println((pCursor.next()));
		    }
		}*/
	}
	
	public static void ensureOperate() {
		//If you want to ensure complete consistency in a â€œsessionâ€� (maybe an http request)
		System.out.println("***Ensure operate***");
		db.requestStart();
		try {
			db.requestEnsureConnection();
			DBCollection collection = db.getCollection("post");
			List<DBObject> list = collection.getIndexInfo();

			for (DBObject o : list) {
				System.out.println(o.get("key"));
			}
		} finally {
			db.requestDone();
		}
	}

	public static void main(String[] args){
		
		try{   
			
			// Connect
			MongoDBUtil.connect();
			
			// Use db
			MongoDBUtil.useDB();
			
			// Create collection
			MongoDBUtil.createCollection();
			
			// Drop collection
			MongoDBUtil.dropCollection();
			
			// Get collections
			MongoDBUtil.getCollectionNames();
			
			// Get a collections
			MongoDBUtil.getCollection();
			
			// Insert
			//MongoDBUtil.insert();
			
			// Find
			MongoDBUtil.find();
			
			// Find with max time
			//MongoDBUtil.findWithMaxTime();
			
			// Create index
			//MongoDBUtil.createIndex();
			
			// Create text index
			//MongoDBUtil.createTextIndex();
			
			// Get indexes on collection
			//MongoDBUtil.getIndexesOnCollection();
			
			// Ensure operations
			MongoDBUtil.ensureOperate();
			
			// Close connect
			MongoDBUtil.close();
			
	      }catch(Exception e){
		     System.out.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
		
	}
	
}
