package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Draft {

	private boolean automatic;

	private int round;
	
	private Member waitingFor;
	
	private League league;
	
	private transient List<Team> teamOrder;
	
	private int teamIndex;
	
	private transient PlayerSource playerSource;
	
	/**
	 * @return the automatic
	 */
	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 * @param automatic the automatic to set
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	
	public void start() throws DraftException {

		this.round = 1;
		this.teamIndex = 0;
		
		List<Team> lt = this.league.getTeams();
		teamOrder = new ArrayList<Team>(lt);
		Collections.shuffle(teamOrder);
		
		if (this.automatic) {
			
			if (this.playerSource == null) {
				throw new DraftException("draft is automatic and no player source is available");
			}
			
			do {
				
				Iterator<Team> i = teamOrder.iterator();
				while (i.hasNext()) {

					Team t = i.next();
					List<Player> players = this.getAvailablePlayers();

					Player p = players.get(0); // first player should be top rated
					Roster r = t.getRoster(0);

					if (this.isStarterRound()) {
						r.addStartingPlayer(p);
					} else {
						r.addBenchPlayer(p);
					}

				}
				
			} while (this.nextRound());
			
		} else {

			Team t = teamOrder.get(teamIndex);
			Member o = t.getOwner();
			this.waitingFor = o;
			//TODO: notify member that it's their turn
				
		}
		
	}
	
	public boolean draftPlayer(Player p) {
		
		Team team = this.teamOrder.get(this.teamIndex);
		Roster r = team.getRoster(0);
		if (this.isStarterRound()) {
			r.addStartingPlayer(p);
		} else {
			r.addBenchPlayer(p);
		}
		
		if (!this.nextTeam()) {
			this.nextRound();
		}
		
		Team nextTeam = teamOrder.get(teamIndex);
		Member o = nextTeam.getOwner();
		this.waitingFor = o;
		//TODO: notify next player
		
		return true;
		
	}

	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * @return the waitingFor
	 */
	public Member getWaitingFor() {
		return waitingFor;
	}

	/**
	 * @param waitingFor the waitingFor to set
	 */
	public void setWaitingFor(Member waitingFor) {
		this.waitingFor = waitingFor;
	}
	
	
	/**
	 * Should return a list of the players that are available
	 * in the current round of the draft.
	 * 
	 * @return
	 */
	public List<Player> getAvailablePlayers() {
		
		List<Player> plist = null;
		if (this.round == 1 || this.round == 11) {
			plist = playerSource.getByType("QB");
		} else if (this.round == 2 || this.round == 3 || this.round == 12 || this.round == 13) {
			plist = playerSource.getByType("RB");
		} else if (this.round == 4 || this.round == 5 || this.round == 14 || this.round == 15) {
			plist = playerSource.getByType("WR");
		} else if (this.round == 6 || this.round == 16) {
			plist = playerSource.getByType("TE");
		} else if (this.round == 7 || this.round == 8 || this.round == 17 || this.round == 18) {
			plist = playerSource.getByType("RB","WR","TE");
		} else if (this.round == 9 || this.round == 19) {
			plist = playerSource.getByType("DE");
		} else if (this.round == 10 || this.round == 20) {
			plist = playerSource.getByType("K");
		}
		return plist;
		
	}
	
	/**
	 * Should return true if this round is for picking bench players
	 * 
	 * @return
	 */
	public boolean isBenchRound() {
		return (round > 10);
	}
	
	/**
	 * Should return true if this round is for picking starting players
	 * 
	 * @return
	 */
	public boolean isStarterRound() {
		return (round < 11);
	}
	
	public boolean nextRound() {
		this.teamIndex = 0;
		this.round++;
		if (this.round == 21) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean nextTeam() {
		this.teamIndex++;
		if (this.teamIndex == this.teamOrder.size()) {
			return false;
		} else {
			return true;
		}
	}

	public PlayerSource getPlayerSource() {
		return playerSource;
	}

	public void setPlayerSource(PlayerSource playerSource) {
		this.playerSource = playerSource;
	}
	
	
	
}
