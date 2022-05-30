package Expense;

import java.util.Scanner;

public class Lodging extends Expense {
	public Lodging() {
	}
	public Lodging(ExpenseKind kind) {
		super(kind);
	}
	public void getUserInput(Scanner input) {
		setExpenseID(input);
		setExpenseDate(input);
		setExpenseExpender(input);
		setExpenseAmount(input);
	}
	public void printInfo() {
		String ekind=getKindString();
		System.out.println(" kind:"+ekind+" id:"+id+" date:"+date+" expender:"+expender+" amount:"+amount);
	}
}
