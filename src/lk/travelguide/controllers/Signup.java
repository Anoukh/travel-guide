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
	public String signup(String name, String password,String useremail){
		System.out.println("signing up");
		String message;
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
		if(cursor.hasNext()) {
			message = "exists";
			System.out.println(message);
		}
		
		else{
		DBObject insertQuery = new BasicDBObject();
		
		insertQuery.put("name", name);
		insertQuery.put("password", password);
		insertQuery.put("email", useremail);
		insertQuery.put("userlevel", "User");
		
		List<DBObject> obj2 = new ArrayList<>();
		obj2.add(insertQuery);
		table.insert(obj2);
		
		User userdata = new User();
		userdata.setUsername(name);
		userdata.setPassword(password);
		userdata.setEmail(useremail);
		userdata.setUser_Level("User");
			
		message = "Signed up";	
		System.out.println(message);
		}	
		
		
		}catch (Exception e) {
			message = "dberror";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
