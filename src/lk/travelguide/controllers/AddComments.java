package lk.travelguide.controllers;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class AddComments {

	

	public void addcoments(String placename,String placetype,String comment){
	DbConnection Dbcon = new DbConnection();
	DB db = Dbcon.dbCon();
	DBCollection table = db.getCollection("place");
	
	
	BasicDBObject insertQuery = new BasicDBObject();
	insertQuery.append("placename",placename);
	insertQuery.append("placetype",placetype);
	insertQuery.append("comments",comment);
	table.insert(insertQuery);
	System.out.println("added to db");
	
	}
}
