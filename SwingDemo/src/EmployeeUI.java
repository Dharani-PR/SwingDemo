import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7329976427712942648L;

	JLabel name = new JLabel("Name");
	JLabel address = new JLabel("Address");
	JLabel dob = new JLabel("D.O.B");
	JLabel text = new JLabel("Enter Name only for Searching");
	JLabel searchName = new JLabel("Name");


	JTextField nameValue = new JTextField(20);
	JTextField addValue = new JTextField(20);
	JTextField dobValue = new JTextField(20);
	JTextField searchValue = new JTextField(20);

	JButton submit = new JButton("Submit");
	JButton display = new JButton("Display");
	JButton search = new JButton("Search");
	DefaultTableModel model= new DefaultTableModel();
	JTable employeeTable = new JTable();
	String[] rowValues = new String[20];
	String[] columnNames = {"Name","Address","D.O.B"};
	
	Map<String,Employee> employeeDetailsMap = new HashMap<String,Employee>();
	public EmployeeUI()	
	{	
		
		setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		add(name,grid);
		grid.gridx = 1;
		grid.gridy = 0;
		add(nameValue,grid);
		grid.gridx = 2;
		grid.gridy = 0;
		add(submit,grid);
		grid.gridx = 0;
		grid.gridy = 1;
		add(address,grid);
		grid.gridx = 1;
		grid.gridy = 1;
		add(addValue,grid);
		grid.gridx = 2;
		grid.gridy = 1;
		add(display,grid);
		grid.gridx = 0;
		grid.gridy = 2;
		add(dob,grid);
		grid.gridx = 1;
		grid.gridy = 2;
		add(dobValue,grid);
		grid.gridx = 0;
		grid.gridy = 3;
		add(text,grid); 
		grid.gridx = 0;
		grid.gridy = 4;
		add(searchName,grid);
		grid.gridx = 1;
		grid.gridy = 4;
		add(searchValue,grid);
		grid.gridx = 2;
		grid.gridy = 4;
		add(search,grid); 
		add(employeeTable);
		model.setColumnIdentifiers(columnNames); 
		employeeTable.setModel(model);
		employeeTable.setRowHeight(30); 
		JScrollPane scrollPane = new JScrollPane(employeeTable);
		grid.gridx = 1;
		grid.gridy = 5;
		add(scrollPane,grid);
		 


		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!nameValue.getText().isEmpty() && !addValue.getText().isEmpty() && !dobValue.getText().isEmpty()) {
					Employee emp = new Employee(nameValue.getText(), addValue.getText(), dobValue.getText());
					employeeDetailsMap.put(nameValue.getText(), emp);
				}				
			}
		});

		display.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Iterator itr = employeeDetailsMap.entrySet().iterator();
				model.setRowCount(0);
				while(itr.hasNext()) {
					Map.Entry<String, Employee> mapVal=(Map.Entry<String, Employee>)itr.next();
					if(mapVal.getKey() != null)  {
						Employee val=mapVal.getValue();
						rowValues[0] = val.getName();
						rowValues[1]=val.getAddress();
						rowValues[2]=val.getDob();
						model.addRow(rowValues);
					}
				}
			}				
		});
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);

				Employee emp = employeeDetailsMap.get(searchValue.getText());
				if(employeeDetailsMap != null) {
				rowValues[0] = emp.getName();
				rowValues[1]=emp.getAddress();
				rowValues[2]=emp.getDob();
				model.addRow(rowValues);
				}
			}
		});
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setSize(1000, 1000);
}

}
