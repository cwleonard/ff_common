package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Roster {

	@XmlTransient private int id;
	
	@XmlTransient private int week;
	
	@XmlTransient private List<Player> startingPlayers;
	
	@XmlTransient private List<Player> benchPlayers;

	public Roster() {
		startingPlayers = new ArrayList<Player>();
		benchPlayers = new ArrayList<Player>();
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
	 * @return the week
	 */
	@XmlElement
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
	@XmlElementWrapper
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
	@XmlElementWrapper
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
