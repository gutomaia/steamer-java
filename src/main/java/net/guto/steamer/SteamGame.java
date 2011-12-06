package net.guto.steamer;

public class SteamGame {

	public int appID;
	public String name;
	public String logo;

	public int getAppID() {
		return appID;
	}

	public String getName() {
		return name;
	}

	public String getLogo() {
		return logo;
	}

	public String getStoreLink() {
		return "http://store.steampowered.com/app/440";
	}

	public float getHoursLast2Weeks() {
		return 13.5f;
	}

	public float getHoursOnRecord() {
		return 589.7f;
	}

	public String getStatsLink() {
		return "http://steamcommunity.com/id/gutomaia/stats/TF2";
	}

	public String getGlobalStatsLink() {
		return "http://steamcommunity.com/stats/TF2/achievements/";
	}
}