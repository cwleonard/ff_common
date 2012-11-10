package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

public class Roster {

	private int id;
	
	private int teamId;
	
	private int week;
	
	private List<Player> startingPlayers;
	
	private List<Player> benchPlayers;

	public Roster() {
		startingPlayers = new ArrayList<Player>();
		benchPlayers = new ArrayList<Player>();
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
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the week
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(int week) {
		this.week = week;
	}

	/**
	 * @return the startingPlayers
	 */
	public List<Player> getStartingPlayers() {
		return startingPlayers;
	}

	/**
	 * @param startingPlayers the startingPlayers to set
	 */
	public void setStartingPlayers(List<Player> startingPlayers) {
		this.startingPlayers = startingPlayers;
	}

	/**
	 * @return the benchPlayers
	 */
	public List<Player> getBenchPlayers() {
		return benchPlayers;
	}

	/**
	 * @param benchPlayers the benchPlayers to set
	 */
	public void setBenchPlayers(List<Player> benchPlayers) {
		this.benchPlayers = benchPlayers;
	}
	
	public void addStartingPlayer(Player p) {
		this.startingPlayers.add(p);
	}
	
	public void addBenchPlayer(Player p) {
		this.benchPlayers.add(p);
	}
	
	public void removeStartingPlayer(Player p) {
		//TODO
	}
	
	public void removeBenchPlayer(Player p) {
		//TODO
	}
	
	public void removePlayer(Player p) {
		//TODO
	}
	
}
