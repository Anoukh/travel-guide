package lk.travelguide.models;

public class PlaceChargesData {

private String [][] HotelCharges; 	
private String [][] RestCharges; 	
	



public void setHotelCharges(String [][] HCharges){
	HotelCharges =new String[HCharges.length][HCharges[0].length];	
	for(int i=0;i<HCharges[0].length;i++){
		HotelCharges[0][i] = HCharges[0][i];
		HotelCharges[1][i] = HCharges[1][i];
	}
}

public void setRestCharges(String [][] RCharges){
	RestCharges =new String[RCharges.length][RCharges[0].length];	
	for(int i=0;i<RCharges[0].length;i++){
		RestCharges[0][i] = RCharges[0][i];
		RestCharges[1][i] = RCharges[1][i];
	}
}

public String[][] getHotelCharges(){
	return HotelCharges;
}

public String[][] getRestCharges(){
	return RestCharges;
}

}
