package Day5;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Permormance testing");
long starttime=System.currentTimeMillis();
StringBuffer sbuffer=new StringBuffer("Hello");
for(int i=0;i<100000;i++) {
	sbuffer.append("World");
	
}
System.out.println("sys time for Stringbuffer"+(System.currentTimeMillis() - starttime + " ms"));
StringBuilder sbulder=new StringBuilder("Hello");
for(int i=0;i<100000;i++) {
	sbuffer.append("World");
	
}
System.out.println("sys time for StringBuilder"+(System.currentTimeMillis() - starttime + " ms"));
	}

}
