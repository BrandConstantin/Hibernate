package es.hibernate.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.hibernate.dateutils.DateUtils;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	@Column(name="modifiedDate")
    @Temporal(TemporalType.DATE)    
    private Date dateOfModified;
	
	public Employee() {}

	public Employee(String firstName, String lastName, String company, Date dateOfModified) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.dateOfModified = dateOfModified;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getDateOfModified() {
		return dateOfModified;
	}

	public void setDateOfModified(Date dateOfModified) {
		this.dateOfModified = dateOfModified;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ ", dateOfModified=" + DateUtils.formatDate(dateOfModified) + "]";
	}
	
}
