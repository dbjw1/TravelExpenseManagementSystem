package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ExpenseAdder extends JPanel{

	WindowFrame frame;
	
	public ExpenseAdder(WindowFrame frame) {
		this.frame=frame;
		
		JPanel panel=new JPanel(new SpringLayout());
		panel.setLayout(new SpringLayout());
		
		JLabel labelID=new JLabel("ID: ",JLabel.TRAILING);
		JTextField fieldID=new JTextField(10);
		labelID.setLabelFor(fieldID);
		panel.add(labelID);
		panel.add(fieldID);
		
		JLabel labelDate=new JLabel("Date: ",JLabel.TRAILING);
		JTextField fieldDate=new JTextField(10);
		labelDate.setLabelFor(fieldDate);
		panel.add(labelDate);
		panel.add(fieldDate);
		
		JLabel labelExpender=new JLabel("Expender: ",JLabel.TRAILING);
		JTextField fieldExpender=new JTextField(10);
		labelExpender.setLabelFor(fieldExpender);
		panel.add(labelExpender);
		panel.add(fieldExpender);
		
		JLabel labelAmount=new JLabel("Amount: ",JLabel.TRAILING);
		JTextField fieldAmount=new JTextField(10);
		labelAmount.setLabelFor(fieldAmount);
		panel.add(labelAmount);
		panel.add(fieldAmount);
		
		panel.add(new JButton("save"));
		panel.add(new JButton("cancel"));
		
		SpringUtilities.makeCompactGrid(panel,5,2,6,6,6,6);
		
		
		this.add(panel);
		this.setVisible(true);
	}
}
