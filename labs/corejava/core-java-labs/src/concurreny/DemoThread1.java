package concurreny;

public class DemoThread1 implements Runnable{
public void run() {
	for(int i=0;i<100;i++) {
		System.out.println(i+" "+Thread.currentThread().getName());
	}
}
}
