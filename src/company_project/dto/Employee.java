package company_project.dto;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;
	private String email;
	private String passwd;
	private Date regDate;
	private String tel;
	private String picUri;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept, String email,
			String passwd, Date regDate, String tel, String picUri) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
		this.email = email;
		this.passwd = passwd;
		this.regDate = regDate;
		this.tel = tel;
		this.picUri = picUri;
	}

	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept, String email,
			Date regDate, String tel, String picUri) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
		this.email = email;
		this.regDate = regDate;
		this.tel = tel;
		this.picUri = picUri;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s, email=%s, passwd=%s, regDate=%s, tel=%s, picUri=%s]",
				empNo, empName, title, manager, salary, dept, email, passwd, regDate, tel, picUri);
	}

	public Employee(int empNo) {
		super();
		this.empNo = empNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPicUri() {
		return picUri;
	}

	public void setPicUri(String picUri) {
		this.picUri = picUri;
	}

}
