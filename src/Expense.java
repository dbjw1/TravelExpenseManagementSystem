

public class Expense {
	int id;
	String date;
	String expender;
	int amount;
	String category;
	String description;
	public Expense(){
	}
	public Expense(int id,String date,String expender,int amount,String category,String description) {
		this.id=id;
		this.date=date;
		this.expender=expender;
		this.amount=amount;
		this.category=category;
		this.description=description;
	}
	public void printInfo() {
		System.out.println("id : "+id);
		System.out.println("date : "+date);
		System.out.println("expender : "+expender);
		System.out.println("amount : "+amount);
		System.out.println("category :"+category);
		System.out.println("description : "+description);
	}
	public void printId() {
		System.out.println("now expense data id is : "+id);
	}
}
