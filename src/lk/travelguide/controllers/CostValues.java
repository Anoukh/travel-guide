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

		BasicDBObject petrolinsertobj = new BasicDBObject();
		BasicDBObject dieselinsertobj = new BasicDBObject();
		BasicDBObject petrolvalue =new BasicDBObject();
		BasicDBObject dieselvalue =new BasicDBObject();

		
		DBObject searchQuery1 = new BasicDBObject();
		searchQuery1.put("costtype","petrol");
		
		DBObject searchQuery2 = new BasicDBObject();
		searchQuery2.put("costtype","diesel");
		
		DBCursor cursor1 = table.find(searchQuery1).limit(1);
		DBCursor cursor2 = table.find(searchQuery2).limit(1);
		System.out.println(cursor1.count());
		
		

		
		if(cursor1.hasNext()){

			petrolvalue.append("$set", new BasicDBObject().append("petrol",petrol));
			table.update(searchQuery1, petrolvalue);
			


		}
		
		
		else{
				System.out.println("hi44");
				petrolinsertobj.put("costtype", "petrol");
				petrolinsertobj.put("petrol", petrol);
				
				table.insert(petrolinsertobj);

				}
		
		
		
		if(cursor2.hasNext()){

			dieselvalue.append("$set", new BasicDBObject().append("diesel",diesel));
			table.update(searchQuery2, dieselvalue);
			


		}
		
		
		else{
				System.out.println("hi44");
				dieselinsertobj.put("costtype", "diesel");
				dieselinsertobj.put("diesel", diesel);
				
				table.insert(dieselinsertobj);

				}
	
		
		
				
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  
	
	
	
}
	
}
