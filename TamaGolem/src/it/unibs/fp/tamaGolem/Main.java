package it.unibs.fp.tamaGolem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {	
		
	//public static final Comparator <String> CASE_INSENSITIVE_ORDER;
	public static Map<String, Integer> bag_setup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	
	//public static HashMap<String,Integer> bag_setup = new HashMap<>();
	public static String s = "Ghost";
	
	public static String x = "Giusto";

	/*
	public static void main(String[] args) {
		bag_setup.put(s, 4);
		bag_setup.put("mario", 47);
		bag_setup.put("pippo", 90);
		bag_setup.put("luigi", 12);

		//stampa hasMap
		bag_setup.entrySet().forEach(System.out::println);	
		System.out.println("----------------------------");
		
		//Integer num = bag_setup.get(s);				
		//bag_setup.put(s, num - 1);
		
		
		//stampa hasMap
		//bag_setup.entrySet().forEach(System.out::println);		

		int correct;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.print("inserire elemento della lista: ");
				String text = scanner.nextLine();
				correct = 0;
				if(bag_setup.containsKey(text)){
					Integer num = bag_setup.get(text);
					bag_setup.put(text, num-1);
					System.out.println(x);
					
				}else {
					System.out.println("errore");
					correct = 1;
				}
				
			}while(correct == 1);
			
		}finally {
			scanner.close();
			
		bag_setup.entrySet().forEach(System.out::println);	

			
			
			
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
	*/
	

	public static void main(String[] args) {
		do {
			UI.runProgram();
		}while(UI.continueGame());
		
	}

	

}

