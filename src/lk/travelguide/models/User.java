package lk.travelguide.models;

public class User {
	private String name;
	private String password;
	private String email;
	private String user_level;
	private String request_accept;
	private String [][] Usernamelevel;
	private String [] Usernames;
	
	
	
	public void setUsername(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setUser_Level(String user_level){
		this.user_level = user_level;
	}
	
	public void setRequest_Accept(String request_accept){
		this.request_accept = request_accept;
	}
	
	public void setUsernamelevel(String [][] UsersArray){
		Usernamelevel =new String[UsersArray.length][UsersArray[0].length];	
		for(int i=0;i<UsersArray[0].length;i++){
			Usernamelevel[0][i] = UsersArray[0][i];
			Usernamelevel[1][i] = UsersArray[1][i];
		}
	}
	
	public void setUsernames(String [] UsersNamesArray){
		Usernames =new String[UsersNamesArray.length];	
		for(int i=0;i<UsersNamesArray.length;i++){
			Usernames[i] = UsersNamesArray[i];
			
		}
	} 
	
	public String [] getUsernames(){
		return Usernames;
	}
	
	
	
	public String [][] getUsernamelevel(){
		return Usernamelevel;
	}
	
	
	public String getUsername(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getUser_Level(){
		return user_level;
	}
	
	public String getRequest_Accept(){
		return request_accept;
	}
}


