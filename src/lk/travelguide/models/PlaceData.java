package lk.travelguide.models;

public class PlaceData {
	private String placetype;
	private String placename;
	private String placecity;
	private String placedes;
	private Double lat;
	private Double lng;
	private String rating;
	private String placecharge;
	private String lastupdate;
	private String acceptYN;
	private static String imagepath;
	private int noofrates;
	
	
	public void setPlacetype(String placetype){
		this.placetype = placetype;
	}
	
	public void setPlacename(String placename){
		this.placename = placename;
	}
	
	public void setPlacecity(String placecity){
		this.placecity = placecity;
	}
	
	public void setPlacedes(String placedes){
		this.placedes = placedes;
	}
	
	public void setLatitude(Double lat){
		this.lat = lat;
	}
	
	public void setLongitude(Double lng){
		this.lng = lng;
	}
	
	public void setRating(String rating){
		this.rating = rating;
	}
	
	public void setPlacecharge(String placecharge){
		this.placecharge = placecharge;
	}
	
	public void setLastupdate(String lastupdate){
		this.lastupdate = lastupdate;
	}
	
	public void setAcceptYN(String acceptYN){
		this.acceptYN = acceptYN;
	}
	
	public void setImagepath(String imagepath){
		this.imagepath = imagepath;
	}
	
	public void setNoofrates(int noofrates){
		this.noofrates = noofrates;
	}
	
	
	public String getPlacetype(){
		return placetype;
	}
	
	public String getPlacename(){
		return placename;
	}
	
	public String getPlacecity(){
		return placecity;
	}
	
	public String getPlacedes(){
		return placedes;
	}
	
	public String getPlacecharge(){
		return placecharge;
	}
	
	public Double getLatitude(){
		return lat;
	}
	
	public Double getLongitude(){
		return lng;
	}
	
	public String getRating(){
		return rating;
	}
	
	public String getAcceptYN(){
		return acceptYN;
	}
	
	public String getLastupdate(){
		return lastupdate;
	}
	
	public String getImagepath(){
		return imagepath;
	}
	
	public int getNoofrates(){
		return noofrates;
	}
	
}
