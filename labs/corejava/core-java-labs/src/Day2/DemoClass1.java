package Day2;




class Book{
	public String author;
	public String tittle;
	public int price;
	public void printing() {
		System.out.println("Book author is : = " +author +"\nBook Tittle is : = " + tittle+ "\nBook price is : = "+ price);
	}
	
}

public class DemoClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book bookobj=new Book();
		bookobj.author="mark";
		bookobj.tittle="Learn java in 2 weeks";
		bookobj.price=100;
		bookobj.printing();
		Book bookobj1=new Book();
		bookobj1.author="paul";
		bookobj1.price=200;
		bookobj1.tittle="Learn html in 2 weeks";
	bookobj1.printing();

	}

}
