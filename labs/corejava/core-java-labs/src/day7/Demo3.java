package day7;

public class Demo3 {
 public static void main(String[] args){
		// TODO Auto-generated method stub
		//case 1:exception does not occur
		try{
			int p=12/3;
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("case 1:executed");
	
		}
		//case 2:execution occur but not handled
		try{
			int b=13/0;
			System.out.println(b);
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			System.out.println("case2:executed");
		}
		//case 3:execution has occour and its handled
		try{
			int m=15/0;
			System.out.println(m);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally{
			System.out.println("case 3:executed");
		}
	
		
	}

	
	
	
	
}
