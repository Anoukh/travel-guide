package lk.travelguide.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lk.travelguide.models.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AddPlace {

	
public void addplaces(String placetype,String placename,String placecity,String placedes,String placeimg,float lat,float lng,String rating,String placecharge){
	
	//return "Hi";
	boolean auth ;
	DB db;
try{
	System.out.println(rating);
	System.out.println("print2");
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   //get current date time with Date()
		   Date dt = new Date();
		   String date = dateFormat.format(dt);
		
		DBCollection table = db.getCollection("place");
		
		 BasicDBObject searchplaceavb = new BasicDBObject();
		List<BasicDBObject> plavbcheckobj = new ArrayList<BasicDBObject>();
			
			
			
			plavbcheckobj.add(new BasicDBObject("placename", placename));
			plavbcheckobj.add(new BasicDBObject("placetype", placetype));
			plavbcheckobj.add(new BasicDBObject("placecity", placecity));
			searchplaceavb.put("$and", plavbcheckobj);
			DBCursor cursor = table.find(searchplaceavb);
			//cursor.hasNext()
			
			if(cursor.hasNext()){
				System.out.println("Already included Place");
			}	
			else{
		 DBObject plinsertobj = new BasicDBObject();
		 plinsertobj.put("placetype", placetype);
		 plinsertobj.put("placename",placename);
		 plinsertobj.put("placecity", placecity);
		 plinsertobj.put("placedes", placedes);
		 plinsertobj.put("lat",lat);
		 plinsertobj.put("lng",lng);
		 plinsertobj.put("placerating",rating);
		 plinsertobj.put("noofrates",1);
		 
		 plinsertobj.put("placecharge",placecharge);
		 plinsertobj.put("lastupdate",date);
		 plinsertobj.put("acceptYN","N");
		
		//BasicDBObject searchQuery = new BasicDBObject();
		//List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		 List<DBObject> obj2 = new ArrayList<>();
		
		 obj2.add(plinsertobj);
		 
		 table.insert(obj2);

			}
			
				
				
		 //BasicDBObject searchQuery = new BasicDBObject();
		//	List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
			
			
			
		//	obj2.add(new BasicDBObject("name", name));
		//	obj2.add(new BasicDBObject("password", password));
		//	searchQuery.put("$and", obj2);
		//	DBCursor cursor = table.find(searchQuery);
			//cursor.hasNext()
		//	DBObject cs = cursor.next();
		
		//if(cursor!=null){
		//	//System.out.println("authenticating....");
		//	String pass = (String)cs.get("password");
		//	String username = (String)cs.get("name");
		//	String email = (String)cs.get("email");
		//	String user_level = (String)cs.get("user_level");
		//	String request_accept = (String)cs.get("request_accept");
			//System.out.println(pass+"	"+username);
			
		//	User userdata = new User();
		//	userdata.setUsername(name);
		//	userdata.setPassword(password);
		//	userdata.setEmail(email);
		//	userdata.setUser_Level(user_level);
		//	userdata.setRequest_Accept(request_accept);
			
			//System.out.println("authenticated");
			
		}
		
		//else{ 
		//	//System.out.println("failed");
			
		//}
	
		//}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//return "hi";
}	
}
