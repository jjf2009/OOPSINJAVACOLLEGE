import java.util.Scanner;
class Account {
 private int accounNumber;
 private String accountHolder;
 
 Account(int accounNumber,String accountHolder){
 this.accounNumber = accounNumber;
 this.accountHolder= accountHolder;
}



void display(){
  System.out.println("Account Number: "+ accounNumber+" Account Holder Name: "+accountHolder);
}
}

class SavingsAccount extends Account{
	private float interestRate;
	 SavingsAccount(int accounNumber,String accountHolder,float interestRate){
		 super(accounNumber,accountHolder);
		 this.interestRate= interestRate;
	 }
	 
	 void display(){
		 System.out.println( "Interest Rate : "+interestRate);
		 super.display();
	 }
}

class SavingsAccountSystem {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Number: ");
		int accnum = sc.nextInt();
		      sc.nextLine();
		System.out.println("Enter Account Holder:");
		String accholder = sc.nextLine();
		System.out.println("Enter Interest rate:");
		float rate = sc.nextFloat();
		
		Account a = new SavingsAccount(accnum,accholder,rate);
		a.display();
	}
}