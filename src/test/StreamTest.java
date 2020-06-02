package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		// from Array
		String[] arr = new String[]{"a","b","c"};
		Stream<String> stream = Arrays.stream(arr);
		
		// from Collection
		List<String> lists = Arrays.asList("a", "b", "c");
		stream = lists.stream();

		// only Stream Class
		stream = Stream.of("a", "b", "c");
		
		List<String> list = Arrays.asList("a", "a", "ba", "c");
		long count = list.stream() // List<String> to Stream<String>
		                .distinct() // return Stream<String>
		                .count(); // return long
		
		System.out.println(count);
		
		boolean isExist = list.stream().anyMatch(e -> e.contains("b"));
		System.out.println(isExist);
		
		list.stream().reduce("1", (a,b) -> a+b);
		
		List<Integer> integers = Arrays.asList(1, 1, 1);
		Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
		System.out.println(reduced);

		Random random = new Random();
		random.ints().limit(2).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		//get list of unique squares
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);
		
		squaresList = numbers.stream().distinct().map( i -> i*i).collect(Collectors.toList());
		squaresList.forEach(System.out::println);
		
		
		List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers2.stream().mapToInt((x) -> x).summaryStatistics();
		
		
		Stream<Integer> stream3 = Stream.of(1,2,3,4,5,6,7,8,9);
        stream3.forEach(p -> System.out.print(p));
        
        IntStream stream4 = "12345_abcdefg".chars();
        stream4.forEach(p -> System.out.println("A"+p));
        
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
        
        memberNames.stream().filter((s) -> s.startsWith("A"))
        .forEach(System.out::println);
        
        memberNames.stream().filter((s) -> s.startsWith("A"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
        
        Optional<String> reduced2 = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);

        reduced2.ifPresent(System.out::println);
        
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list2.add(i);
        }
        //Here creating a parallel stream
        Stream<Integer> stream5 = list2.parallelStream();  
        Integer[] evenNumbersArr = stream5.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);
        
        Arrays.stream(evenNumbersArr).forEach(System.out::println);
		
        
        String[][] scores = { { "Amit", "70" }, { "Arthit", "60" }, { "Peter", "60" }, { "Arthit", "100" } };

        double highestAvg = Arrays.stream(scores)
        		.collect(Collectors.groupingBy(s -> s[0],
        				Collectors.averagingInt(s->Integer.parseInt(s[1]))))
        		.values().stream().max(Comparator.naturalOrder()).get();
        
        System.out.println(highestAvg);
        
        
        
        
	}

}
