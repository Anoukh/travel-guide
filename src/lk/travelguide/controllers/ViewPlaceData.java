package lk.travelguide.controllers;

import lk.travelguide.models.PlaceData;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ViewPlaceData {
	
	public PlaceData retrivePlaceData(String place){
	DB db;
	DbConnection dbobj = new DbConnection();
		
	db = dbobj.dbCon();
	
	DBCollection table = db.getCollection("place");
	
	BasicDBObject searchQuery = new BasicDBObject().append("placename",place);
	
	DBCursor cursor = table.find(searchQuery);
	PlaceData pdobj = new PlaceData(); 
	if(cursor.hasNext()){
		DBObject cs = cursor.next();
		
		String placetype = (String)cs.get("placetype");
		String placecity = (String)cs.get("placecity");
		String placedes = (String)cs.get("placedes");
		float lat = (float)cs.get("lat");
		float lng = (float)cs.get("lng"); 
		String placerating = (String)cs.get("placerating");
		String placeimagepath = (String)cs.get("placeimagepath");
		String placecharge= (String)cs.get("placecharge");
		String lastupdate = (String)cs.get("lastupdate");
	
		
		pdobj.setPlacename(place);
		pdobj.setPlacetype(placetype);
		pdobj.setPlacecity(placecity);
		pdobj.setPlacedes(placedes);
		pdobj.setLatitude(lat);
		pdobj.setLongitude(lng);
		pdobj.setRating(placerating);
		pdobj.setImagepath(placeimagepath);
		pdobj.setPlacecharge(placecharge);
		pdobj.setLastupdate(lastupdate);
	}
	return pdobj;
	}
}
