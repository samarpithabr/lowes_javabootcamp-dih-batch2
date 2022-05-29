package exception;

public class EmployeeException extends Exception{
public EmployeeException() {
	System.out.println("Enter proper format of input");
}
public EmployeeException(String msg) {
	System.out.println(msg);
}
}
