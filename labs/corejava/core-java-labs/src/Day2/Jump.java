package Day2;

public class Jump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
for(int i=3;i<10;i++) {
	System.out.println(i);
	if(i==5) {
		System.out.println("ended at 5");
		break;
	}

}
System.out.println("out break for loop");

for(int j=4;j<9;j++) {
	System.out.println(j);
	if(j==7) {
		System.out.println("continuing 7");
		continue;
	
	}
}
System.out.println("out from continue for loop");
	}

}
