


public class main {
	public static void main (String[] args){
		List myList = new List();
		
		String strA = "a";
		String strB = "b";
		String strC1 = "c";
		String strC2 = "C";
		String strD = "d";
		String str1 = "?";
		
		System.out.println("Adding b");
		myList.add(strB);
		print(myList);
		
		System.out.println("Adding a");
		myList.add(strA);
		print(myList);
		
		System.out.println("Adding a");
		myList.add(strA);
		print(myList);
		
		System.out.println("Adding c");
		myList.add(strC1);
		print(myList);
		
		System.out.println("Adding C");
		myList.add(strC2);
		print(myList);
		
		System.out.println("Adding ?");
		myList.add(strD);
		print(myList);
		
		System.out.println("Adding d");
		myList.add(str1);
		print(myList);
		
		System.out.println("Get 0");
		System.out.println(myList.get(0));
		System.out.println("\n");
		
		System.out.println("Get -1");
		System.out.println(myList.get(-1));
		System.out.println("\n");
		
		System.out.println("Get 2");
		System.out.println(myList.get(2));
		System.out.println("\n");

		System.out.println("Get 100");
		System.out.println(myList.get(100));
		System.out.println("\n");
		
		System.out.println("Find a");
		System.out.println(myList.find("a"));
		System.out.println("\n");
		
		System.out.println("Find C");
		System.out.println(myList.find("C"));
		System.out.println("\n");
		
		System.out.println("Add 100 words");
		for (int i=0; i<100; i++)
			myList.add("?word" + i);
		print(myList);
		
		System.out.println("Get size");
		System.out.println(myList.getSize());
		System.out.println("\n");
		
		System.out.println("Get #words");
		System.out.println(myList.getNumWords());
		System.out.println("\n");
		
		System.out.println("Get 0");
		System.out.println(myList.get(0));
		System.out.println("\n");
		
		System.out.println("Get 100");
		System.out.println(myList.get(100));
		System.out.println("\n");
		
		System.out.println("Add another 100 words");
		for (int i=0; i<100; i++)
			myList.add("word" + i);
		print(myList);
		
		System.out.println("Get size");
		System.out.println(myList.getSize());
		System.out.println("\n");
		
		System.out.println("Get #words");
		System.out.println(myList.getNumWords());
		System.out.println("\n");
		
		System.out.println("Get 200");
		System.out.println(myList.get(100));
		System.out.println("\n");
		
		System.out.println("Get 204");
		System.out.println(myList.get(204));
		System.out.println("\n");
	}
	
	public static void print(List list){
		System.out.println("*************");
		System.out.println("#Words: " + list.getNumWords());
		System.out.print(list.toString());
		System.out.println("\n*************\n\n");
	}
}
