package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CountIdenticalObjects {

	public static void main(String[] args) {
		
//		List<Integer> values = Arrays.asList(3, 3, 5, 5, 5, 6, 3, 3);
		lambdaCount();
	}
	
//	private static List<ValueCount> counteSameValueInRow(List<Integer> Values) {
//	    List<ValueCount> result = new ArrayList<ValueCount>();
//	    ValueCount valueCount = null;
//
//	    for (int value: Values) {
//	        if (valueCount == null) {
//	            valueCount = new ValueCount(value);
//	        } else if (valueCount.value == value){
//	            valueCount.numberof++;
//	        } else {
//	            result.add(valueCount);
//	            valueCount = new ValueCount(value);
//	        }
//	    }
//	    result.add(valueCount);
//	    return result;
//	}
//	
//	private class ValueCount {
//	    private List<Integer> lista = new ArrayList<>();
//
//	    public String toString() { return "[" + lista.get(0) + "-" + lista.size() + "]";}
//	    public void add(Integer value) { lista.add(value);}
//	    public Integer getFirstValue() { return lista.get(0);}
//	    public void addAll(ValueCount first) { lista.addAll(first.getAll());}
//	    private Collection<? extends Integer> getAll() { return lista;}
//	}
	
	private static void lambdaCount() {
		List<Integer> values = Arrays.asList(3, 3, 5, 5, 5, 6, 3, 3);

		values.stream().collect(LinkedList<List<Integer>>::new, (list, value) -> {
		    if (list.isEmpty() || !list.getLast().get(0).equals(value))
		    {
		        list.add(new ArrayList<>());
		    }
		    list.getLast().add(value);
		}, (list1, list2) -> {
		    if (list1.getLast().get(0).equals(list2.getFirst().get(0)))
		    {
		        list1.getLast().addAll(list2.getFirst());
		        list2.removeFirst();
		    }
		    list1.addAll(list2);
		}).forEach(group -> System.out.println("[" + group.get(0) + "-" + group.size() + "]"));
	}

}


