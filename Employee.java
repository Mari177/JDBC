class Employee
{
	static int id=0;
	private int empId,age,salary;
	private String employeeName;
	Employee(){
		empId=++id;
	}
	public int getEmployeeId()
	{
		return empId;
	}
	public int getAge()
	{
		return age;
	}
	public int getSalary()
	{
		return salary;
	}
	public String getEmployeeName()
	{
		return employeeName;
	}
	public void setEmployeeName(String name)
	{
		this.employeeName=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	
}

