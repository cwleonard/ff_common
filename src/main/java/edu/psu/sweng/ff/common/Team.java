package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Team {

	@XmlTransient private int id;
	
	@XmlTransient private String name;
	
	@XmlTransient private String logo;
	
	@XmlTransient private Member owner;
	
	@XmlTransient private List<Roster> rosters;
	
	@XmlTransient private Standings standings;

	public Team() {
		rosters = new ArrayList<Roster>();
	}
	
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
	 * @return the logo
	 */
	@XmlElement
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the owner
	 */
	@XmlElement
	public Member getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Member owner) {
		this.owner = owner;
	}

	/**
	 * @return the rosters
	 */
	@XmlElementWrapper
	public List<Roster> getRosters() {
		return rosters;
	}

	/**
	 * @param rosters the rosters to set
	 */
	public void setRosters(List<Roster> rosters) {
		this.rosters = rosters;
	}

	/**
	 * @return the standings
	 */
	@XmlElement
	public Standings getStandings() {
		return standings;
	}

	/**
	 * @param standings the standings to set
	 */
	public void setStandings(Standings standings) {
		this.standings = standings;
	}
	
	/**
	 * Should return the Roster for the given week.
	 * 
	 * @param week
	 * @return
	 */
	public Roster getRoster(int week) {
		return null;
	}
	
	/**
	 * Should return true if the specified player is on this team
	 * 
	 * @param p
	 * @return
	 */
	public boolean hasPlayer(Player p) {
		return false;
	}
}
