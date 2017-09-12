package pkgCore;

import java.util.UUID;

public class Player {

	private UUID PlayerID;
	private String PlayerName;
	public Player(String playerName) {
		
		PlayerID = UUID.randomUUID();
		this.PlayerName = playerName;
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public UUID getPlayerID() {
		return PlayerID;
	}
	
	
	
}
