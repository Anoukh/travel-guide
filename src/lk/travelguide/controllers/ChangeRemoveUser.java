package lk.travelguide.controllers;

import lk.travelguide.models.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ChangeRemoveUser {

	
	public void changeUserLevel(String username){
		
DB db; 
		
	//	User us =new User();
		
		try{
		
		DbConnection obj = new DbConnection();
		db = obj.dbCon();
		
		DBCollection table = db.getCollection("user");
		
		BasicDBObject searchQuery = new BasicDBObject().append("name",username);
		BasicDBObject update = new BasicDBObject();
		update.append("$set", new BasicDBObject().append("userlevel","Admin"));
		table.update(searchQuery, update);
		
		System.out.println("updated");
		
		
		//us.setUsernamelevel(UNameLevel);
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void removeUser(String username){
		DB db; 
		try{
			
			DbConnection obj = new DbConnection();
			db = obj.dbCon();
			
			DBCollection table = db.getCollection("user");
			
			BasicDBObject searchQuery = new BasicDBObject().append("name",username);
			//BasicDBObject update = new BasicDBObject();
			//update.append("$set", new BasicDBObject().append("userlevel","Admin"));
			table.remove(searchQuery);
			
			System.out.println("removed");
			
			
			//us.setUsernamelevel(UNameLevel);
			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	
}
