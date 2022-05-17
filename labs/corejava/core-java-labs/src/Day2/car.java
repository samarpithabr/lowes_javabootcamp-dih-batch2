package Day2;

class fax{
	public String author;
	public String title;
	public int price;
	
	public fax(String author,String title,int price){
		this.author=author;
		this.price=price;
		this.title=title;
	}
	//copy constructor
	public fax(fax fax) {
		this.author=fax.author;
		this.price=fax.price;
		this.title=fax.title;
	}
	public void printing() {
		System.out.println("Book author is : = " +author +"\nBook Tittle is : = " + title + "\nBook price is : = "+ price);
	}
}
	
public class car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fax bookobj1=new fax("mark", "Learn java in 2 weeks", 100);
		bookobj1.printing();
		fax bookobj2=new fax("paulllllll", "learn html", 200);
		bookobj2.printing();
		fax faxcon=new fax(bookobj1);
		


	}

}
