package lk.travelguide.models;

public class TravelSuggestPlacesData {
	
private String [] SuggestHotels;
private String [] SuggestRests;
private String [] SuggestLeisure;
private String [] SuggestReligious;
private double [] SugHotelsLonLat;
private double [] SugRestsLonLat;
private double [] SugLeisureLonLat;
private double [] SugReligiousLonLat;


public void setSuggestHotels(String [] HotelsArray){
	SuggestHotels =new String[HotelsArray.length];
	for(int i=0;i<SuggestHotels.length;i++){
		SuggestHotels[i] = HotelsArray[i];
	}
}

public void setSuggestRests(String [] RestsArray){
	SuggestRests =new String[RestsArray.length];
	for(int i=0;i<SuggestRests.length;i++){
		SuggestRests[i] = RestsArray[i];
	}
}

public void setSuggestLeisure(String [] LeisureArray){
	SuggestLeisure =new String[LeisureArray.length];
	for(int i=0;i<SuggestLeisure.length;i++){
		SuggestLeisure[i] = LeisureArray[i];
	}
}

public void setSuggestReligious(String [] ReligiousArray){
	SuggestReligious =new String[ReligiousArray.length];
	for(int i=0;i<SuggestReligious.length;i++){
		SuggestReligious[i] = ReligiousArray[i];
	}
}

public void setSugHotelsLonLat(double [] HotelsArray){
	SugHotelsLonLat =new double[HotelsArray.length];
	for(int i=0;i<SugHotelsLonLat.length;i++){
		SugHotelsLonLat[i] = HotelsArray[i];
	}
}

public void setSugRestsLonLat(double [] RestsArray){
	SugRestsLonLat =new double[RestsArray.length];
	for(int i=0;i<SugRestsLonLat.length;i++){
		SugRestsLonLat[i] = RestsArray[i];
	}
}

public void setSugLeisureLonLat(double [] LeisureArray){
	SugLeisureLonLat =new double[LeisureArray.length];
	for(int i=0;i<SugLeisureLonLat.length;i++){
		SugLeisureLonLat[i] = LeisureArray[i];
	}
}

public void setSugReligiousLonLat(double [] ReligiousArray){
	SugReligiousLonLat =new double[ReligiousArray.length];
	for(int i=0;i<SugReligiousLonLat.length;i++){
		SugReligiousLonLat[i] = ReligiousArray[i];
	}
}

public String[] getSuggestHotels(){
	return SuggestHotels;	
}

public String[] getSuggestRests(){
	return SuggestRests;	
}

public String[] getSuggestLeisure(){
	return SuggestLeisure;	
}

public String[] getSuggestReligious(){
	return SuggestReligious;	
}

public double[] getSugHotelsLonLat(){
	return SugHotelsLonLat;	
}

public double[] getSugRestsLonLat(){
	return SugRestsLonLat;	
}

public double[] getSugLeisureLonLat(){
	return SugLeisureLonLat;	
}

public double[] getSugReligiousLonLat(){
	return SugReligiousLonLat;	
}

}
