package lk.travelguide.controllers;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class RejectPlace {

	public void rejectplace(String placename,String placetype){
	DbConnection Dbcon = new DbConnection();
	DB db = Dbcon.dbCon();
	DBCollection table = db.getCollection("place");
	
	
	BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.append("placename",placename);
	searchQuery.append("placetype",placetype);
	
	table.remove(searchQuery);
	System.out.println("updated db");
	
	}
}
