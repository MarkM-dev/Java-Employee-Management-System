package com.java.employees;

import java.util.Scanner;

public class Employee {

	private String name;
	private String address;
	private String tel;
	private double hrAmount;
	private double pricePerHour;
	
	
	
	public void setFullDetails(){
		Scanner s = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter employee name:");
		setName(s.next());
		System.out.println("Enter employee's address:");
		setAddress(s.next());
		System.out.println("Enter employee's phone number:");
		setTel(s.next());
		
		Boolean flag = true;
		while(flag) {
			System.out.println("Enter amount of hours the employee has worked:");
			
			String str = s.next();
			if (isAdouble(str)) {
				double input = Double.valueOf(str);
				if (input < 0) {
					System.err.println("Must enter a positive value.");
					continue;
				} else {
					setHrAmount(input);
					flag = false;
				}
				
			}
		}
		
		flag = true;
		while(flag) {
			System.out.println("Enter employee's hourly salary:");
			
			String str = s.next();
			if (isAdouble(str)) {
				double input = Double.valueOf(str);
				if (input < 0) {
					System.err.println("Must enter a positive value.");
					continue;
				} else {
					setPricePerHour(input);
					flag = false;
				}
			}
		}
	}
	
	public void printEmployeeNames () {
		System.out.print(name);
	}
	
	public void printEmployees() {
		System.out.println();
		System.out.println("Employee name: "+ name);
		System.out.println("Address: "+ address);
		System.out.println("Phone: "+ tel);
		System.out.println("Hours worked: "+ hrAmount);
		System.out.println("Employee's hourly salary: " + pricePerHour);
		System.out.println("_______________________________");
	}
	
	
	public void printSalaryReport () {
		
		System.out.println();
		System.out.println("Name: " + name);
		System.out.println("Salary: " + hrAmount * pricePerHour);
		System.out.println("_______________________________");	
	}
	
	public void setSpecificDetail () {
		Scanner j = new Scanner(System.in);
		Boolean flag = true;
		while(flag) {	
			System.out.println("Select the thing you want to edit: ");
			System.out.println("1. Name.");
			System.out.println("2. Address.");
			System.out.println("3. Phone Number.");
			System.out.println("4. Hour Amount.");
			System.out.println("5. Hourly salary.");
			System.out.println("6. Back to main menu.");
			
			String str = j.next();
			if (!isAnumber(str)) {		
				continue;
			}
			int userInput = Integer.valueOf(str);
			
			switch (userInput) {
			case 1:
				System.out.println("Enter a new name:");
				setName(j.next());
				break;
			case 2:
				System.out.println("Enter a new address:");
				setAddress(j.next());
				break;
			case 3:
				System.out.println("Enter a new phone number:");
				setTel(j.next());
				break;
			case 4:
				Boolean flag1 = true;
				while(flag1) {
					System.out.println("Enter a new hour amount value:");
					String str1 = j.next();
					if (isAdouble(str1)) {
						double input = Double.valueOf(str1);
						if (input < 0) {
							System.err.println("Must enter a positive value.");
							continue;
						} else {
							setHrAmount(input);
							flag1 = false;
						}
					}
				}
				break;
			case 5:
				flag1 = true;
				while(flag1) {
					System.out.println("Enter a new hourly salary value:");
					String str1 = j.next();
					if (isAdouble(str1)) {
						double input = Double.valueOf(str1);
						if (input < 0) {
							System.err.println("Must enter a positive value.");
							continue;
						} else {
							setPricePerHour(input);
							flag1 = false;
						}
					}
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Must choose a number between 1-6.");
				break;
			}
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
	
	public boolean isAdouble(String str) {
		try {
			Double.valueOf(str); //if str not a number The command will fail and jump to catch
			return true;
		} catch (Exception e) {
			System.err.println("Must enter a number.");
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	private void setTel(String tel) {
		this.tel = tel;
	}
	public double getHrAmount() {
		return hrAmount;
	}
	private void setHrAmount(double hrAmount) {
		this.hrAmount = hrAmount;
	}
	public double getPricePerHour() {
		return pricePerHour;
	}
	private void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
}
