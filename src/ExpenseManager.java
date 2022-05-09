
import java.util.ArrayList;
import java.util.Scanner;

import Expense.ExpenseInput;
import Expense.ExpenseKind;
import Expense.Food;
import Expense.Lodging;
import Expense.Transportation;

public class ExpenseManager {
	ArrayList<ExpenseInput> expenses=new ArrayList<ExpenseInput>();	
	Scanner input;
	ExpenseManager(Scanner input){
		this.input=input;
	}
	
	public void addExpense(){
		int kind=0;
		ExpenseInput expenseInput;
		while(kind!=1&&kind!=2) {
			System.out.println("Select Expense Kind between 1 and 2");
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
		}
	}
	public void deleteExpense(){
		System.out.print("ID : ");
		int id=input.nextInt();
		int index=-1;
		for(int i=0;i<expenses.size();i++) {
			if(expenses.get(i).getId()==id) {
				index = i;
				break;
			}
		}
		if(index>=0) {
			expenses.remove(index);
			System.out.println("expense id : "+id+" is deleted"); 
		}
		else {
			System.out.println("no expense data");
			return;
		}
	}
	public void editExpense(){
		System.out.print("ID : ");
		int id=input.nextInt();
		for(int i=0;i<expenses.size();i++) {
			ExpenseInput expenseInput = expenses.get(i);
			if(expenseInput.getId()==id) {
				int num=-1;
				while(num!=5) {
					System.out.println("#Expense Info Edit Menu");
					System.out.println("1. Edit Id");
					System.out.println("2. Edit Date");
					System.out.println("3. Edit Expender");
					System.out.println("4. Edit Amount");
					System.out.println("5. Exit");
					System.out.println("Select one number between 1 - 6:");
					num=input.nextInt();
					switch(num) {
						case 1:
							System.out.print("ID : ");
							int inpId=input.nextInt();
							expenseInput.setId(inpId);
							break;
						case 2:
							System.out.print("Date(MMDD) :");
							String date=input.next();
							expenseInput.setDate(date);
							break;
						case 3:
							System.out.print("Expender : ");
							String expender=input.next();
							expenseInput.setExpender(expender);
							break;
						case 4:
							System.out.print("Amount : ");
							int amount=input.nextInt();
							expenseInput.setAmount(amount);
							break;
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
}
