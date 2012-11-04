package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team {

	private int id;
	
	private String name;
	
	private String logo;
	
	private Member owner;
	
	private List<Roster> rosters;
	
	private Standings standings;
	
	private int leagueId;
	
	private int points;
	
	private int wins;
	
	private int losses;

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

		Roster roster = null;
		Iterator<Roster> ri = this.rosters.iterator();
		while (ri.hasNext() && roster == null) {
			Roster r = ri.next();
			if (r.getWeek() == week) {
				roster = r;
			}
		}
		if (roster == null) {
			roster = new Roster();
			roster.setTeamId(id);
			roster.setWeek(week);
			rosters.add(roster);
		}
		return roster;
		
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

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * @param losses the losses to set
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	
}
