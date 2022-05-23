package arrays;

public class Assign14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp=0;
		int a[]= {23,54,76,98,34,65};
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]<a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
				
			}
		}
		
		System.out.println("Desecnding order");
		for (int i : a) {
			System.out.println(i);
			
		}
	}
	

}

