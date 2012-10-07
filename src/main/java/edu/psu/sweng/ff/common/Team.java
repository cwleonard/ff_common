package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private int id;
	
	private String name;
	
	private String logo;
	
	private Member owner;
	
	private List<Roster> rosters;
	
	private Standings standings;
	
	private int leagueId;

	public Team() {
		rosters = new ArrayList<Roster>();
	}
	
	/**
	 * @return the id
	 */
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
		return new Roster();
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

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	
	
}
