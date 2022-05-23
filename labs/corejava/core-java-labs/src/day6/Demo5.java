package day6;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[][]= {{1,2,3},{4,5,6},{7,8,9}};
int b[][]= {{10,20,30},{40,50,60},{70,80,90}};
int c[][]=new int [3][3];
for(int i=0;i<a.length;i++) {
	for(int j=0;j<b.length;j++) {
		c[i][j]=a[i][j]+b[i][j];
	System.out.print(c[i][j] + "  ");	
	}
	System.out.println();
}
	}

}
