package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamComparator {

	public static void main(String[] args) {
		
		List<Human> humans = new ArrayList<>(Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12)));
		System.out.println(humans.get(0).getName());

		humans.sort( (Human h1, Human h2) -> h1.getName().compareTo(h2.getName()) );
		System.out.println(humans.get(0).getName());
		
		Collections.sort(humans, new Comparator<Human>() {
	        @Override
	        public int compare(Human h1, Human h2) {
	            return h1.getName().compareTo(h2.getName());
	        }
	    });
		System.out.println(humans.get(0).getName());
		
		humans.sort(Human::compareByNameThenAge);
		System.out.println(humans.get(0).getName());
		
		test();
		
	}
	
	public static void test() {
		
		List<Human> humans = new ArrayList<>(Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12)));
		System.out.println(humans.get(0).getName());
		
		humans.sort(Human::compareByNameThenAge);
		System.out.println(humans.get(0).getName());
		
	}
	
	
	
	public static class Human {
	    public String name;
	    public int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Human(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public static int compareByNameThenAge(Human lhs, Human rhs) {
		    if (lhs.name.equals(rhs.name)) {
		        return lhs.age - rhs.age;
		    } else {
		        return lhs.name.compareTo(rhs.name);
		    }
		}
	}
	

}


