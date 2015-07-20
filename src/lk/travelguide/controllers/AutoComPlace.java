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
	
	public static String[] autocompleteplace(String placetype,String placename){
		
		System.out.println(placetype + " " + placename);
		
		String[] places = new String[5];
				
		DB db;
				
		try{
		
		int i =0;	
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("place");
		
		BasicDBObject obj3 = new BasicDBObject();
		obj3.put("placename",new BasicDBObject("$regex", placename).append("$options", "i"));
		obj3.put("placetype",new BasicDBObject("$regex", placetype).append("$options", "i"));
		
		DBCursor cursor = table.find(obj3).limit(5);
		
		if(cursor.hasNext()){
			
			while(cursor.hasNext()){
				DBObject cs =  cursor.next();
				places[i] = (String)cs.get("placename");
				System.out.println(places[i]+ "*");
				i++;
			}
		}
		
		else System.out.println("no cursor");
			
		}
		catch(Exception e){
			e.printStackTrace();	
			
		}
		
		return places;
	}
	
	/*
	public static void main(String[] args){
		String place[]=  new String[5];
		place = autocompleteplace("Hotel","a");
		for(int i=0;i<5;i++){
			System.out.println(place[i]);
		}
	} */

}
