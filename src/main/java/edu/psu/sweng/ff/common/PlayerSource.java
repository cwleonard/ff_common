package edu.psu.sweng.ff.common;

import java.util.List;

public interface PlayerSource {

	public List<Player> getByType(String type);
	
	public List<Player> getByType(String... types);
	
}
