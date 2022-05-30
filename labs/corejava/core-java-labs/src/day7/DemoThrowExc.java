package day7;
class AuthenticationException extends Exception{
	public AuthenticationException() {
		// TODO Auto-generated constructor stub
		System.out.println("already logged in");
	}
	public AuthenticationException(String message) {
		System.out.println(message);
	}
}

public class DemoThrowExc {
	Boolean isLogged=false;
	public void login(String email,String passwrd) throws AuthenticationException {
		if(!isLogged) {
			if(email.equals("admin") && passwrd.equals("password")) {
				isLogged=true;
				System.out.println("logg in success");
			}
		}
			else 
				throw new AuthenticationException("not able to login");
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
DemoThrowExc demo=new DemoThrowExc();
try {
	demo.login("admin", "password");
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
