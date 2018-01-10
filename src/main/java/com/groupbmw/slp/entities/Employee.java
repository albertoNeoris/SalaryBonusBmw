package com.groupbmw.slp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sec_employee", sequenceName="sec_employees", allocationSize=1)
	@GeneratedValue(generator="sec_employee", strategy=GenerationType.SEQUENCE)
	private Integer idemployee;

	@Temporal(TemporalType.DATE)
	private Date dateofhire;

	private Integer employeenumber;

	private String firstname;

	

	private Integer idlevel;

	private Integer idorg;

	private Integer idsupervisor;

	private String lastname;

	private String middlename;

	private BigDecimal salary;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="idgroup", referencedColumnName="idgroup", nullable=false)
	private Group group;

	public Employee() {
	}

	public Integer getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}

	public Date getDateofhire() {
		return this.dateofhire;
	}

	public void setDateofhire(Date dateofhire) {
		this.dateofhire = dateofhire;
	}

	public Integer getEmployeenumber() {
		return this.employeenumber;
	}

	public void setEmployeenumber(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	

	public Integer getIdlevel() {
		return this.idlevel;
	}

	public void setIdlevel(Integer idlevel) {
		this.idlevel = idlevel;
	}

	public Integer getIdorg() {
		return this.idorg;
	}

	public void setIdorg(Integer idorg) {
		this.idorg = idorg;
	}

	public Integer getIdsupervisor() {
		return this.idsupervisor;
	}

	public void setIdsupervisor(Integer idsupervisor) {
		this.idsupervisor = idsupervisor;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	

}