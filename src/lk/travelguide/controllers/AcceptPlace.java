package lk.travelguide.controllers;

import lk.travelguide.models.PlaceData;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class AcceptPlace {
	
	public void acceptplace(String placename,String placetype){
	DbConnection Dbcon = new DbConnection();
	DB db = Dbcon.dbCon();
	DBCollection table = db.getCollection("place");
	
	
	BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.append("placename",placename);
	searchQuery.append("placetype",placetype);
	
	BasicDBObject update = new BasicDBObject();
	update.append("$set", new BasicDBObject().append("acceptYN", "Y"));
	
	table.update(searchQuery, update);
	System.out.println("updated db");
	
	}
}
