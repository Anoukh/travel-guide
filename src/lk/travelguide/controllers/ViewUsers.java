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
	
public User viewuserforname(String name){
		
		DB db;
		
		User us =new User();
		
		try{
		
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("user");
		
		BasicDBObject reg = new BasicDBObject();
		
		
		reg.put("name",new BasicDBObject("$regex", name).append("$options", "i"));
			//obj3.put("placetype",new BasicDBObject("$regex", placetype).append("$options", "i"));
		//	cursor = table.find(reg).limit(5);
	
		
		DBCursor cursor = table.find(reg);
		
		 int countusers = cursor.count();
		 System.out.println( cursor.count()+"  count");
		 //int i =0;
		 String [] UName;
		 if(countusers >5){
			 UName = new String [5]; 
			 countusers =5;
		 }
		 else{
			 UName = new String [countusers]; 
		 }
		for (int i=0 ; i < UName.length;i++){
		if(cursor.hasNext()){
			
		DBObject cs =	cursor.next();
		UName[i] =(String)cs.get("name");
		
		}
		}
		
		for(int k=0;k< UName.length;k++ ){
			System.out.println(UName[k] + "   name");
			
		}
		us.setUsernames(UName);
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return us;
	}
	
public User viewuserfornamelist(String name){
	
	DB db;
	
	User us =new User();
	
	try{
	
	DbConnection obj = new DbConnection();
	db = obj.dbCon();
	
	DBCollection table = db.getCollection("user");
	BasicDBObject searchQuery = new BasicDBObject().append("name",name);
	DBCursor cursor = table.find(searchQuery);
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
