package concurreny;

import java.util.concurrent.Callable;

public class DemoThreadcal implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			System.out.println(i + Thread.currentThread().getName());
		}
		return Thread.currentThread().getName()+"ThreadExeCutionCompleted";
	}

	
	

}
