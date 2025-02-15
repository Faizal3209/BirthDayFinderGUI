package com.mycompany.birthdayfindergui;

import javax.swing.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
//import java.util.*; 

public class BirthDayFinderGUI 
{ 
    private JTextField dateField; 
    private JTextField monthField; 
    private JTextField yearField; 

    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> { 
            BirthDayFinderGUI gui = new BirthDayFinderGUI(); 
            gui.createAndShowGUI(); 
        }); 
    } 

    private void createAndShowGUI() { 
        JFrame frame = new JFrame("Birth Day Finder"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JPanel panel = new JPanel(); 
        frame.getContentPane().add(panel); 
        placeComponents(panel); 
        frame.setSize(400, 200); 
        frame.setVisible(true); 
    } 

  

    private void placeComponents(JPanel panel) { 
        panel.setLayout(null); 

        JLabel dateLabel = new JLabel("Enter your date:"); 
        dateLabel.setBounds(10, 20, 150, 25); 
        panel.add(dateLabel); 
        dateField = new JTextField(20); 
        dateField.setBounds(180, 20, 165, 25); 
        panel.add(dateField); 

  
        JLabel monthLabel = new JLabel("Enter your month:"); 
        monthLabel.setBounds(10, 50, 150, 25); 
        panel.add(monthLabel); 
        monthField = new JTextField(20); 
        monthField.setBounds(180, 50, 165, 25); 
        panel.add(monthField); 


        JLabel yearLabel = new JLabel("Enter your year:"); 
        yearLabel.setBounds(10, 80, 150, 25); 
        panel.add(yearLabel); 
        yearField = new JTextField(20); 
        yearField.setBounds(180, 80, 165, 25); 
        panel.add(yearField); 

  

        JButton submitButton = new JButton("Submit"); 
        submitButton.setBounds(10, 110, 80, 25); 
        panel.add(submitButton); 
        submitButton.addActionListener((ActionEvent e) -> {
            onSubmission();
        }); 
    } 

  

    private void onSubmission() { 
        int date = Integer.parseInt(dateField.getText()); 
        int month = Integer.parseInt(monthField.getText()); 
        int year = Integer.parseInt(yearField.getText()); 

        int dt = real(year); 

        int rt = Math.floorDiv(dt, 4); 

        int value = yr(year); 

        int item = calci(month); 

        int result = dt + rt + date + item + value; 

  

        // Display the result in a dialog 

        JOptionPane.showMessageDialog(null, getResultMessage(result), "Result", JOptionPane.INFORMATION_MESSAGE); 

    } 

  

    private int real(int year)  
{ 
    	int front=0; 

    	if (year>2000 && year<=2099) 
    		front=year%2000; 

    	else if(year>1900 && year<=1999) 
    		front=year%1900; 

    	else if(year>1800 && year<=1899) 
    		front=year%1800; 

    	else if(year>1700 && year<=1799) 
    		front=year%1700; 

    	else if(year>1600 && year<=1699) 
    		front=year%1600; 

    	else 
    		System.out.println("Limit Exceed"); 

    	return front; 

    } 

  

    private int calci(int month) { 
        int code=0; 

    	//System.out.println("Month is "+month); 

    	switch(month) 
    	{ 
    	case 1 -> code=0; 

    	case 2 -> code=3; 

    	case 3 -> code=3; 

    	case 4 -> code=6; 

    	case 5 -> code=1; 

    	case 6 -> code=4; 

    	case 7 -> code=6; 

    	case 8 -> code=2; 

    	case 9 -> code=5; 

    	case 10 -> code=0; 

    	case 11 -> code=3; 

    	case 12 -> code=5; 

    	} 

return code; 

    } 

  

    private int yr(int year) { 
        int temp=0; 

      if(year>1600 && year<=1699) 
    		temp = 06; 

    	else if(year>1700 && year<=1799) 

    		temp = 04; 

    	if(year>1800 && year<=1899) 

    		temp = 02; 

    	if(year>1900 && year<=1999) 

    		temp = 00; 

    	if(year>2000 && year<=2099) 

    		temp = 06; 

return temp; 

    } 

  

    private String getResultMessage(int result) { 

        int dayOfWeek = result % 7; 

        return switch (dayOfWeek) {
            case 0 -> "I found when you were born!\nIt's SUNDAY";
            case 1 -> "I found when you were born!\nIt's MONDAY";
            case 2 -> "I found when you were born!\nIt's TUESDAY";
            case 3 -> "I found when you were born!\nIt's WEDNESDAY";
            case 4 -> "I found when you were born!\nIt's THURSDAY";
            case 5 -> "I found when you were born!\nIt's FRIDAY";
            case 6 -> "I found when you were born!\nIt's SATURDAY";
            default -> "";
        }; 

    } 

} 
