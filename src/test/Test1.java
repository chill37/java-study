package test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("hello");
		
		String[] testStr = new String[]
                {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"};
		int ans = points(testStr);
		System.out.println(ans);

	}
	
	public static int points(String[] games) {
		int points=0;
		for(String game: games) {
			String[] score = game.split(":");
			int x = Integer.parseInt(score[0]);
			int y = Integer.parseInt(score[1]);
			if(x>y)
				points+=3;
			else if (x==y)
				points++;
		}
		return points;
    }
	
	public static String greet(String language){
		Map<String, String> map = create();
		
		if(map.containsKey(language)) {
			return map.get(language);
		}else {
			return "Welcome";
		}
		
		
		
   }
	
	public static Map<String, String> create() {
		Map<String, String> map = new HashMap<>();
		map.put("english", "Welcome");
		map.put("czech", "Vitejte");
		return map;
	}

}
