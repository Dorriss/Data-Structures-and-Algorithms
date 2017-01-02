package designproblems.EmployeeHierarchy;

import java.util.ArrayList;

public class Employee {
	
	private String Name;
	private String Id;
	private int rating;
	private Employee Manager;
	private Designations designation; 
	private ArrayList<Employee> ReportingEmployees = new ArrayList<>();
	
	
	Employee(Employee Manager,String Name,int rating)
	{
		this.Name = Name;
		this.rating = rating;
		this.Manager = Manager;
	}
	Employee(String Name,int rating)
	{
		this.Name = Name;
		this.rating = rating;
	}
	
	public void addReportingEmployee(Employee employee)
	{
		this.ReportingEmployees.add(employee);
	}
	
	public ArrayList<Employee> getReportingEmployess()
	{
		return this.ReportingEmployees;
	}

}
