package Expense;

import java.util.Scanner;

public class Transportation extends Expense {
	public Transportation() {
	}
	public Transportation(ExpenseKind kind) {
		super(kind);
	}
	public void getUserInput(Scanner input) {
		setExpenseID(input);
		setExpenseDate(input);
		setExpenseExpenderwithYN(input);
		setExpenseAmount(input);
	}
	public void setExpenseExpenderwithYN(Scanner input) {
		char answer='X';
		while(answer!='y'&&answer!='Y'&&answer!='n'&&answer!='N') {
			System.out.println("Did you pay separately? (Y/N)");
			answer=input.next().charAt(0);
			if(answer=='N'||answer=='n') {
				setExpenseExpender(input);
				break;
			}
			else if(answer=='Y'||answer=='y') {
				this.setExpender("Individual");
				break;
			}
		}
	}
	public void printInfo() {
		String ekind=getKindString();
		System.out.println(" kind:"+ekind+" id:"+id+" date:"+date+" expender:"+expender+" amount:"+amount);
	}

}
