package day7;
class InSuffcientBalanceException1 extends Exception{

	
		// TODO Auto-generated constructor stub
		 public InSuffcientBalanceException1(){
		        System.out.println("Insufficient amount requested");
		    }

		    public InSuffcientBalanceException1(String message){
		        System.out.println(message);
		    }
	
}
class Bank {
	private int balance=0;
	int accountNumber;
	public  Bank(int accountnumber) {
		accountnumber=accountnumber;
	}

	public void withdraww(int amount) throws InSuffcientBalanceException1 {
		if (amount<=balance) {
			System.out.println("amount debited"+-amount);
		}else
		{
			throw new InSuffcientBalanceException1("you dont ave enough money to withdrawl");
		}
	}
			
		
		public void deposit(int amount) {
			balance +=amount;
			System.out.println(("amount"+ balance));
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
	}

public class Demo2 {

	public static void main(String[] args) {
		Bank ban=new Bank(32453234);
		System.out.println(ban.getAccountNumber());
		System.out.println(ban.getBalance());
		ban.deposit(230);
		try{
			ban.withdraww(250);
		}catch (InSuffcientBalanceException1 e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		ban.deposit(1000);
		try {
			ban.withdraww(2000);
		}catch (InSuffcientBalanceException1 e) {
			System.out.println("");
			// TODO: handle exception
		}
		ban.deposit(22);
		try {
			ban.withdraww(400);
		} catch (InSuffcientBalanceException1 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		// TODO Auto-generated method stub

	}
}


