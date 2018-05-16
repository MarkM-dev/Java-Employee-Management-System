package com.java.employees;

import java.util.Scanner;

public class EmployeeList {

	private final static String welcomeMsg = "Welcome! This is an employee management system.";  
	private Employee [] employee = new Employee [100];
	private int index = 0;
	
	public void  run(){
		showWelcomeMsg ();
		printMenu();
	}
	
	
	private void showWelcomeMsg () {
		System.out.println("****************************************************************");
		System.out.println("*                                                              *");
		System.out.println("*                                                              *");
		System.out.println("*        " + welcomeMsg + "       *");
		System.out.println("*                                                              *");
		System.out.println("*                                                              *");
		System.out.println("*                                                              *");
		System.out.println("****************************************************************");
	}
	
	
	private void printMenu(){
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag){
		
			System.out.println("Please Enter an option.");
			System.out.println("1 Add employee.");
			System.out.println("2 Edit employee.");
			System.out.println("3 Print employee list.");
			System.out.println("4 Print salary report.");
			System.out.println("5 exit.");
			
			String str = scanner.next();
			if (!isAnumber(str)) {		
				continue;
			}
			
			int key = Integer.valueOf(str);
			
			switch (key) {
			case 1:
				System.out.println("Add employee:");
				addNewEmployee();
				break;
			case 2:
				editEmployee();
				break;
			case 3:
				printEmployees();
				break;
			case 4:
				printSalaryReport ();
				break;
			case 5:
				System.out.println("exit.");	
				flag = false;
				break;
	
			default:
				System.out.println("Must choose a number between 1-5.");
				break;
			}
		}
	}
	
	private void addNewEmployee () {
		employee[index] = new Employee();
		employee[index].setFullDetails();
		
		index++;
	}
	
	private void editEmployee () {
		if (index == 0) {
			System.err.println("No employees have been entered.");
			return;
		}
		System.out.println("Edit employee:");
		Scanner scanner = new Scanner(System.in);
		
		Boolean flag = true;
		while(flag) {
			System.out.println("Enter employee's index number to edit:");
			printEmployeeNames();
			String str = scanner.next();
			if (isAnumber(str)) {
				int input = Integer.valueOf(str);
				if (input > index || input <= 0) {
					System.err.println("Not a valid employee number.");
					continue;
				} else {
					employee[input-1].setSpecificDetail();
					flag = false;
				}
			}
		}
	}
	
	private void printEmployees (){
		if (index == 0){
			System.err.println("No employees to print.");
		} else {
			System.out.println("Printing employee list.");
			for (int i = 0; i < index; i++) {
				employee[i].printEmployees();
			}
		}
	}
	
	private void printSalaryReport () {
		if (index == 0){
			System.err.println("No employees to print a report of.");
		} else {
			System.out.println("Printing salary report.");
			for (int i = 0; i < index; i++) {
				employee[i].printSalaryReport();
			}
		}
	}
	
	private void printEmployeeNames() {
		for (int i = 0; i < index; i++) {
			System.out.print(i + 1 + ".");
			employee[i].printEmployeeNames();
			System.out.print(" ||");
		}
	}
	
	public boolean isAnumber(String str) {
		try {
			Integer.valueOf(str); //if str not a number The command will fail and jump to catch
			return true;
		} catch (Exception e) {
			System.err.println("Must enter a number.");
			return false;
		}
	}
	
	
}

