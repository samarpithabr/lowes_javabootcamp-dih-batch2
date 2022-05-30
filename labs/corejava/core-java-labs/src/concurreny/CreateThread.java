package concurreny;

public class CreateThread {
	public static void main(String[]args) throws InterruptedException {
		System.out.println((Thread.currentThread().getName()));
		DemoThread d1=new DemoThread();
		d1.setName("d1");
		d1.start();
		d1.join();
		DemoThread d2=new DemoThread();
		d2.setName("d2");
		d2.start();
		
	}

}
