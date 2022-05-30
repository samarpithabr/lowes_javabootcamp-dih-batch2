package concurreny;
/**thread can be created in 2 ways 
 * 1.extend thread interface to override run method
 * 2.extend implemens runnable
 * 1st approch create instance of class and give name and start
 * 2nd directly call Thread class instance and call class demo
 * 3rd implements runnable
 * 4th thread create instance to annonymus runnable method
 * 
 * @author samarpitha
 *
 */

public class createThread02 implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1st approch
		DemoThread1 dd1 = new DemoThread1();
		Thread t = new Thread(dd1);
		t.setName("1st approch");
		t.start();
		// 2nd approach
		Thread t2 = new Thread(new DemoThread1());
		t2.setName("2st approch");
		t2.start();
		// 3rd approch
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + " " + i);

				}
			}

		});
		t3.setName("3rd approach");
		t3.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
