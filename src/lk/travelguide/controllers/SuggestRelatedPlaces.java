package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import lk.travelguide.models.TravelSuggestPlacesData;;

public class SuggestRelatedPlaces {

	
	public TravelSuggestPlacesData sugrelplaces(String placename){
		
	//	boolean auth ;
		DB db;
		String message = null;
		TravelSuggestPlacesData trvsugdata = new TravelSuggestPlacesData() ;
		
		try{
		
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("place");
		
		List<BasicDBObject> orList = new ArrayList<BasicDBObject>();
		List<BasicDBObject> andList = new ArrayList<BasicDBObject>();
		BasicDBObject searchQuery = new BasicDBObject();
		//ArrayList orList = new ArrayList();
		//ArrayList andList = new ArrayList();
		//searchQuery.put("placename", placename);
		
		orList.add(new BasicDBObject("placetype", "Leisure"));                  
		orList.add(new BasicDBObject("placetype", "Religious"));
	//	searchQuery.put("$and", orList);
		//andList.add(new BasicDBObject("gender", "male"));
		andList.add(new BasicDBObject("placename", placename));
		//andList.add(new BasicDBObject("acceptYN", "N"));
		andList.add(new BasicDBObject("$and", orList));
		
		//searchQuery.put("$and", orList);
		BasicDBObject query = new BasicDBObject("$or", andList);
		
		DBCursor cursor = table.find(query);
		
		System.out.println(cursor);
		//cursor.hasNext();
		String city = "";
		String placetype = "";
		if(cursor.hasNext()){
		DBObject cs =	cursor.next();
		city =(String)cs.get("placecity");
		placetype = (String)cs.get("placetype");
		System.out.println(city);
	
		}
		else{
			System.out.println("Nothing Accepted");
			
		}
		/////  sugrelRests
		trvsugdata = sugrelhotels(city, table);
		//String[] st =trvsugdata.getSuggestHotels();
		//System.out.println(st[0]);
		trvsugdata = sugrelrests(city, trvsugdata, table);
		
		
		trvsugdata = sugrelleisure(city, trvsugdata, table);
		
		//trvsugdata = sugrelreligious(city, trvsugdata, table);
		
		
		
		//String[] st4 =trvsugdata.getSuggestReligious();
		//System.out.println(st4[0]);
		/*BasicDBObject searchQuery2 = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		obj2.add(new BasicDBObject("placecity", city));
		obj2.add(new BasicDBObject("placetype", placetype));
		searchQuery2.put("$and", obj2);
		
		DBCursor cursor2 = table.find(searchQuery2).sort(new BasicDBObject("placerating", -1)).limit(10);
		
		System.out.println(cursor2);
		
		while(cursor2.hasNext()){
			DBObject cs2 =cursor2.next();
			System.out.println(cs2.get("placename"));
			
		}*/
		//BasicDBObject searchQuery = new BasicDBObject().append("placename",placename)
		//											..append("placetype", placetype);
		//List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		//BasicDBObject obj3 = new BasicDBObject();
		//obj3.append("$set", new BasicDBObject().append("placedes",placedes).append("placecharge", placecharge));
		 
		
		//System.out.println(searchQuery);

		//obj2.add(new BasicDBObject("placename", placename));
		//obj2.add(new BasicDBObject("placetype", placetype));
		
		
		//DBObject update = new BasicDBObject("$set", obj3);
		//table.update(searchQuery, obj3);
		
		
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//String [] stt=trvsugdata.getSuggestHotels();
		//System.out.println(stt[0]);
		return trvsugdata;
	}
	
	public TravelSuggestPlacesData sugrelhotels(String placecity,DBCollection table ){
		TravelSuggestPlacesData trvpl = new TravelSuggestPlacesData();
		String[] SugHotels;
		double[] SugHotelslnglat;
		int i =0;
	
	try{
	
		BasicDBObject searchQuery2 = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		obj2.add(new BasicDBObject("placecity", placecity));
		obj2.add(new BasicDBObject("placetype", "Hotel"));
		searchQuery2.put("$and", obj2);
		
		DBCursor cursor2 = table.find(searchQuery2).sort(new BasicDBObject("placerating", -1)).limit(3);
		//System.out.println(cursor2.count());
		//if(cursor2.count()>3){
		//	SugHotels =new String[3];
		//	SugHotelslnglat =new double[6];
		//}
		//else
		{
			SugHotels =new String[cursor2.count()];	
			SugHotelslnglat =new double[2*cursor2.count()];	
		}
		
		System.out.println(cursor2);
		
		while(cursor2.hasNext()){
			
			DBObject cs2 =cursor2.next();
			//System.out.println(cs2.get("placename"));
			SugHotels[i] =(String)cs2.get("placename");
			SugHotelslnglat[2*i] =(double)cs2.get("lng");
			SugHotelslnglat[2*i+1] =(double)cs2.get("lat");
			i++;
		}	
		//System.out.println(SugHotels);
		
		trvpl.setSuggestHotels(SugHotels);
		trvpl.setSugHotelsLonLat(SugHotelslnglat);
	}	
		
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return trvpl;
	}
	
	public TravelSuggestPlacesData sugrelrests(String placecity,TravelSuggestPlacesData trvpl,DBCollection table ){
		
		String[] SugRests;
		double[] SugRestslnglat;
		int i =0;
	try{
	
		BasicDBObject searchQuery2 = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		obj2.add(new BasicDBObject("placecity", placecity));
		obj2.add(new BasicDBObject("placetype", "Restaurant"));
		searchQuery2.put("$and", obj2);
		
		DBCursor cursor2 = table.find(searchQuery2).sort(new BasicDBObject("placerating", -1)).limit(3);
		
		if(cursor2.count()>3){
			SugRests =new String[3];
			SugRestslnglat =new double[6];
		}
		else{
			SugRests =new String[cursor2.count()];	
			SugRestslnglat =new double[2*cursor2.count()];	
		}
		
		System.out.println(cursor2);
		
		while(cursor2.hasNext()){
			DBObject cs2 =cursor2.next();
			SugRests[i] =(String)cs2.get("placename");
			SugRestslnglat[2*i] =(double)cs2.get("lng");
			SugRestslnglat[2*i+1] =(double)cs2.get("lat");
			i++;
		}	
		
		trvpl.setSuggestRests(SugRests);
		trvpl.setSugRestsLonLat(SugRestslnglat);
	}	
		
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return trvpl;
	}
	
	
	public TravelSuggestPlacesData sugrelleisure(String placecity,TravelSuggestPlacesData trvpl,DBCollection table ){
		
		String[] SugLeisure;
		double[] SugLeisurelnglat;
		int i =0;
	try{
	
		BasicDBObject searchQuery2 = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		obj2.add(new BasicDBObject("placecity", placecity));
		obj2.add(new BasicDBObject("placetype", "Leisure"));
		searchQuery2.put("$and", obj2);
		
		DBCursor cursor2 = table.find(searchQuery2).sort(new BasicDBObject("placerating", -1)).limit(3);
		
		if(cursor2.count()>3){
			SugLeisure =new String[3];
			SugLeisurelnglat =new double[6];
		}
		else{
			SugLeisure =new String[cursor2.count()];	
			SugLeisurelnglat =new double[2*cursor2.count()];	
		}
		
		System.out.println(cursor2);
		
		while(cursor2.hasNext()){
			DBObject cs2 =cursor2.next();
			SugLeisure[i] =(String)cs2.get("placename");
			SugLeisurelnglat[2*i] =(double)cs2.get("lng");
			SugLeisurelnglat[2*i+1] =(double)cs2.get("lat");
			i++;
		}	
		
		trvpl.setSuggestLeisure(SugLeisure);
		trvpl.setSugLeisureLonLat(SugLeisurelnglat);
	}	
		
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return trvpl;
	}
	
	
public TravelSuggestPlacesData sugrelreligious(String placecity,TravelSuggestPlacesData trvpl,DBCollection table ){
		
		String[] SugReligious;
		double[] SugReligiouslnglat;
		int i =0;
	try{
	
		BasicDBObject searchQuery2 = new BasicDBObject();
		List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
		
		obj2.add(new BasicDBObject("placecity", placecity));
		obj2.add(new BasicDBObject("placetype", "Religious"));
		searchQuery2.put("$and", obj2);
		
		DBCursor cursor2 = table.find(searchQuery2).sort(new BasicDBObject("placerating", -1)).limit(3);
		
		if(cursor2.count()>3){
			SugReligious =new String[3];
			SugReligiouslnglat =new double[6];
		}
		else{
			SugReligious =new String[cursor2.count()];	
			SugReligiouslnglat =new double[2*cursor2.count()];	
		}
		
		System.out.println(cursor2);
		
		while(cursor2.hasNext()){
			DBObject cs2 =cursor2.next();
			SugReligious[i] =(String)cs2.get("placename");
			SugReligiouslnglat[2*i] =(double)cs2.get("lng");
			SugReligiouslnglat[2*i+1] =(double)cs2.get("lat");
			i++;
		}	
		
		trvpl.setSuggestRests(SugReligious);
		trvpl.setSugRestsLonLat(SugReligiouslnglat);
	}	
		
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return trvpl;
	}
	
}
	

