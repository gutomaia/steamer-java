package net.guto.steamer;

public class SteamGame {

	public int appID;

	public int getAppID() {
		return appID;
	}

	public String getName() {
		return "Team Fortress 2";
	}

	public String getLogo() {
		return "http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg";
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