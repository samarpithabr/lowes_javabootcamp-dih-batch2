package day1;



public class Demo1switch {
	public static void main(String args[] ) {
	int num=5;
		switch(num) {
		case 4:
			System.out.println("four");
			break;
		case 5:
			System.out.println("five");
			break;
		case 6:
			System.out.println("six");
			break;
		case 7:
			System.out.println("seven");
			break;
		case 8:
			System.out.println("eight");
			break;
			default:System.out.println("not listed");
		}
		String name="seven";
		switch(name) {
		case "four":
			System.out.println("4");
			break;
		case "five":
			System.out.println("5");
			break;
		case "six":
			System.out.println("6");
			break;
		case "seven":
			System.out.println("7");
			break;
			default:System.out.println("not in list");
			
		}
	}

	}

