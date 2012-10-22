package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

public class League {

	private int id;
	
	private String name;
	
	private Member commissioner;
	
	private boolean autoDraft;
	
	private Season season;
	
	private List<Team> teams;
	
	private Draft draft;
	
	private int week;

	public League() {
		this.teams = new ArrayList<Team>();
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
	 * @return the commissioner
	 */
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
	public void setWeek(int week) {
		this.week = week;
	}

	public void startDraft() throws DraftException {
		this.draft.setAutomatic(this.autoDraft);
		this.draft.start();
	}
	
	/**
	 * Should return the team in this league owned by the specified Member
	 * 
	 * @param m
	 * @return
	 */
	public Team getTeam(Member m) {
		//TODO: the right thing
		return new Team();
	}
	
}
