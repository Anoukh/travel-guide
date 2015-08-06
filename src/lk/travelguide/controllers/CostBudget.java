package lk.travelguide.controllers;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import lk.travelguide.models.CostData;

public class CostBudget {

	public CostData costtypeBudget(String costtype){
		
		DB db;
		
		CostData cstdta = new CostData();
		
		try{
			DbConnection ob = new DbConnection();
			db = ob.dbCon();
			
			DBCollection table = db.getCollection("cost");
			
			//System.out.println("hi1");

//			BasicDBObject petrolinsertobj = new BasicDBObject();
//			BasicDBObject dieselinsertobj = new BasicDBObject();
//			BasicDBObject petrolvalue =new BasicDBObject();
//			BasicDBObject dieselvalue =new BasicDBObject();

			
			DBObject searchQuery1 = new BasicDBObject();
			searchQuery1.put("costtype",costtype);
			
//			DBObject searchQuery2 = new BasicDBObject();
//			searchQuery2.put("costtype","diesel");
//			
			DBCursor cursor = table.find(searchQuery1);
			//DBCursor cursor2 = table.find(searchQuery2).limit(1);
			System.out.println(cursor);
			
			
			double costvalue =0;	
			
			if(cursor.hasNext()){
				//System.out.println("hi");
				//DBObject cs = cursor.next();
				//System.out.println((String)cursor.next().get("placecharge")+"*");
				
				costvalue = (double)cursor.next().get(costtype);
				
			}
			
			
			System.out.println(costvalue);
			
			
			
			if(costtype.equals("diesel")){
			cstdta.setDiesel(costvalue);		
			}
			if(costtype.equals("petrol")){
				cstdta.setPetrol(costvalue);		
				}
					
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return cstdta;
	}
	
	
}
