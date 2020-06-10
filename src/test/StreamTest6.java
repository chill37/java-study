package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest6 {

	public static void main(String[] args) {
		
		previousNumber();

	}
	
	// saving previous number
	static void previousNumber() {
		List<Integer> sourceList = Arrays.asList(45, 55, 0, 0, 46, 0, 39, 0, 0, 0);

		final Integer[] lastNonZero = new Integer[1]; // stream has no state, so we need a final field to store it
		List<Integer> resultList = sourceList.stream()
		             .peek(integer -> {
		                 if (integer != 0) {
		                     lastNonZero[0] = integer;
		                 }
		             })
		             .map(integer -> lastNonZero[0])
		             .collect(Collectors.toList());

		System.out.println(sourceList); // still the same
		System.out.println(resultList); // prints [45, 55, 55, 55, 46, 46, 39, 39, 39, 39]
	}

}
