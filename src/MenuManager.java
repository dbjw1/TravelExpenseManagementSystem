import java.util.Scanner;
public class MenuManager{
	public static void main(String[] args) {
		int num=0;
		Scanner input = new Scanner(System.in);
		while(num!=6) {
			System.out.println("1. Add Expense");
			System.out.println("2. Delete Expense");
			System.out.println("3. Edit Expense");
			System.out.println("4. View Expense");
			System.out.println("5. Show a Menu");
			System.out.println("6. Exit");
			System.out.println("#Select one number between 1-6");
			num=input.nextInt();
			switch(num) {
				case 1:
					addexpense();
					break;
				case 2:
					deleteexpense();
					break;
				case 3:
					editexpense();
					break;
				case 4:
					viewexpense();
					break;
				case 5:
					showamenu();
					break;
				case 6:
					exit();
					break;
			}
		}
	}
	public static void addexpense(){
		Scanner input = new Scanner(System.in);
		System.out.print("Date(MMDD) :");
		String date=input.next();
		System.out.print("Expender : ");
		String edr=input.next();
		System.out.print("Amount : ");
		int amt=input.nextInt();
		System.out.print("Category : ");
		String cat=input.next();
		String des=input.nextLine();
		System.out.print("Description : ");
		des=input.nextLine();
		System.out.println();
	}
	public static void deleteexpense(){
		
	}
	public static void editexpense(){
		
	}
	public static void viewexpense(){

	}
	public static void showamenu(){
		
	}
	public static void exit(){
		
	}
}