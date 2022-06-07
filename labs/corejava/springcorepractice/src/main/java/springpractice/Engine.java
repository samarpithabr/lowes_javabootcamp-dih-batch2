package springpractice;

public class Engine {

	private int capacity;
	private int noOfCynclinders;
	private int torque;


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNoOfCynclinders() {
		return noOfCynclinders;
	}

	public void setNoOfCynclinders(int noOfCynclinders) {
		this.noOfCynclinders = noOfCynclinders;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}
	
//	public void init1() {
//		System.out.println("Engine Bean Initialized...");
//	}
//	
//	public void destroy() {
//		System.out.println("Engine Bean Destroyed...");
//	}	

}
