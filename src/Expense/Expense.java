package Expense;

import java.io.Serializable;
import java.util.Scanner;

import exception.DateFormatException;

public abstract class Expense implements ExpenseInput,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6434471492436763559L;
	protected ExpenseKind kind;
	protected int id;
	protected String date;
	protected String expender;
	protected int amount;
	public Expense(){
	}
	public Expense(ExpenseKind kind) {
		this.kind=kind;
	}
	public Expense(ExpenseKind kind,int id,String date,String expender,int amount) {
		this.kind=kind;
		this.id=id;
		this.date=date;
		this.expender=expender;
		this.amount=amount;
	}
	public ExpenseKind getKind() {
		return kind;
	}
	public void setKind(ExpenseKind kind) {
		this.kind = kind;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) throws DateFormatException{
		if(date.length()!=4) {
			throw new DateFormatException();
		}
		this.date = date;
	}
	public String getExpender() {
		return expender;
	}
	public void setExpender(String expender) {
		this.expender = expender;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setExpenseID(Scanner input) {
		System.out.print("ID : ");
		int id=input.nextInt();
		this.setId(id);
	}
	public void setExpenseDate(Scanner input) {
		String date="";
		while(date.length()!=4) {
			System.out.print("Date(MMDD) :");
			date=input.next();
			try{
				this.setDate(date);
			} catch(DateFormatException e) {
				System.out.println("Inccorect Date Format.");
				
			}
		}
	}
	public void setExpenseExpender(Scanner input) {
		System.out.print("Expender : ");
		String expender=input.next();
		this.setExpender(expender);
	}
	public void setExpenseAmount(Scanner input) {
		System.out.print("Amount : ");
		int amount=input.nextInt();
		this.setAmount(amount);
	}
	public abstract void printInfo();
	public String getKindString() {
		String ekind="none";
		switch(this.kind) {
		case Transportation:
			ekind="Transp.";
			break;
		case Food:
			ekind="Food";
			break;
		case Lodging:
			ekind="Lodging";
			break;
		default:
		}
		return ekind;
	}
	
}
