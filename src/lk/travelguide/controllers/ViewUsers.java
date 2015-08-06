package lk.travelguide.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import lk.travelguide.models.TravelSuggestPlacesData;
import lk.travelguide.models.User;

public class ViewUsers {

	public User viewusernoname(){
		
		DB db;
		
		User us =new User();
		
		try{
		
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("user");
		
		DBCursor cursor = table.find();
		 int countusers = cursor.count();
		 int i =0;
		 String [][] UNameLevel = new String [2][countusers];
		
		while(cursor.hasNext()){
		DBObject cs =	cursor.next();
		UNameLevel[0][i] =(String)cs.get("name");
		UNameLevel[1][i] = (String)cs.get("userlevel");
		i++;
		//System.out.println(city);
	
		}
		
		us.setUsernamelevel(UNameLevel);
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return us;
	}
	
	
}
