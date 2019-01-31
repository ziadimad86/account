import java.util.Scanner;

abstract class Account {
	int acc_no;
	String name;
	float amount;
	private final String secretKey="1986";

	public Account() {

	}

	public Account(int a, String n, float amt) {
		acc_no = a;
		name = n;
		amount = amt;
	}

	// Method to initialize object
	void insert(int a, String n, float amt) {
		acc_no = a;
		name = n;
		amount = amt;
	}

	// deposit method
	void deposit(float amt) {
		amount = amount + amt;
		System.out.println(amt + " deposited");
	}

	// withdraw method
	void withdraw(float amt) {
		if (amount < amt) {
			System.out.println("Insufficient Balance");
		} else {
			amount = amount - amt;
			System.out.println(amt + " withdrawn");
		}
	}

	// method to check the balance of the account
	void checkBalance() {
		System.out.println("Balance is: " + amount);
	}

	// method to display the values of an object
	void display() {
		System.out.println(acc_no + " " + name + " " + amount);
	}
	
	//method to confirm that is my account
	public boolean ConfirmAccount() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter SEcret Key");
		String str=scan.nextLine();
		if(str.equals(secretKey)) {
			System.out.println("Correct");
			return true;
		}
		else {
			System.out.println("Wrong");
			return false;
		}
	}
	
	abstract public int getIntrest();
}

class TbiAccount extends Account{

	@Override
	public int getIntrest() {
		return 12;
	}
	
}

//Creating a test class to deposit and withdraw amount  

public class Main {

	public static void main(String[] args) {
		Account a1 = new TbiAccount();
		a1.insert(123, "ziad", 3000);
		a1.display();
		a1.checkBalance();
		a1.deposit(40000);
		a1.checkBalance();
		a1.withdraw(15000);
		a1.checkBalance();
		System.out.println("Intrest: "+a1.getIntrest());
		a1.ConfirmAccount();
		
	}

}
