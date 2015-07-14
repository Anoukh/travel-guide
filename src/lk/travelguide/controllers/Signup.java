package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import lk.travelguide.models.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Signup {
	public void signup(String name, String password,String useremail){
		System.out.println("signing up");
		
		DB db;
	
		try{
		
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("user");
		
		
		
		BasicDBObject searchQuery = new BasicDBObject();
		List<BasicDBObject> obj1 = new ArrayList<BasicDBObject>();
		
		obj1.add(new BasicDBObject("name", name));
		searchQuery.put("$and", obj1);
		DBCursor cursor = table.find(searchQuery);
		//cursor.hasNext()
		if(cursor.hasNext()) System.out.println(name+" already exists");
		
		
		BasicDBObject insertQuery = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		obj2.add(new BasicDBObject("name", name));
		obj2.add(new BasicDBObject("password", password));
		obj2.add(new BasicDBObject("email", useremail));
		table.insert(insertQuery);
		
		
		User userdata = new User();
		userdata.setUsername(name);
		userdata.setPassword(password);
		userdata.setEmail(useremail);
		userdata.setUser_Level("User");
			
			
		System.out.println("signed up");
			
		
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
