package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest5 {

	public static void main(String[] args) {
		
		Map<String, String> books = new HashMap<>();
		books.put(
		"978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put(
		  "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-0134685991", "Effective Java");
		books.put("978-0321356680", "Effective Java: Second Edition");
		
		Optional<String> optionalIsbn = books.entrySet().stream()
//				  .filter(e -> "Effective Java".equals(e.getValue()))
				  .filter(e -> e.getValue().contains("Effective "))
				  .map(Map.Entry::getKey)
				  .findFirst();
		
		System.out.println(optionalIsbn.get());

		List<String> isbnCodes = books.entrySet().stream()
				  .filter(e -> e.getValue().startsWith("Effective Java"))
				  .map(Map.Entry::getKey)
				  .collect(Collectors.toList());
		System.out.println(isbnCodes);
		
	}

}
