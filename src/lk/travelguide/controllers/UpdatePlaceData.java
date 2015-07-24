package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import lk.travelguide.models.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UpdatePlaceData {

	
	public String[] updplaceretdata(String placetype,String placename){
		String [] placedesncharge = new String [2];
		
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
		
		DBCollection table = db.getCollection("place");
		
		
		
		BasicDBObject searchQuery = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		
		
		obj2.add(new BasicDBObject("placename", placename));
		obj2.add(new BasicDBObject("placetype", placetype));
		searchQuery.put("$and", obj2);
		DBCursor cursor = table.find(searchQuery).limit(1);
		//cursor.hasNext()
		
		System.out.println(cursor);
		String placedes ;
		String placecharge ;
		if(cursor.hasNext()){
			DBObject cs = cursor.next();
	System.out.println("authenticating....");
			placedes = (String)cs.get("placedes");
			placecharge = (String)cs.get("placecharge");
			placedesncharge[0] =placedes;
			placedesncharge[1] =placecharge;
		
			
		}
		
		 
		else{ 
			//message ="loginfail";
			
		}
	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return placedesncharge;
	}
}
