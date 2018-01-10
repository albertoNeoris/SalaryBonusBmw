package com.groupbmw.slp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the periods database table.
 * 
 */
@Entity
@Table(name="periods")
@NamedQuery(name="Period.findAll", query="SELECT p FROM Period p")
public class Period implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sec_periods", sequenceName="sec_periods", allocationSize=1)
	@GeneratedValue(generator="sec_periods", strategy=GenerationType.SEQUENCE)
	private Integer idperiod;

	private String idquarter;

	@Temporal(TemporalType.DATE)
	private Date periodfinal;

	@Temporal(TemporalType.DATE)
	private Date periodinitial;

	public Period() {
	}

	public Integer getIdperiod() {
		return this.idperiod;
	}

	public void setIdperiod(Integer idperiod) {
		this.idperiod = idperiod;
	}

	public String getIdquarter() {
		return this.idquarter;
	}

	public void setIdquarter(String idquarter) {
		this.idquarter = idquarter;
	}

	public Date getPeriodfinal() {
		return this.periodfinal;
	}

	public void setPeriodfinal(Date periodfinal) {
		this.periodfinal = periodfinal;
	}

	public Date getPeriodinitial() {
		return this.periodinitial;
	}

	public void setPeriodinitial(Date periodinitial) {
		this.periodinitial = periodinitial;
	}

}