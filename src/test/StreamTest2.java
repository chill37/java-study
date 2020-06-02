package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		
		List<String> lst = new ArrayList<>();
        lst.add("10:00:00#BUS01,02345#BUS02,00800");
        lst.add("10:00:01#BUS01,02362#BUS02,00805");
        lst.add("10:00:02#BUS01,02378#BUS02,00810");
        
        lst.stream()
        	.map(d -> Arrays.stream(d.split("#")))
        	.forEach(System.out::println);
        
        lst.stream()
    	.flatMap(d -> Arrays.stream(d.split("#")))
    	.forEach(e -> {
    		System.out.println(e);
    		
    	});
        
        
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        })
        .forEach((value) -> System.out.println(value))
        ;
        
        
        List<Company> companies = Arrays.asList(
                new Company(Arrays.asList(new Person("Jon Skeet"), new Person("Linus Torvalds"))),
                new Company(Arrays.asList(new Person("Dennis Ritchie"), new Person("Bjarne Stroustrup"))),
                new Company(Arrays.asList(new Person("James Gosling"), new Person("Patrick Naughton")))
        );

        List<String> persons = companies.stream()
                .flatMap(company -> company.getPersons().stream())
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(persons);
        
        
        List<String> l1 = Arrays.asList("a","b");
        List<String> l2 = Arrays.asList("c","d");
        List<String> l = new ArrayList<>();
        l.addAll(l1);
        l.addAll(l2);
        
        List<String> letters = l.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(letters);
        List<String> letters2 = Stream.of(l1,l2).flatMap(List::stream).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(letters2);
        
	}

}

class Company {
	public List<Person> names;
	public Company(List<Person> names) {
		super();
		this.names = names;
	}
	public List<Person> getPersons() {
		return names;
	}
	public void setPersons(List<Person> names) {
		this.names = names;
	}
}

class Person {
	public String name;
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
