package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BusPlatform {

	public static void main(String[] args) {
		List<String> list = readFileAsList("test.txt");
		calcPrePostBus(list);
		
		String line = readStrAtPrint("test.txt");
		calcBusInfo(line);
	}
	
	private static void calcBusInfo(String line) {
		Map<String, String> map = Arrays.stream(line.split("#")).skip(1)
				.map(v -> v.split(","))
				.collect(Collectors.toMap(k->k[0], v->v[1]));
		
		String bus01 = map.get("BUS01");
		
		Map<String, String> diffMap = map.entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey, v -> {
				int x = Integer.parseInt(v.getValue());
				int y = Integer.parseInt(bus01);
				String r = String.valueOf(x-y);
				return r;
			}));
		
		diffMap.entrySet().stream()
			.forEach(v -> {
				System.out.println(v.getKey());
				System.out.println(v.getValue());
			});
		

		
		
	}

	// Split and put it in Map
	private static void calcPrePostBus(List<String> list) {
		
		String lastline = list.get(list.size()-2);
		
		Map<String, String> map = Arrays.stream(lastline.split("#")).skip(1)
			.map(v -> v.split(","))
			.collect(Collectors.toMap(a->a[0], a->a[1]));
		
		System.out.println(map.get("BUS01"));
		String bus01 = map.get("BUS01");
		
		Map<String, String> map2 = Arrays.stream(lastline.split("#")).skip(1)
				.map(v -> v.split(","))
				.collect(Collectors.toMap(a->a[0], a -> {
					int x = Integer.parseInt(a[1]);
					int y = Integer.parseInt(bus01);
					String r = padLeft(String.valueOf(x-y), 5);
					return r;
				}));
		
		map2.values().parallelStream().forEach(System.out::println);
		
	}

	static String padLeft(String s, int n) {
	    return String.format("%" + n + "s", s).replace(' ', '0');
	}

	private static String readStrAtPrint(String fileName) {
		String line = null;
		String prev = null;
		try {
			File file = new File("./TEXT/", fileName);
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			
			System.out.println("========LIST=========");
			while((line=br.readLine()) != null) {
				if (line.equals("PRINT")) {
					line = prev;
					System.out.println(line);
					break;
				}
				
				prev = line;
			}
			System.out.println("=================");
			br.close();
			
		} catch (Exception e ) {e.printStackTrace();}
		
		return line;
	}

	private static List<String> readFileAsList(String fileName) {
		String line= null;
		List<String> list = new ArrayList<>();
		try {
			File file = new File("./TEXT/", fileName);
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			
			System.out.println("========LIST=========");
			while((line=br.readLine()) != null) {
				System.out.println(line);
				list.add(line);
			}
			System.out.println("=================");
			br.close();
			
		} catch (Exception e ) {e.printStackTrace();}
		return list;
	}

}
