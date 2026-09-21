package com.yessinfotech.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message="Name cannot be empty")
	    @Column(nullable=false)
	    private String name;

	    @NotBlank(message="Email cannot be empty")
	    @Email(message="please enter a valid email")
	    @Column(unique=true)
	    private String email;

	    @NotBlank(message="mobile number cannot be empty")
	    @Size(min=10,max=10, message="mobile number must be exactly 10 digits")
	    @Pattern(regexp="^[0-9]{10}$")
	    private String mobile;

	    @NotBlank(message = "Department is required")
	    private String department;

	    @NotBlank(message = "Designation is required")
	    private String designation;


	    @Positive(message = "salary must be greater than 0")
	    private double salary;

	    @NotBlank(message = "Joining date is required")
	    @Column(name="joining_date")
	    private String joiningDate;
	    
	    private String photo;
	    
	    @Column(nullable = false)
	    private String password;

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public Employee() {
	    }

	    public Employee(Long id, String name, String email, String mobile,
	                    String department, String designation,
	                    double salary, String joiningDate,String photo) {

	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.mobile = mobile;
	        this.department = department;
	        this.designation = designation;
	        this.salary = salary;
	        this.joiningDate = joiningDate;
	        this.photo=photo;
	        
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(String joiningDate) {
			this.joiningDate = joiningDate;
		}


	}


