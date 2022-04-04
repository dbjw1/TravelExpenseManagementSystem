
import java.util.Scanner;

public class ExpenseManager {
	Expense expense;
	Scanner input;
	ExpenseManager(Scanner input){
		this.input=input;
	}
	
	public void addExpense(){
		expense=new Expense();
		Scanner input = new Scanner(System.in);
		System.out.print("ID : ");
		expense.id=input.nextInt();
		System.out.print("Date(MMDD) :");
		expense.date=input.next();
		System.out.print("Expender : ");
		expense.expender=input.next();
		System.out.print("Amount : ");
		expense.amount=input.nextInt();
		System.out.print("Category : ");
		expense.category=input.next();
		String nl=input.nextLine();
		System.out.print("Description : ");
		expense.description=input.nextLine();
		System.out.println();
	}
	public void deleteExpense(){
		System.out.print("ID : ");
		int id=input.nextInt();
		if(expense ==null) {
			System.out.println("no expense data");
			return;
		}
		if(expense.id==id) {
			expense=null;
			System.out.println("expense data is deleted");
		}
	}
	public void editExpense(){
		System.out.print("ID : ");
		int id=input.nextInt();
		if(expense.id==id) {
			System.out.println("expense data to be edited is "+id);
		}
	}
	public void viewExpense(){
		System.out.print("ID : ");
		int id=input.nextInt();
		if(expense.id==id) {
			expense.printInfo();
		}
	}
}
