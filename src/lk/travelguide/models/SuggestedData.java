package lk.travelguide.models;

public class SuggestedData {
	private String[] place;
	

	public void setPlacename(String[] placename){
		System.out.println(placename.length);
		place =new String[placename.length];
		for(int i=0;i<placename.length;i++){
			place[i] = placename[i];
		}
	}
	

	public String[] getPlacename(){
		return place;
	}
}
