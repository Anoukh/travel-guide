package lk.travelguide.controllers;

import java.net.UnknownHostException;
import java.util.Date;

//import lk.travelguide.conrollers.DbConnection;
//import lk.travelguide.conrollers.Login;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
 

public class Login {
	
public void authentication(String name, String password){
		
		boolean auth ;
		DB db;
		/*
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		
		DB db = mongo.getDB("test");*/
		try{
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("user");
		
		
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", name);
	 
		DBCursor cursor = table.find();
		//cursor.hasNext()
		
		while (cursor.hasNext()) {
			String pass = (String)cursor.next().get("password");
			System.out.println(pass);
			
			int a = pass.compareTo(password);
			if(a==0) System.out.println("authenticated");
			else System.out.println("failed");
		}
		
		
	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
	
	
	
}
