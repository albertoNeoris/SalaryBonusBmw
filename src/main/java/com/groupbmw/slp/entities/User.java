package com.groupbmw.slp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findActivos",
    query="SELECT u FROM User u WHERE u.active = '1'"),
}) 

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sec_user", sequenceName="sec_users", allocationSize=1)
	@GeneratedValue(generator="sec_user", strategy=GenerationType.SEQUENCE)
	private Integer iduser;
	
	

	private String active;

	

	

	@Temporal(TemporalType.DATE)
	private Date lastaccess;

	private String loginuser;

	private String password;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="idrol", referencedColumnName="idrol", nullable=false)
	private Role role;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="idemployee", referencedColumnName="idemployee")
	private Employee employee;

	public User() {
	}

	public Integer getIduser() {
		return this.iduser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}





	public Date getLastaccess() {
		return this.lastaccess;
	}

	public void setLastaccess(Date lastaccess) {
		this.lastaccess = lastaccess;
	}

	public String getLoginuser() {
		return this.loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}