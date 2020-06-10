package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest4 {

	// Find most occurred letter
	public static void main(String[] args) {
		
		List <String> wordsList = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");
		
		Map<String, Integer> counts = wordsList.parallelStream().
	            collect(Collectors.toConcurrentMap(
	                w -> w, w -> 1, Integer::sum));
		System.out.println(counts);
		
		
		Map<String, Long> collect = 
		        wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		LinkedHashMap<String, Long> countByWordSorted = collect.entrySet()
	            .stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	            .collect(Collectors.toMap(
	                    Map.Entry::getKey,
	                    Map.Entry::getValue,
	                    (v1, v2) -> {
	                        throw new IllegalStateException();
	                    },
	                    LinkedHashMap::new
	            ));
		System.out.println(countByWordSorted);
		
		String word = "programming";
		String[] words = word.split("");
		Map<String, Integer> cnt = Arrays.asList(words).parallelStream()
				.collect(Collectors.toConcurrentMap(w->w, w->1, Integer::sum));
		System.out.println(cnt);
		
		OptionalInt max = cnt.entrySet().parallelStream()
			.map(Map.Entry::getValue)
			.mapToInt(v->v)
			.max();
		System.out.println(max);
		
		String key = cnt.entrySet().stream()
				.max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
				.get().getKey();
		key = Collections.max(cnt.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
		System.out.println(key);
		

		List<String> maxList = cnt.entrySet().stream()
			.filter(entry -> entry.getValue() == max.getAsInt())
			.map(entry -> entry.getKey())
			.collect(Collectors.toList());
		System.out.println(maxList);
		
	}

}
