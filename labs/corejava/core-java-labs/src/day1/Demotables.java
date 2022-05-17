package day1;

import java.util.Scanner;

public class Demotables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the table number which you want to seee");
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
         for(int i=1;i<=10;i++) {
      	int y=x*i;
    	System.out.println(x +"*" + i+"="+y);
}
	}

}
