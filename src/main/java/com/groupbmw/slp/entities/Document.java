package com.groupbmw.slp.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@XmlRootElement
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddocuments;

	private String documentdescr;

	private String documentlink;

	private String documenttype;

	public Document() {
	}

	public Integer getIddocuments() {
		return this.iddocuments;
	}

	public void setIddocuments(Integer iddocuments) {
		this.iddocuments = iddocuments;
	}

	public String getDocumentdescr() {
		return this.documentdescr;
	}

	public void setDocumentdescr(String documentdescr) {
		this.documentdescr = documentdescr;
	}

	public String getDocumentlink() {
		return this.documentlink;
	}

	public void setDocumentlink(String documentlink) {
		this.documentlink = documentlink;
	}

	public String getDocumenttype() {
		return this.documenttype;
	}

	public void setDocumenttype(String documenttype) {
		this.documenttype = documenttype;
	}

}