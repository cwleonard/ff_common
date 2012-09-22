package edu.psu.sweng.ff.common;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class League {

	@XmlTransient private int id;
	
	@XmlTransient private String name;
	
	@XmlTransient private Member commissioner;
	
	@XmlTransient private boolean autoDraft;
	
	@XmlTransient private Season season;
	
	@XmlTransient private List<Team> teams;
	
	@XmlTransient private Draft draft;
	
	@XmlTransient private int week;

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

	/**
	 * @return the season
	 */
	@XmlElement
	public Season getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * @return the teams
	 */
	@XmlElementWrapper
	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams the teams to set
	 */
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @return the draft
	 */
	public Draft getDraft() {
		return draft;
	}

	/**
	 * @param draft the draft to set
	 */
	public void setDraft(Draft draft) {
		this.draft = draft;
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
	@XmlElement
	public void setWeek(int week) {
		this.week = week;
	}

	public void startDraft() {
		this.draft.start();
	}
	
	/**
	 * Should return the team in this league owned by the specified Member
	 * 
	 * @param m
	 * @return
	 */
	public Team getTeam(Member m) {
		return null;
	}
	
}
