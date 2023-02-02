import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_Utils {
	static Connection con;
	static  
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","");
		}
		catch(Exception e)
		{}
		
	}
	static void create()throws SQLException
	{
		Statement stmt=con.createStatement();
		stmt.executeUpdate("create table Employee(Employee_ID INT,Employee_Name varchar(30),Age INT,Salary INT)");
	}
	static Employee getInput(Scanner input)
	{
		
		Employee obj=new Employee();
		System.out.println("Enter the Employee name");
		obj.setEmployeeName(input.next());
		System.out.println("Enter the salary");
		obj.setSalary(input.nextInt());
		System.out.println("Enter the Age");
		obj.setAge(input.nextInt());
		return obj;
		
	}
	static void insert(Scanner input)throws SQLException
	{
		Employee obj=getInput(input);
		PreparedStatement stmt=con.prepareStatement("insert into Employee values(?,?,?,?)");
		stmt.setInt(1, obj.getEmployeeId());
		stmt.setString(2, obj.getEmployeeName());
		stmt.setInt(3, obj.getAge());
		stmt.setInt(4, obj.getSalary());
		stmt.executeUpdate();
	}
	static void display()throws SQLException
	{
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Employee");
		if(rs==null)
			System.out.println("Empty");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		}
		
	}
	static void choice()
	{
		System.out.println("1->Update Name");
		System.out.println("2->Update Salary");
		System.out.println("3->Update age");
	}
	static void update(Scanner input)throws SQLException
	{
		int ch;
		PreparedStatement stmt=null;
		choice();
		ch=input.nextInt();
		System.out.println("Enter your Employee Id");
		int id=input.nextInt();
		switch(ch)
		{
			case 1: System.out.println("Enter the name");
					String name=input.next();
					stmt=con.prepareStatement("update Employee set Employee_Name = ? where Employee_ID= ?");
					stmt.setString(1, name);
					
					break;
			case 2: System.out.println("Enter the Salary");
					int salary =input.nextInt();
					stmt=con.prepareStatement("update Employee set Salary= ? where Employee_ID= ?");
					stmt.setInt(1,salary);
					
					break;
			case 3: System.out.println("Enter the age");
					int age=input.nextInt();
					stmt=con.prepareStatement("update Employee set Age= ? where Employee_ID=?");
					stmt.setInt(1, age);
					
					break;
					
		}
		stmt.setInt(2, id);
		int i=stmt.executeUpdate();
		System.out.println(i+" rows affected");
		
	}
	static void delete(Scanner input)throws SQLException
	{
		
		System.out.println("Enter the Employee id");
		int id=input.nextInt();
		Statement stmt =con.createStatement();
		stmt.executeUpdate("delete from Employee where Employee_ID= "+id);
	}

}
