package edu.psu.sweng.ff.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class League {

	@XmlTransient private int id;
	
	@XmlTransient private String name;
	
	@XmlTransient private Member commissioner;
	
	@XmlTransient private boolean autoDraft;

	/**
	 * @return the id
	 */
	@XmlElement
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the commissioner
	 */
	@XmlElement
	public Member getCommissioner() {
		return commissioner;
	}

	/**
	 * @param commissioner the commissioner to set
	 */
	public void setCommissioner(Member commissioner) {
		this.commissioner = commissioner;
	}

	/**
	 * @return the autoDraft
	 */
	@XmlElement
	public boolean isAutoDraft() {
		return autoDraft;
	}

	/**
	 * @param autoDraft the autoDraft to set
	 */
	public void setAutoDraft(boolean autoDraft) {
		this.autoDraft = autoDraft;
	}
	
	
	
}
