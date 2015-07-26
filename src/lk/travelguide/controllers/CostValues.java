package lk.travelguide.controllers;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CostValues {

	
public void insertcostvalues(float petrol,float diesel)	{
	
	boolean auth ;
	DB db;
	
	
	
	try{
		DbConnection ob = new DbConnection();
		db = ob.dbCon();
		
		DBCollection table = db.getCollection("cost");
		
		System.out.println("hi1");

		DBObject petrolinsertobj = new BasicDBObject();
		DBObject dieselinsertobj = new BasicDBObject();
		
		DBObject searchQuery1 = new BasicDBObject();
		searchQuery1.put("petrol","");
		
		DBObject searchQuery2 = new BasicDBObject();
		searchQuery2.put("diesel","");
		
		DBCursor cursor1 = table.find(searchQuery1);
		DBCursor cursor2 = table.find(searchQuery2);
		//System.out.println(cursor1);
		
		if(cursor2.hasNext()){
			System.out.println("hi3");
			//DBObject dieselinsertobj = new BasicDBObject();
			dieselinsertobj.put("diesel", diesel);
			table.update(searchQuery2, dieselinsertobj);



		}
		
		
		else{
			dieselinsertobj.put("diesel", diesel);
		
			table.insert(dieselinsertobj);
			System.out.println("hi55");
		}

		
		if(cursor1.hasNext()){
			System.out.println("hi2");
			
			//DBObject petrolinsertobj = new BasicDBObject();
			petrolinsertobj.put("petrol", petrol);
			table.update(searchQuery1, petrolinsertobj);
		}
		
		else{
		//	System.out.println("hi44");
			petrolinsertobj.put("petrol", petrol);
		
			table.insert(petrolinsertobj);

		}
		
		
				
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  
	
	
	
}
	
}
