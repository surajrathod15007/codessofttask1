package com.sms.app.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.sms.app.dao.StudentDao;
import com.sms.app.model.Student;
import com.sms.app.service.StudentServicei;

public class  StudentServiceImpl implements StudentServicei 
{
	Scanner sc=new Scanner(System.in);
    Student std=new Student();
    StudentDao sd=new StudentDao();
    
	public void addStudent() 
	{
	  try
	  {
	  System.out.println("Enter Student Name:");
	  String sname=sc.next();
	  std.setName(sname);
	  System.out.println("Enter Student RollNo:");
	  int srollno=sc.nextInt();
	  std.setRollno(srollno);
	  System.out.println("Enter Student Grade");
	  String sgrade=sc.next();
	  std.setGrade(sgrade);
	  System.out.println("Enter Student City Name:");
	  String scity=sc.next();
	  std.setCity(scity);
	  
	  //     slist.add(std);
	  
	  Connection con=sd.getConnection();
	  PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
	  
	  ps.setString(1, sname);
	  ps.setInt(2, srollno);
	  ps.setString(3, sgrade);
	  ps.setString(4, scity);
	  
	  int x=ps.executeUpdate();
	  if(x>0)
	  {
		  System.out.println("Student Added SuccessFully");
	  }
	  else
	  {
		  System.out.println("Student Not Added");
	  }
	  }
	  catch(Exception e)
	  {
		System.out.println(e.getMessage());  
	  }
	  
	}

	public void removeStudent() 
	{
	  try
	  {
		System.out.println("Enter Student Roll No To Remove Student.");
		int srollno=sc.nextInt();
		
		Connection con=sd.getConnection();
		PreparedStatement ps=con.prepareStatement("delete From student where srollno=?");
		ps.setInt(1, srollno);
		int s=ps.executeUpdate();
		
		if(s>0)
		{
			System.out.println("Student Deleted SuccessFully");
		}
		else
		{
			System.out.println("Enter Valid Roll no To Delete");
		}
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();  
	  }
	  
	}

	
	public void searchStudent() 
	{
	  try
	  {
		System.out.println("Enter Roll No To Search Student.");
		int srollno=sc.nextInt();
		
		Connection con=sd.getConnection();
		PreparedStatement ps=con.prepareStatement("select * From student where srollno=?");
		ps.setInt(1, srollno);
		
		ResultSet rs=ps.executeQuery();
		if(rs==null)
		{
		  System.out.println("Data Not Present! Enter Valid Roll No");	
		}
		else
		{
			System.out.println("Data Is Present");
		}
		while(rs.next())
		{
			System.out.println("--------Student Details-------");
			System.out.println("Name:"+rs.getString(1));
			System.out.println("RollNo:"+rs.getInt(2));
			System.out.println("Grade:"+rs.getString(3));
			System.out.println("City:"+rs.getString(4));
		}
		
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }
		
	}

	public void displayAllStudent() 
	{
	  try
	  {
		Connection con=sd.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from student");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("--------Student Details-------");
			System.out.println("Name:"+rs.getString(1));
			System.out.println("RollNo:"+rs.getInt(2));
			System.out.println("Grade:"+rs.getString(3));
			System.out.println("City:"+rs.getString(4)); 	     
		}
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();  
	  }
	
	}
	
	public void updateStudent()
	{
	  System.out.println("Enter Your RollNo To Update"); 
	  int srollno=sc.nextInt();
	  System.out.println("Now Update Data By Entering Details:");
	  System.out.println("Name:");
	  String sname=sc.next();
	  System.out.println("Grade:");
	  String sgrade=sc.next();
	  System.out.println("City:");
	  String scity=sc.next();
	  
	  try
	  {
	   Connection con=sd.getConnection();
	   PreparedStatement ps=con.prepareStatement("update student set sname=?,sgrade=?, scity=? where srollno=?");
	   
	   ps.setString(1, sname);
	   ps.setString(2, sgrade);
	   ps.setString(3, scity);
	   ps.setInt(4, srollno);
	   
	   int s=ps.executeUpdate();
	   if(s>0)
	   {
		   System.out.println("Data Updated");
	   }
	   else
	   {
		   System.out.println("Enter Valid Detail To Update");
	   }
	  }
	  catch(Exception e)
	  {
		 e.printStackTrace(); 
	  }
	}
   
}
