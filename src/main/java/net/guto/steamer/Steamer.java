package net.guto.steamer;

import java.util.ArrayList;
import java.util.List;

public class Steamer {

	public SteamUser getUser(String steamId) {
		SteamUser user = new SteamUser(steamId);
		return user;
	}

	public List<SteamGame> getGames(String steamId) {
		return new ArrayList<SteamGame>();
	}
}
