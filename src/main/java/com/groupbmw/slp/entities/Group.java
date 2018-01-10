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


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sec_group", sequenceName="sec_groups", allocationSize=1)
	@GeneratedValue(generator="sec_group", strategy=GenerationType.SEQUENCE)
	private Integer idgroup;

	private String description;

	private String groupname;
	
	@OneToMany(mappedBy="group", cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	private List<Employee> employee = new ArrayList<>();

	public Group() {
	}

	public Integer getIdgroup() {
		return this.idgroup;
	}

	public void setIdgroup(Integer idgroup) {
		this.idgroup = idgroup;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

}