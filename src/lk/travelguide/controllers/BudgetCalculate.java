package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import lk.travelguide.models.PlaceChargesData;
import lk.travelguide.models.User;

public class BudgetCalculate {

	
public PlaceChargesData calculateBudget(String [] SelHotels, String [] SelRests){	
	DB db;
	//String message = null;
	
	PlaceChargesData plcharge =new PlaceChargesData();
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
	
	
	plcharge = calculateHotelCharge(SelHotels, plcharge, table);
	plcharge = calculateRestCharge(SelRests, plcharge, table);

	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
return plcharge;
}

public PlaceChargesData calculateHotelCharge(String [] SelHotels,PlaceChargesData plchdata,DBCollection table){
	String [][] HotelCharges;
	String [] HCharges;
	
	System.out.println("hotelCAL");
	
	if(SelHotels.length != 0){
		HCharges =new String [SelHotels.length];
	
		
		for(int i=0 ; i< SelHotels.length ;i++ ){
			System.out.println(SelHotels[i]);
			
			BasicDBObject searchQuery = new BasicDBObject();
			List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
			obj2.add(new BasicDBObject("placetype", "Hotel"));
			obj2.add(new BasicDBObject("placename", SelHotels[i]));
			searchQuery.put("$and", obj2);
			
			DBCursor cursor = table.find(searchQuery);
			//cursor.hasNext()
			
			System.out.println(cursor);
			
			if(cursor.hasNext()){
				//System.out.println("hi");
				//DBObject cs = cursor.next();
				//System.out.println((String)cursor.next().get("placecharge")+"*");
				
				HCharges[i] = (String)cursor.next().get("placecharge");
				
			}
			
	}	
		for (int k=0;k<SelHotels.length;k++){
			System.out.println(HCharges[k]);
		}
		
		HotelCharges =new String [2][HCharges.length];
		
		
		
		for(int j=0;j< HotelCharges[0].length;j++){
			HotelCharges[0][j] = SelHotels[j];
			HotelCharges[1][j] = HCharges[j];
		}	
		
		
		plchdata.setHotelCharges(HotelCharges);
		
	}
	
	
	return plchdata;
}


public PlaceChargesData calculateRestCharge(String [] SelRests,PlaceChargesData plchdata,DBCollection table){
	
	String [][] RestCharges;
	String [] RCharges;
	
	//System.out.println("hotelCAL");
	
	if(SelRests.length != 0){
		RCharges =new String [SelRests.length];
	
		
		for(int i=0 ; i< SelRests.length ;i++ ){
			System.out.println(SelRests[i]);
			
			BasicDBObject searchQuery = new BasicDBObject();
			List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
			obj2.add(new BasicDBObject("placetype", "Restaurant"));
			obj2.add(new BasicDBObject("placename", SelRests[i]));
			searchQuery.put("$and", obj2);
			
			DBCursor cursor = table.find(searchQuery);
			//cursor.hasNext()
			
			System.out.println(cursor);
			
			if(cursor.hasNext()){
				//System.out.println("hi");
				//DBObject cs = cursor.next();
				//System.out.println((String)cursor.next().get("placecharge")+"*");
				
				RCharges[i] = (String)cursor.next().get("placecharge");
				
			}
			
	}	
	//	System.out.println(RCharges.length+"  length");
//		for (int k=0;k<SelRests.length;k++){
//			System.out.println(RCharges[k]);
//		}
		
		RestCharges =new String [2][RCharges.length];
		
//		for(int j=0;j< RestCharges[0].length;j++){
//			System.out.println(RestCharges[0][j]);
//			System.out.println(RestCharges[1][j]);
//		}	
		
		for(int j=0;j< RestCharges[0].length;j++){
			RestCharges[0][j] = SelRests[j];
			RestCharges[1][j] = RCharges[j];
		}	
		
		
		plchdata.setRestCharges(RestCharges);
		
	}
	
	
	return plchdata;
}

}
