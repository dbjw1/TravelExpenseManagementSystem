package gui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Expense.ExpenseInput;
import manager.ExpenseManager;

public class ExpenseViewer extends JPanel{

	WindowFrame frame;
	
	ExpenseManager expenseManager;
	
	public ExpenseViewer(WindowFrame frame,ExpenseManager expenseManager) {
		this.frame=frame;
		this.expenseManager=expenseManager;
		
		System.out.println("***"+expenseManager.size()+"***");		
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Date");
		model.addColumn("Expender");
		model.addColumn("Amount");
		
		for(int i=0;i<expenseManager.size();i++) {
			Vector row=new Vector();
			ExpenseInput ei=expenseManager.get(i);
			row.add(ei.getId());
			row.add(ei.getDate());
			row.add(ei.getExpender());
			row.add(ei.getAmount());
			model.addRow(row);
		}
		
		JTable table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		
		this.add(sp);
	}

}
