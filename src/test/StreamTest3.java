package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest3 {

	public static void main(String[] args) {
		State karnataka = new State();
		karnataka.addCity("Bangalore");
		karnataka.addCity("Mysore");

		State punjab = new State();
		punjab.addCity("Chandigarh");
		punjab.addCity("Ludhiana");

		List<State> allStates = Arrays.asList(karnataka, punjab);

		//Java Stream flatMap way
		List<String> allCities = allStates.stream().flatMap(e -> {
				System.out.println("flat:"+e.getCities());
				return e.getCities().stream();
			}).collect(Collectors.toList());
			
		
		System.out.println(allCities);
		
		//legacy way
		allCities = new ArrayList<String>();
		for(State state : allStates) {
			for(String city : state.getCities())
				allCities.add(city);
		}
		System.out.println(allCities);

	}

}


class State {
	private List<String> cities = new ArrayList<>();

	public void addCity(String city) {
		cities.add(city);
	}

	public List<String> getCities() {
		return this.cities;
	}
}
