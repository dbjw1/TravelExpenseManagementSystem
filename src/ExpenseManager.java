
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Expense.ExpenseInput;
import Expense.ExpenseKind;
import Expense.Food;
import Expense.Lodging;
import Expense.Transportation;

public class ExpenseManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<ExpenseInput> expenses=new ArrayList<ExpenseInput>();	
	transient Scanner input;
	ExpenseManager(Scanner input){
		this.input=input;
	}
	
	public void addExpense(){
		int kind=0;
		ExpenseInput expenseInput;
		while(kind<1||kind>3) {
			try {
				System.out.println("Select Expense Kind between 1 and 3");
				System.out.println("1 for Transportation");
				System.out.println("2 for Food");
				System.out.println("3 for Lodging");
				kind=input.nextInt();
				switch(kind) {
					case 1:
						expenseInput=new Transportation(ExpenseKind.Transportation);
						expenseInput.getUserInput(input);
						expenses.add(expenseInput);
						break;
					case 2:
						expenseInput=new Food(ExpenseKind.Food);
						expenseInput.getUserInput(input);
						expenses.add(expenseInput);
						break;
					case 3:
						expenseInput=new Lodging(ExpenseKind.Lodging);
						expenseInput.getUserInput(input);
						expenses.add(expenseInput);
				}
			} catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 3!");
				if(input.hasNext()) {
					input.next();
				}
				kind=-1;
			}
		}
	}
	public void deleteExpense(){
		System.out.print("ID : ");
		int expenseId=input.nextInt();
		int index=findIndex(expenseId);
		removefromStudents(index,expenseId);
	}
	public int findIndex(int expenseId) {
		int index=-1;
		for(int i=0;i<expenses.size();i++) {
			if(expenses.get(i).getId()==expenseId) {
				index = i;
				break;
			}
		}
		return index;
	}
	public int removefromStudents(int index,int expenseId) {
		if(index>=0) {
			expenses.remove(index);
			System.out.println("expense Id : "+expenseId+" is deleted"); 
			return 1;
		}
		else {
			System.out.println("no expense data");
			return -1;
		}
	}
	public void editExpense(){
		System.out.print("ID : ");
		int id=input.nextInt();
		for(int i=0;i<expenses.size();i++) {
			ExpenseInput expense = expenses.get(i);
			if(expense.getId()==id) {
				int num=-1;
				while(num!=5) {
					showEditMenu();
					num=input.nextInt();
					switch(num) {
						case 1:
							expense.setExpenseID(input);
							break;
						case 2:
							expense.setExpenseDate(input);
							break;
						case 3:
							expense.setExpenseExpender(input);
							break;
						case 4:
							expense.setExpenseAmount(input);
							break;
						default:
							continue;
						}
					}
					break;
				}
				System.out.println("expense data to be edited is "+id);
			}
		}
	public void viewExpenses(){
		System.out.print("-----");
		for(int i=0;i<expenses.size();i++) {
			expenses.get(i).printInfo();
 		}
	}

	public void showEditMenu() {
		System.out.println("#Expense Info Edit Menu");
		System.out.println("1. Edit Id");
		System.out.println("2. Edit Date");
		System.out.println("3. Edit Expender");
		System.out.println("4. Edit Amount");
		System.out.println("5. Exit");
		System.out.println("Select one number between 1 - 6:");
	}
}
