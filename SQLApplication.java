import java.util.Scanner;
import java.sql.SQLException;
public class SQLApplication {
	
	static void choice()
	{
		System.out.println("Enter the choice");
		System.out.println("1->Create");
		System.out.println("2->Insert");
		System.out.println("3->Update");
		System.out.println("4->Display");
		System.out.println("5->Delete");
	}

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=true;
		Scanner scan=new Scanner(System.in);
		while(flag)
		{
			SQLApplication.choice();
			int choice=scan.nextInt();
			switch(choice)
			{
				case 1: Employee_Utils.create();
						break;
				case 2: Employee_Utils.insert(scan);
						break;
				case 3: Employee_Utils.update(scan);;
						break;
				case 4: Employee_Utils.display();;
						break;
				case 5: Employee_Utils.delete(scan);
						
			}
			
		}
		scan.close();

	}

}
