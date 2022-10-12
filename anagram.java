package Data_Structures;

import java.util.Arrays;
import java.util.Scanner;

public class anagram {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the two Strings to check that they are anagram or not");
	String a=sc.next();
	String b=sc.next();
	a=a.replace(" ", " "); // to remove space if present
	b=b.replace(" ", "");
	a=a.toLowerCase();  //use to check the strings of any case .
	b=b.toLowerCase();
	char c[]=a.toCharArray();
	char d[]=b.toCharArray();
	
	Arrays.sort(c);
	Arrays.sort(d);
	boolean res=Arrays.equals(c,d);
	if(res==true) {
		System.out.println("True");
	}
	else {
		System.out.println("False");
	}
	
}
}
