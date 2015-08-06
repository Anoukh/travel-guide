package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UpdataPlace {

public void updateplacedetails(String placetype,String placename,String placedes,String placecharge ){
	System.out.println("h1");
	
	boolean auth ;
	DB db;
	String message = null;
	
	try{
	
	DbConnection obj = new DbConnection();
	db = obj.dbCon();
	
	DBCollection table = db.getCollection("place");
	
	BasicDBObject searchQuery = new BasicDBObject().append("placename",placename)
												.append("placetype", placetype);
	List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
	BasicDBObject obj3 = new BasicDBObject();
	obj3.append("$set", new BasicDBObject().append("placedes",placedes).append("placecharge", placecharge));


	System.out.println(searchQuery);
	
	obj2.add(new BasicDBObject("placename", placename));
	obj2.add(new BasicDBObject("placetype", placetype));

	DBObject update = new BasicDBObject("$set", obj3);

	//obj2.add(new BasicDBObject("placename", placename));
	//obj2.add(new BasicDBObject("placetype", placetype));
	
	
	//DBObject update = new BasicDBObject("$set", obj3);

	table.update(searchQuery, obj3);
	
	
	
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}	
	
}
