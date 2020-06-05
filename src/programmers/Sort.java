package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

	public static void main(String[] args) {
		
		kNumberTest();
		System.out.println("==============");
		biggestNoTest();

	}
	
	public static void kNumberTest() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = kNumber(array, commands);
		Arrays.stream(answer).forEach(System.out::println);
	}
	
	// array					commands							return
	// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
	// sublist from 2 to 5, sort, 3rd number
	public static int[] kNumber(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	
        	int[] command = commands[i];
        	List<Integer> list = Arrays.stream(array)
        			.skip(command[0]-1).limit(command[1]-command[0]+1)
        			.boxed()
        			.collect(Collectors.toList());
        	Collections.sort(list);
        	answer[i] = list.get(command[2]-1);
        	
        }
        
        return answer;
    }
	
	public static void biggestNoTest() {
		int[] array = {6, 10, 2};
		biggestNo(array);
	}
	public static String biggestNo(int[] numbers) {
        String answer = "";
        
        int a=99;
        char aa= String.valueOf(a).charAt(0);
        System.out.println(aa);
        
//        Arrays.stream(numbers).
        
        return answer;
    }

}
