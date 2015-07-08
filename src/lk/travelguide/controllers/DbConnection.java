package lk.travelguide.controllers;

import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class DbConnection {

	public  DB dbCon(){
		MongoClient mongo;
		DB db = null;
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		
		db = mongo.getDB("test");
		return db;
		}catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return db;	
	}
		
	
	
	public static void main(String[] args){
		/*MongoClient mongo;
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		
		DB db = mongo.getDB("test");
		DBCollection table = db.getCollection("data");
		 
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "janitha");
	 
		DBCursor cursor = table.find();
	 
		while (cursor.hasNext()) {
			System.out.println(cursor.next().get("name"));
		}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("hello");*/
	}
	
	
}
