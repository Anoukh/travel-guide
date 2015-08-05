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
	String message = null;
	/*
	try {
		mongo = new MongoClient( "localhost" , 27017 );
	
	DB db = mongo.getDB("test");*/
	try{
	
	DbConnection obj = new DbConnection();
	db = obj.dbCon();
	
	DBCollection table = db.getCollection("cost");
	
	
	
	BasicDBObject searchQuery = new BasicDBObject();
	List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
	
	
	
	

	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
return null;
}
}
