package lk.travelguide.controllers;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AddRate {

	public String addrate(String placename, String placetype, String rate){
		double newRate = 0;
		double noOfRates = 0;
		DB db;
		DbConnection dbobj = new DbConnection();
			
		db = dbobj.dbCon();
		
		DBCollection table = db.getCollection("place");
		
		BasicDBObject searchQuery = new BasicDBObject().append("placename",placename);
		searchQuery.append("placetype",placetype);
		
		DBCursor cursor = table.find(searchQuery);
		if(cursor.hasNext()){
			
			DBObject cs = cursor.next();
			String prevrate = (String)cs.get("placerating");
			String noofrates = cs.get("noofrates").toString();
			double prevRate = Double.parseDouble(prevrate);
			noOfRates = Double.parseDouble(noofrates);
			double Rate = Double.parseDouble(rate);
			
			newRate = ((prevRate*noOfRates)+Rate)/(noOfRates+1);
			
		}
		
		BasicDBObject update = new BasicDBObject();
		update.append("$set", new BasicDBObject().append("placerating", newRate).append("noofrates", (noOfRates+1)));
		
		table.update(searchQuery, update);
		String NewRate = String.valueOf(newRate);
		return NewRate;
	}
}
