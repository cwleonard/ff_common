package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Draft {

	private boolean automatic;

	private int round;
	
	private Member waitingFor;
	
	private int leagueId;
	
	private transient List<Team> teamOrder;
	
	private int teamIndex;
	
	private transient PlayerSource playerSource;
	
	private transient Notifier notifier;
	
	private transient RosterStore rosterStore;
	
	//private transient League league;
	
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
	
	public void start(League league) throws DraftException {

		this.round = 1;
		this.teamIndex = 0;
		
		List<Team> lt = league.getTeams();
		
		if (lt.size() < 2) {
			throw new DraftException("draft cannot start until there are at least 2 teams in the league");
		}
		
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
					List<Player> players = this.getAvailablePlayers(league);

					Player p = players.get(0); // first player should be top rated
					Roster r = t.getRoster(1);

					if (this.isStarterRound()) {
						r.addStartingPlayer(p);
					} else {
						r.addBenchPlayer(p);
					}
					
					if (this.rosterStore != null) {
						try {
							this.rosterStore.store(r);
						} catch (DatabaseException e) {
							throw new DraftException("Database problem with the draft!");
						}
					}

				}
				
			} while (this.nextRound());
			
		} else {

			Team t = teamOrder.get(teamIndex);
			Member o = t.getOwner();
			this.waitingFor = o;
			if (this.notifier != null) {
				notifier.notify(o, "Fantasy Football Draft",
						"It is your turn to draft a player for your team \""
								+ t.getName() + "\"");
			}
				
		}
		
	}
	
	public boolean draftPlayer(Player p) throws DraftException {
		
		Team team = this.teamOrder.get(this.teamIndex);
		Roster r = team.getRoster(1);
		if (this.isStarterRound()) {
			r.addStartingPlayer(p);
		} else {
			r.addBenchPlayer(p);
		}
		
		if (this.rosterStore != null) {
			try {
				this.rosterStore.store(r);
			} catch (DatabaseException e) {
				throw new DraftException("Database problem with the draft!");
			}
		}
		
		if (!this.nextTeam()) {
			this.nextRound();
		}
		
		Team nextTeam = teamOrder.get(teamIndex);
		Member o = nextTeam.getOwner();
		this.waitingFor = o;
		
		if (this.notifier != null) {
			notifier.notify(o, "Fantasy Football Draft",
					"It is your turn to draft a player for your team \""
							+ nextTeam.getName() + "\"");
		}
		
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
	
	
	public String[] getCurrentPosition() {
		
		String[] p = null;
		if (this.round == 1 || this.round == 11) {
			p = new String[1];
			p[0] = "QB";
		} else if (this.round == 2 || this.round == 3 || this.round == 12 || this.round == 13) {
			p = new String[1];
			p[0] = "RB";
		} else if (this.round == 4 || this.round == 5 || this.round == 14 || this.round == 15) {
			p = new String[1];
			p[0] = "WR";
		} else if (this.round == 6 || this.round == 16) {
			p = new String[1];
			p[0] = "TE";
		} else if (this.round == 7 || this.round == 8 || this.round == 17 || this.round == 18) {
			p = new String[3];
			p[0] = "RB";
			p[1] = "WR";
			p[2] = "TE";
		} else if (this.round == 9 || this.round == 19) {
			p = new String[1];
			p[0] = "DE";
		} else if (this.round == 10 || this.round == 20) {
			p = new String[1];
			p[0] = "K";
		}
		return p;
		
	}
	
	/**
	 * Should return a list of the players that are available
	 * in the current round of the draft.
	 * 
	 * @return
	 */
	public List<Player> getAvailablePlayers(League league) {
		
		List<Player> plist = null;
		if (playerSource != null) {
			plist = playerSource.getByType(league.getId(), this.getCurrentPosition());
//			if (this.round == 1 || this.round == 11) {
//				plist = playerSource.getByType(league.getId(), "QB");
//			} else if (this.round == 2 || this.round == 3 || this.round == 12 || this.round == 13) {
//				plist = playerSource.getByType(league.getId(), "RB");
//			} else if (this.round == 4 || this.round == 5 || this.round == 14 || this.round == 15) {
//				plist = playerSource.getByType(league.getId(), "WR");
//			} else if (this.round == 6 || this.round == 16) {
//				plist = playerSource.getByType(league.getId(), "TE");
//			} else if (this.round == 7 || this.round == 8 || this.round == 17 || this.round == 18) {
//				plist = playerSource.getByType(league.getId(), "RB","WR","TE");
//			} else if (this.round == 9 || this.round == 19) {
//				plist = playerSource.getByType(league.getId(), "DE");
//			} else if (this.round == 10 || this.round == 20) {
//				plist = playerSource.getByType(league.getId(), "K");
//			}
		} else {
			plist = new ArrayList<Player>();
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

	/**
	 * @return the league
	 */
	public int getLeagueId() {
		return leagueId;
	}

	/**
	 * @return the teamIndex
	 */
	public int getTeamIndex() {
		return teamIndex;
	}

	/**
	 * @param teamIndex the teamIndex to set
	 */
	public void setTeamIndex(int teamIndex) {
		this.teamIndex = teamIndex;
	}

	/**
	 * @return the notifier
	 */
	public Notifier getNotifier() {
		return notifier;
	}

	/**
	 * @param notifier the notifier to set
	 */
	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	/**
	 * @return the rosterStore
	 */
	public RosterStore getRosterStore() {
		return rosterStore;
	}

	/**
	 * @param rosterStore the rosterStore to set
	 */
	public void setRosterStore(RosterStore rosterStore) {
		this.rosterStore = rosterStore;
	}
	
	public boolean started() {
		return (this.round > 0);
	}

	public boolean finished() {
		return (this.round > 20);
	}

	/**
	 * @param leagueId the leagueId to set
	 */
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	/**
	 * @return the teamOrder
	 */
	public List<Team> getTeamOrder() {
		return teamOrder;
	}

	/**
	 * @param teamOrder the teamOrder to set
	 */
	public void setTeamOrder(List<Team> teamOrder) {
		this.teamOrder = teamOrder;
	}
	
	
	
}
