package com.groupbmw.slp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@XmlRootElement
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sec_rol", sequenceName="sec_roles", allocationSize=1)
	@GeneratedValue(generator="sec_rol", strategy=GenerationType.SEQUENCE)
	private Integer idrol;

	private Boolean active;

	private String description;

	private String namerol;
	
	@OneToMany(mappedBy="role", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<User> users = new ArrayList<>();

	public Role() {
	}

	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNamerol() {
		return this.namerol;
	}

	public void setNamerol(String namerol) {
		this.namerol = namerol;
	}

}