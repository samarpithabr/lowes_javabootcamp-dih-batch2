package concurreny;

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("hello java");
System.out.println(Thread.currentThread().getName());
System.out.println(Thread.currentThread().getPriority());
System.out.println(Thread.currentThread().getState());
Thread.currentThread().setName("default");
	}

}
