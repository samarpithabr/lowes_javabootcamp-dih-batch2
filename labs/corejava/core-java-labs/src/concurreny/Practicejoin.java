package concurreny;
/*
 * if we dont gve join 
 * main will start and
 *  main will stop and then
 *   thread start and stop
 * 
 */
public class Practicejoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"started");
Runnable r=new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			System.out.println(Thread.currentThread().getName()+"Started");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"stop");
		
	}
};
Thread t1=new Thread(r);
t1.start();
try {
	t1.join();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(Thread.currentThread().getName()+"stop");

	}

}
