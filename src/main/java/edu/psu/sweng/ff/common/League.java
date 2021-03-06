package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class League {

	private int id;
	
	private String name;
	
	private Member commissioner;
	
	private List<Team> teams;
	
	private Draft draft;
	
	private int week;
	
	private Schedule schedule;

	public League() {
		this.draft = new Draft();
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
		return this.draft.isAutomatic();
	}

	/**
	 * @param autoDraft the autoDraft to set
	 */
	public void setAutoDraft(boolean autoDraft) {
		this.draft.setAutomatic(autoDraft);
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
		this.draft.start(this);
	}
	
	public List<Player> getAvailablePlayers() {
		return this.draft.getAvailablePlayers(this);
	}
	
	/**
	 * Should return the team in this league owned by the specified Member
	 * 
	 * @param m
	 * @return
	 */
	public Team getTeam(Member m) {
		Team t = null;
		if (this.teams != null) {
			Iterator<Team> i = this.teams.iterator();
			while (i.hasNext()) {
				Team x = i.next();
				if (x.getOwner().equals(m)) {
					t = x;
				}
			}
		}
		return t;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
	
}
