package springpractice;



public class Car {
	private String color;
	private String model;
	private String manufacturer;

	private Engine engine;

	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Car() {
		System.out.println("Car default constructor called...");
	}
	
//	public static Car createInstance(Engine engine) {
//		Car car = new Car(engine);
//		return car;
//	}
	public Car(Engine engine) {
		this.engine=engine;
		System.out.println("enginecar");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	

	
	
	
	
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("Car Bean Initialized...");		
//	}
//
//	public void destroy() throws Exception {
//		System.out.println("Car Bean Destroyed...");		
//	}
}

