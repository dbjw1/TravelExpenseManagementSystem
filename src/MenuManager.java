import java.util.Scanner;
public class MenuManager{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExpenseManager eManager=new ExpenseManager(input); 
		
		int num=0;
		while(num!=5) {
			System.out.println("#Menu");
			System.out.println("1. Add Expense");
			System.out.println("2. Delete Expense");
			System.out.println("3. Edit Expense");
			System.out.println("4. View Expense");
			System.out.println("5. Exit");
			System.out.println("#Select one number between 1-5");
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
					eManager.viewExpense();
					break;
			}
		}
	}

}