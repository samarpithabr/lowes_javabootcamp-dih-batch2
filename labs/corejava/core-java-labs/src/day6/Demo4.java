package day6;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char[] ch= {'h','e','l','l','o'};
				char[] chnew=new char[5];
			System.arraycopy(ch, 0, chnew, 0, 5);;
			for (char c : chnew) {
				System.out.println(c);
			}
		}

	}


