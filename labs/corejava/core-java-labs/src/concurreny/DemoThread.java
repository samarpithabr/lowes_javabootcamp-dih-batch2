package concurreny;

public class DemoThread extends Thread{
	
public void run() {
//	System.out.println((Thread.currentThread().getName()));
	for(int i=0;i<100;i++) {
		System.out.println(i+" "+Thread.currentThread().getName());
	}
}
}
