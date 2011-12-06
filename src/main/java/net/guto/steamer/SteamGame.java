package net.guto.steamer;

public class SteamGame {

	public int appID;
	public String name;
	public String logo;
	public String storeLink;
	public String statsLink;
	public String globalStatsLink;

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
		return storeLink;
	}

	public float getHoursLast2Weeks() {
		return 13.5f;
	}

	public float getHoursOnRecord() {
		return 589.7f;
	}

	public String getStatsLink() {
		return statsLink;
	}

	public String getGlobalStatsLink() {
		return globalStatsLink;
	}
}