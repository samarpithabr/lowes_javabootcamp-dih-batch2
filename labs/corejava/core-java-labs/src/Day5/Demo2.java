package Day5;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
StringBuffer sb=new StringBuffer();
System.out.println(sb.capacity());
sb.append("hello sam welcome to delaware");
System.out.println(sb.capacity());
//formula to find capacity is=(deafault capacity *2+2, and	deafault capacity is 16}
StringBuffer sub=new StringBuffer("hi delaware");
System.out.println(sb.compareTo(sub));
	}
}
