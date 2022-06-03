package hellomaven;

public class Greetings {
	String message="hello greeting class";
	public Greetings() {
	}
		public Greetings(String message) {
			
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String messag) {
		this.message = messag;
	}
	}