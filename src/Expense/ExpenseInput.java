package Expense;

import java.util.Scanner;

import exception.DateFormatException;

public interface ExpenseInput {
	public int getId();
	public void setId(int id);
	public String getDate();
	public void setDate(String date) throws DateFormatException;
	public String getExpender();
	public void setExpender(String expender);
	public int getAmount();
	public void setAmount(int amount);
	public void printInfo();
	public void getUserInput(Scanner input);
	public void setExpenseID(Scanner input);
	public void setExpenseDate(Scanner input);
	public void setExpenseExpender(Scanner input);
	public void setExpenseAmount(Scanner input);
}
