package concurreny;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateThreadCal implements Callable<String> {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
ExecutorService exe=Executors.newFixedThreadPool(5);
DemoThreadcal dcal=new DemoThreadcal();
Future<String> f1=exe.submit(dcal);
System.out.println(f1.get());
Future<String> f2=exe.submit(new DemoThreadcal());
System.out.println(f2.get());
Future<String> f3=exe.submit(new CreateThreadCal());
System.out.println(f3.get());
}

	@Override
	public String call() throws Exception {
		for(int i=0;i<5;i++) {
			System.out.println(i + Thread.currentThread().getName());
		}
		return Thread.currentThread().getName()+"ThreadExeCutionCompleted";
	}

	
}
