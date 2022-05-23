package day6;

public class Demo3 {
static void minNumber(int arry[]) {
	int min=arry[0];
	for(int i=1;i<arry.length;i++) {
		if(min>arry[0]) {
			min=arry[0];	
		}
	}
	System.out.println(min);
}
	public static void main(String args[]) {
		int[] arry= {56,78,33,21};
		minNumber(arry);
	}
}
