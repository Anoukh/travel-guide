package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import lk.travelguide.models.CostData;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CostValuesData {
	
	public CostData costvaluesdata(){
	DB db;
	CostData costValue=new CostData();

	try{
		
	DbConnection obj = new DbConnection();
	db = obj.dbCon();
	
	DBCollection table = db.getCollection("cost");
	
	
	
	BasicDBObject searchQuery1 = new BasicDBObject();
	BasicDBObject searchQuery2 = new BasicDBObject();
	
	
	
	//DBObject searchQuery1 = new BasicDBObject();
	searchQuery1.put("costtype","petrol");
	
	//DBObject searchQuery2 = new BasicDBObject();
	searchQuery2.put("costtype","diesel");

	//searchQuery1.put("$and", obj2);
	DBCursor cursor1 = table.find(searchQuery1).limit(1);
	
	//searchQuery2.put("$and", obj2);
	DBCursor cursor2 = table.find(searchQuery2).limit(1);
	//cursor.hasNext()
	
	System.out.println(cursor1);
	System.out.println(cursor2);
	
		
	if(cursor1.hasNext()){
		costValue.setPetrol((double) cursor1.next().get("petrol"));
	}
	
	if(cursor2.hasNext()){
		costValue.setDiesel((double) cursor2.next().get("diesel"));
	}
	

	

	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return costValue;
}
	
}