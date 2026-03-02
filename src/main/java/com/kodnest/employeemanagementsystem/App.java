package com.kodnest.employeemanagementsystem;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
    	
    	EmployeeManagement em = new EmployeeManagement();
        try (Scanner scan = new Scanner(System.in)) {
			for(;;) {
				System.out.println(" Select the operation");
				System.out.println("1 -> getEmployeeById");
				System.out.println("2 -> getAllEmployees");
				System.out.println("3 -> addEmployee");
				System.out.println("4 -> updateEmployee");
				System.out.println("5 -> deleteEmployee");
				System.out.println("Other -> Exit");
				
				int ch = scan.nextInt();
				switch (ch) {
				case 1: {
					System.out.println("Enter the id");
					em.getEmployeeById(scan.nextInt());
					break;
				}
				case 2: {
					em.getAllEmployees();
					break;
				}
				case 3: {
					System.out.println("Enter the id, name, salary, phone, email and type");
					em.addEmployee(scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next());
					break;
				}
				case 4: {
					System.out.println("Enter the id ");
					em.updateEmployee(scan.nextInt());
					break;
				}
				case 5: {
					System.out.println("Enter the id ");
					em.deleteEmployee(scan.nextInt());
				}
				default:
					System.out.println("Thank you for using EMS");
				}
			}
		}
    }
}
