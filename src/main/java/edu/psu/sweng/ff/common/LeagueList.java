package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Leagues")
public class LeagueList {

	@XmlTransient List<League> leagues;
	
	public LeagueList() {
		leagues = new ArrayList<League>();
	}
	
	public LeagueList(List<League> l) {
		leagues = l;
	}

	@XmlElement
	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}
	
	
	
	
}
