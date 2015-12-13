import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lexicographicSorting {
	
	public static void main (String[] args) {
		System.out.println("Test 1");
		test1();
		System.out.println("Test 2");
		test2();
		System.out.println("Test 3");
		test3();
		System.out.println("Test 4");
		test4();
		System.out.println("Test 5");
		test5();
		System.out.println("Test 6");
		test6();
	}
	
	private static ArrayList<String> sort(ArrayList<String> stringList, String sorter) {
		/*
		 * Sort using new comparator.  It measures the weight of each string by using
		 * the index of the sorter as the comparable. 
		*/
		Collections.sort(stringList, new Comparator<Object>() {
			@Override
			public int compare(Object a1, Object a2) {			
				int aScore = 0;
				int bScore = 0;
				String a = a1.toString();
				String b = a2.toString();
				int aLength = a.length();
				int bLength = b.length();
				int smaller;
				if(aLength < bLength) {
					smaller = aLength;
					bScore = bLength - aLength;
				} else {
					smaller = bLength;
					aScore = aLength - bLength;
				}
				for (int i = 0; i < smaller; i++) {
					if(sorter.indexOf(a.toCharArray()[i]) < sorter.indexOf(b.toCharArray()[i])) {
						aScore+=i;
					} else if (sorter.indexOf(a.toCharArray()[i]) > sorter.indexOf(b.toCharArray()[i]))  {
						bScore+=i;
					}
				}
				
				if(aScore< bScore){
					return -1;
				} else if (aScore > bScore){
					return 1;
				}
				return 0;
			}
		});
		
		return stringList;
	}
	
	private static void check(ArrayList<String> sortedList, ArrayList<String> correctList) {
		for (String string : sortedList) {
			System.out.println(string);
		}
		if (sortedList.equals(correctList)) {
			System.out.println("Correct Order!");
		} else {
			System.out.println("Incorrect Order!");
		}
	}
	
	private static void test1 () {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("acb");
		strings.add("abc");
		strings.add("bca");
		ArrayList<String> correctOrder = new ArrayList<>();
		correctOrder.add("abc");
		correctOrder.add("acb");
		correctOrder.add("bca");
		
		String sorter = "abc";
		
		ArrayList<String> sortedList = sort(strings, sorter);
		
		check(sortedList, correctOrder);
	}
	
	private static void test2 () {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("acb");
		strings.add("abc");
		strings.add("bca");
		ArrayList<String> correctOrder = new ArrayList<>();
		correctOrder.add("bca");
		correctOrder.add("acb");
		correctOrder.add("abc");
		
		String sorter = "cba";
		
		ArrayList<String> sortedList = sort(strings, sorter);
		check(sortedList, correctOrder);
	}
	
	private static void test3 () {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("aaa");
		strings.add("aa");
		strings.add("");
		ArrayList<String> correctOrder = new ArrayList<>();
		correctOrder.add("");
		correctOrder.add("aa");
		correctOrder.add("aaa");

		String sorter = "a";

		ArrayList<String> sortedList = sort(strings, sorter);
		check(sortedList, correctOrder);
	}
	
	private static void test4 () {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("aaabc");
		strings.add("aabb");
		strings.add("abc");
		ArrayList<String> correctOrder = new ArrayList<>();
		correctOrder.add("abc");
		correctOrder.add("aabb");
		correctOrder.add("aaabc");

		String sorter = "abc";

		ArrayList<String> sortedList = sort(strings, sorter);
		check(sortedList, correctOrder);
	}
	
	private static void test5 () {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("aababc");
		strings.add("aabbaaa");
		strings.add("abc");
		ArrayList<String> correctOrder = new ArrayList<>();
		correctOrder.add("abc");
		correctOrder.add("aababc");
		correctOrder.add("aabbaaa");
		
		String sorter = "abc";

		ArrayList<String> sortedList = sort(strings, sorter);
		check(sortedList, correctOrder);
	}
	
	private static void test6 () {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("aababa");
		strings.add("aabbaa");
		strings.add("abc");
		ArrayList<String> correctOrder = new ArrayList<>();
		correctOrder.add("abc");
		correctOrder.add("aabbaa");
		correctOrder.add("aababa");
		
		String sorter = "bac";

		ArrayList<String> sortedList = sort(strings, sorter);
		check(sortedList, correctOrder);
	}
}
