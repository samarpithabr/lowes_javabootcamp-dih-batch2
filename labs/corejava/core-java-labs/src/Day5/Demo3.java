package Day5;


public class Demo3 {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("sam");
		System.out.println(sb+" string buffer");
		sb.append("hello");
		System.out.println(sb+" append");
		sb.insert(3,"world");
		System.out.println(sb+" insert");
		sb.reverse();
		System.out.println(sb+" reverse");
		sb.delete(2, 5);
		System.out.println(sb+" delete");
	}

}
