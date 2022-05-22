
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;
public class MenuManager{
	static EventLogger logger=new EventLogger("log.txt");
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExpenseManager eManager=getObject("expensemanager.ser");
		if(eManager==null) {
			eManager=new ExpenseManager(input); 
		}
		selectMenu(input,eManager);
		putObject(eManager,"expensemanager.ser");
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
						logger.log("add expense");
						break;
					case 2:
						eManager.deleteExpense();
						logger.log("delete expense");
						break;
					case 3:
						eManager.editExpense();
						logger.log("edit expense");
						break;
					case 4:
						eManager.viewExpenses();
						logger.log("view list of expense");
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
	public static ExpenseManager getObject(String filename) {
		ExpenseManager eManager=null;
		try{
			FileInputStream file=new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			eManager=(ExpenseManager) in.readObject();
			in.close();
			file.close();
		} catch(FileNotFoundException e) {
			return eManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return eManager;
	}
	public static void putObject(ExpenseManager eManager, String filename) {
		try{
			FileOutputStream file=new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(eManager);
			out.close();
			file.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}