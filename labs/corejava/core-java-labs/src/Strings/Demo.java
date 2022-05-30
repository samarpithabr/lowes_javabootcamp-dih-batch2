package Strings;
/*Strings are classes inside java.lang package
 * declared by litterals(means declared constant)it is stored in String constant pool
 * if two string variable have same value then both stored in same memory ,memory management is efficient
 * declared using new key word(as new object)
 * if two string variable have same value then both stored in different  memory
 * Strings are immutable
 * 
 */

import java.util.Arrays;

public class Demo {
	/*
	 * Strings are immutable after concatinating s2 with string br s2 value remains
	 * "ramegowda"., if you want you can store that cencatinated string in new
	 * variable so concatinated s1 got stored in new variable s3 as
	 * "samarpitha sharath"
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "samarpitha";
		String s2 = new String("Ramegowda");
		System.out.println(s1);
		System.out.println(s2);
		s2.concat("br");
		System.out.println(s2);
		String s3 = s1.concat("sharath");
		System.out.println("s3"+s3);
		/*
		 * equals in string compare the contents or value of the string
		 * if capital letter mismatch it gives false
		 * f1 and f3 gives true;
		 * f2 and f4(even its stored in object form its value is same so returns true)
		 * if it mismatch it returns false
		 */
		System.out.println("equalll");
		String f1="sam";
		String f2="mark";
		String f3="sam";
		String f4=new String("mark");
		String f5=new String("arpitha");
		String f6="mark";
		String f7=new String("arpitha");
		System.out.println("equalls");
		System.out.println(f6.equalsIgnoreCase(f2));
		System.out.println(f2.equals(f4));
		System.out.println(f1.equals(f3));
		System.out.println(f4.equals(f5));
		System.out.println(f7.equals(f5));
		
		
		/*==operator compares he reference or memory location 
		 * same literal value has same memory
		 * same object value has different reference value
		 * f2 and f4 has same value but in different location
		 * f7and f5 are object have same value but memory location is different
		 * returns true false
		 */
		System.out.println("=======");
		System.out.println(f6==(f2));
		System.out.println(f2==(f4));
		System.out.println(f1==(f3));
		System.out.println(f4==(f5));
		System.out.println(f7==f5);
		
		/*Compareto compres and returns +ve,-ve or 0
		 * 0 if both are equal
		 * +ve if its greater than second
		 * -ve if its lesser
		 * 
		 * 
		 */
		System.out.println("Compareto");
		System.out.println(f6.compareTo(f2));
		System.out.println(f2.compareTo(f4));
		System.out.println(f1.compareTo(f3));
		System.out.println(f4.compareTo(f5));
		System.out.println(f7.compareTo(f5));
		System.out.println(f6.compareTo(f3));
		/*
		 * Concatination is for adding string or int or anything to string
		 * during concatination after string if any mathemetical operation given it prints as same without performing arithemetic 
		 * but not working for me
		 */
		
		String a1="that";
		String a2=a1.concat(1+18+45+"isis"+(37-32)+true);
		System.out.println(a2);
		
		
		/*Substring is a method of string 
		 * substring(index) from which index substring should be formed
		 * substring(start index,end index) from which index to start and which index to end		 * 
		 * it starts from 0 and adds on space
		 *" welcome to new world of java" 8th position is t and o/p is to new world of java
		 *
		 */
		
		System.out.println("''''subString'''''''''");
		String str="welcome to new world of java";
		System.out.println(str.substring(8));
		System.out.println(str.substring(9,18));
		/*Split  divides string exactly on one point and make 2 string as 2 array
		 * samarpitha@gmail.com splits("@")
		 * makes 2 split samarpitha and gmail.com
		 * into Arrays.toString
		 * 
		 */
		System.out.println("........split.......");
		String str1="samarpithabr@gmail.com";
		String[] strstr=str1.split("@");
		System.out.println(Arrays.toString(strstr));
		
		/*StringBuffer(aird) is for making string String Muttable
		 * it has functions like append ,insert,reverse,delete,(aird)
		 * it has threadsafe and less efficient
		 * 
		 */
		
		
		System.out.println("*****StringBuilder******");
		StringBuffer sb=new StringBuffer("sam");
		System.out.println(sb+" string buffer");
		sb.append("hello");
		System.out.println(sb+" append");
		sb.insert(3,"world");
		System.out.println(sb+" insert");
		sb.reverse();
		System.out.println(sb+" reverse");
		sb.delete(2, 5);
		System.out.println(sb+" delete");
		

		/*StringBuilder(aird) is for making string String Muttable
		 * it has functions like append ,insert,reverse,delete,(aird)
		 * it is not thread safe and more efficient efficient
		 * 
		 */
		System.out.println("******String Builder******");
		StringBuilder sb1=new StringBuilder("sam");
		System.out.println(sb1+" string buffer");
		sb1.append("hello");
		System.out.println(sb1+" append");
		sb1.insert(3,"world");
		System.out.println(sb1+" insert");
		sb1.reverse();
		System.out.println(sb1+" reverse");
		sb1.delete(2, 5);
		System.out.println(sb1+" delete");
		
		
		/*Performance check between Buffer and builder
		 * String Builder tkes more time buffer takes less time
		 * 
		 */
		
		  System.out.println("Performance Test"); long startTime =
		  System.currentTimeMillis(); StringBuffer stringBuffer = new
		  StringBuffer("Hello"); for (int i = 0; i < 100000; i++) {
		  stringBuffer.append("World"); }
		  System.out.println("Time taken by StringBuffer: " +
		  (System.currentTimeMillis() - startTime + " ms"));
		  
		  System.out.println("**************************************");
		  
		  startTime = System.currentTimeMillis(); StringBuilder stringBuilder = new
		  StringBuilder("Hello"); for (int i = 0; i < 100000; i++) {
		  stringBuilder.append("World"); }
		  System.out.println("Time taken by StringBuilder: " +
		  (System.currentTimeMillis() - startTime + " ms"));
		 
		
	}

}
