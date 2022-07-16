package p1.services;

import p1.testmodels.Player;

public interface PlayerService {
	
	public Player insertPlayer(Player player);
	
	public Player addPlayer(Player player);
	
	public Player viewAllPlayers(Player player);
	
	public Player deletePlayer(Player player);
	
	public Player viewPlayerById(Player player);
	
	public Player updatePlayer(Player player);
	
}
