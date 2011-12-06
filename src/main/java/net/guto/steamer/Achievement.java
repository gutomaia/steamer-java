package net.guto.steamer;

public class Achievement {

	public String iconClosed;
	public String iconOpen;
	public String name;

	public String getIconClosed() {
		return iconClosed;
	}

	public String getIconOpen() {
		return iconOpen;
	}

	public String getName() {
		return name;
	}

	public String getApiname() {
		return "ach_kill_spitter_fast";
	}

	public String getDescription() {
		return "Kill a Spitter before she is able to spit.";
	}
}
