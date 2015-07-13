package lk.travelguide.controllers;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

//import lk.travelguide.conrollers.DbConnection;
//import lk.travelguide.conrollers.Login;

import java.util.List;

import lk.travelguide.models.User;



import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;


public class Login {
	
public static String authentication(String name, String password){
		System.out.println("authenticating");
		boolean auth ;
		DB db;
		String message = null;
		/*
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		
		DB db = mongo.getDB("test");*/
		try{
		
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("user");
		
		
		
		BasicDBObject searchQuery = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		
		
		obj2.add(new BasicDBObject("name", name));
		obj2.add(new BasicDBObject("password", password));
		searchQuery.put("$and", obj2);
		DBCursor cursor = table.find(searchQuery);
		//cursor.hasNext()
		
		System.out.println(cursor);
		
		if(cursor.hasNext()){
			DBObject cs = cursor.next();
			System.out.println("authenticating....");
			String pass = (String)cs.get("password");
			String username = (String)cs.get("name");
			String email = (String)cs.get("email");
			String user_level = (String)cs.get("user_level");
			String request_accept = (String)cs.get("request_accept");
			//System.out.println(pass+"	"+username);
			
			User userdata = new User();
			userdata.setUsername(name);
			userdata.setPassword(password);
			userdata.setEmail(email);
			userdata.setUser_Level(user_level);
			userdata.setRequest_Accept(request_accept);
			
			//System.out.println("authenticated");    
			message ="loginsuccess";
			
		}
		
		
		else{ 
			message ="loginfail";
			
			//System.out.println("failed");
			
			//String message = null;
		     

		     
		         //   message = "You are not the valid user...";
		        
		     
		     
		     //request.setAttribute("loginerrormessage", message);
		       // request.getRequestDispatcher("/NewFile.jsp").forward(request, response);
		}
		
	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
		
	}
	
		
	
	
	




}