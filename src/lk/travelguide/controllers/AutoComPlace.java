package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AutoComPlace {
	
	public String[] autocompleteplace(String placetype,String placename){
		//String places [] = null;
		String[] places = new String[5];
		 int i =0;
		boolean auth ;
		DB db;
		String message = null;
		/*
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		
		DB db = mongo.getDB("test");*/
		try{
		
			//System.err.println(placetype);
			
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("place");
		
		BasicDBObject searchQuery = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		List<BasicDBObject> obj4 = new ArrayList<BasicDBObject>();
		BasicDBObject obj3 = new BasicDBObject();
		obj3.put("placename",new BasicDBObject("$regex", placename).append("$options", "i"));
		//BasicDBObject obj4 = new BasicDBObject();
		
		//BasicDBObject fields = new BasicDBObject("placetype", placetype);
		
		obj2.add(new BasicDBObject("placetype", placetype));
		
		//obj4.putAll((Map) obj3);
		//obj3.put("name", 	new BasicDBObject("$regex", "Mky.*-[1-3]").append("$options", "i"));
		
		//obj4.add(obj2);
		obj4.add(obj3);
		
		//obj2.add(new BasicDBObject("placename", placename));
		
		//searchQuery.put("$and", obj4);
		//searchQuery.put("$and", obj3);
		
		//DBCursor cursor = table.find(searchQuery);
		DBCursor cursor = table.find(obj3).limit(5);
		//DBCursor cr = table.find(obj3).limit(5);
		//cursor.hasNext()
		
		//System.out.println(cursor);
		String pltype;
	//	if(cursor.hasNext())
		while(cursor.hasNext()){
			//i++;
			//i--;
			//System.out.println("start");
			DBObject cs =  cursor.next();
			pltype = (String)cs.get("placetype");
			
		if(pltype.equals(placetype)){	
			places[i] = (String)cs.get("placename");
			System.out.println((String)cs.get("placename"));
			//places[i] ="aaa";
			System.out.println(places[i]);
			System.out.println((String)cs.get("placetype"));
			i++;
		}
		else{
			cs.get("placetype");	
		//System.out.println(places[0]);
		}
		}
		
		
		}
		catch(Exception e){
			e.printStackTrace();	
			
		}
		
		return places;
	}

}
