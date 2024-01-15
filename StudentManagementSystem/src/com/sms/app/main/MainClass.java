package com.sms.app.main;

import java.util.Scanner;

import com.sms.app.serviceimpl.StudentServiceImpl;

public class MainClass 
{
	public static void main(String[] args) 
	{
	  Scanner sc=new Scanner(System.in);	  
	  StudentServiceImpl stsi=new StudentServiceImpl();
	  System.out.println("Welcome! TO Student Management App");
	  boolean status=true;
	while(status)
	{	
		  System.out.println("Choose Any One Option");
		  System.out.println("1. Add Student");
		  System.out.println("2. Search Student");
		  System.out.println("3. Remove Student");
		  System.out.println("4. Display All Student Details");
		  System.out.println("5. Update Student Detail ");
		  System.out.println("6. Exit");
		  int opt=sc.nextInt();
	  switch(opt)
	  {
	   case 1: 		   
		   stsi.addStudent();
		   break;
	   case 2: 
		   stsi.searchStudent();
		   break;
	   case 3:
		   stsi.removeStudent();
		   break;
	   case 4:
		   stsi.displayAllStudent();
		   break;
	   case 5:
		   stsi.updateStudent();
	   case 6:
		   status=false;
		   System.out.println("Thank You For Using My App...Visit Again");
		   break;
		   
		default:
			System.out.println("Invalid Option");
	  }	  
	}
	sc.close();	
	}

}
