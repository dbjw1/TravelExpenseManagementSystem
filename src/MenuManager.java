
import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuManager{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExpenseManager eManager=new ExpenseManager(input); 
		
		selectMenu(input,eManager);
	}
	public static void selectMenu(Scanner input,ExpenseManager eManager) {
		int num=-1;
		while(num!=5) {
			try {
				showMenu();
				num=input.nextInt();
				switch(num) {
					case 1:
						eManager.addExpense();
						break;
					case 2:
						eManager.deleteExpense();
						break;
					case 3:
						eManager.editExpense();
						break;
					case 4:
						eManager.viewExpenses();
						break;
					default:
						continue;
				}
			} catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if(input.hasNext()) {
					input.next();
				}
				num=-1;
			}
		
		}
	}
	public static void showMenu() {
		System.out.println("###Menu###");
		System.out.println("1. Add Expense");
		System.out.println("2. Delete Expense");
		System.out.println("3. Edit Expense");
		System.out.println("4. View Expenses");
		System.out.println("5. Exit");
		System.out.println("###Select one number between 1-6");
	}
}