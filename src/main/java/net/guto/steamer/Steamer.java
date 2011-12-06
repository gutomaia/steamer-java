package net.guto.steamer;

public class Steamer {

	public SteamUser getUser(String steamId) {
		SteamUser user = new SteamUser(steamId);
		return user;
	}
}
