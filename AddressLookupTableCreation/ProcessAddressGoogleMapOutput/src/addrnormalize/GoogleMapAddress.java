package addrnormalize;

public class GoogleMapAddress {
	public class Result{
		AddressComponent[] address_components;
	}
	
	public class AddressComponent{
		String long_name;
		String short_name;
		String[] types;
	}
	
	String formatted_address;
	
	Result[] results;
	
	public void printCSVRows(){
		
		
		for(Result result: results){
			String city = "";
			String street = "";
			String number = "";
			String postal_code = "";
			
			for(AddressComponent comp: result.address_components){
				for(String type: comp.types){
					if(type.equals("street_number"))
						number = comp.short_name;
					else if(type.equals("route"))
						street = comp.short_name;
					else if(type.equals("locality"))
						city = comp.long_name;
					else if(type.equals("postal_code"))
						postal_code = comp.long_name;
				}
			}
			
			if(city.equals("Windsor") && !number.equals("")){
				System.out.println("\"" + number + " " + street 
						+ "\", \"" + city +"\", \"" + postal_code + "\"");
				
			}
		}
	}

}
