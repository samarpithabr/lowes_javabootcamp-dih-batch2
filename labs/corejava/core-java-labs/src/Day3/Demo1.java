package Day3;
class Car{
	int noOfAirbags=5;
	String carName;
	public final int carWheels=4;
	public static int noOfSeats=5;
	public Car(String carName) {
	noOfAirbags++;
	noOfSeats++;
		this.carName = carName;
		System.out.println("car is moving with  " +noOfSeats +" with  "+noOfAirbags + " noofairbags" + carWheels + " no of wheels");
		
	}
	public String getCarName() {
		return carName;
	}
	public int getCarWheels() {
		return carWheels;
		
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public static int getNoOfSeats() {
		return noOfSeats;
	}
	public static void setNoOfSeats(int noOfSeats) {
		Car.noOfSeats = noOfSeats;
		System.out.println(noOfSeats);
	}
	public void move() {
		noOfSeats++;
		System.out.println(noOfAirbags+"bags"+ noOfSeats+"seats");
	}
	
	
public static void getseats() {

	System.out.println("seats in car is "+noOfSeats);
	
}

	
}
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Car car1 =new Car("nexon");
car1.move();
Car car2=new Car("creata");
Car car3=new Car("nisaan");
Car.getseats();


//car1.getCarWheels();
//System.out.println(car1.getCarWheels());


	}

}
