package net.guto.steamer;

import static net.guto.steamer.Steamer.getDocument;

import java.util.List;

import org.w3c.dom.Document;

import junit.framework.TestCase;

public class TF2StatsAchievementTest extends TestCase {

	protected List<Achievement> executeGetAchievements(StatsClient client) {
		Document document = getDocument("src/test/resources/gutomaia-tf2.xml");
		return client.getAchievements("gutomaia", "TF2", document);
	}

	List<Achievement> achievements;
	
	{
		StatsClient client = new StatsClient();
		achievements = executeGetAchievements(client);
	}
	
	public void testAchievementsSize() {
		assertNotNull(achievements);
		assertEquals(381, achievements.size());
	}


	public void testHeadOfTheClassIconClosed() {
		Achievement achievement = achievements.get(0);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_play_game_everyclass.jpg",
				achievement.getIconClosed());
	}
	
	public void testHeadOfTheClassIconOpen() {
		Achievement achievement = achievements.get(0);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_play_game_everyclass_bw.jpg",
				achievement.getIconOpen());
	}
	
	public void testHeadOfTheClassName() {
		Achievement achievement = achievements.get(0);
		assertEquals("Head of the Class", achievement.getName());
	}

	public void testHeadOfTheClassApiname() {
		Achievement achievement = achievements.get(0);
		assertEquals("tf_play_game_everyclass", achievement.getApiname());
	}

	public void testHeadOfTheClassDescription() {
		Achievement achievement = achievements.get(0);
		assertEquals("Play a complete round with every class.", achievement.getDescription());
	}

	public void testHeadOfTheClassTimeStamp() {
		Achievement achievement = achievements.get(0);
		assertNull(achievement.getTimestamp());
	}

	public void testHeadOfTheClassIsAchieved() {
		Achievement achievement = achievements.get(0);
		assertFalse(achievement.isAchieved());
	}
	
	public void testWorldTravelerIconClosed() {
		Achievement achievement = achievements.get(1);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_play_game_everymap.jpg",
				achievement.getIconClosed());
	}

	public void testWorldTravelerIconOpen() {
		Achievement achievement = achievements.get(1);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_play_game_everymap_bw.jpg",
				achievement.getIconOpen());
	}

	public void testWorldTravelerName() {
		Achievement achievement = achievements.get(1);
		assertEquals("World Traveler", achievement.getName());
	}

	public void testWorldTravelerApiname() {
		Achievement achievement = achievements.get(1);
		assertEquals("tf_play_game_everymap", achievement.getApiname());
	}

	public void testWorldTravelerDescription() {
		Achievement achievement = achievements.get(1);
		assertEquals("Play a complete game on 2Fort, Dustbowl, Granary, Gravel Pit, Hydro, and Well (CP).", achievement.getDescription());
	}

	public void testWorldTravelerTimestamp() {
		Achievement achievement = achievements.get(1);
		assertNull(achievement.getTimestamp());
	}

	public void testWorldTravelerIsAchieved() {
		Achievement achievement = achievements.get(1);
		assertFalse(achievement.isAchieved());
	}

	public void testTeamDoctorIconClosed() {
		Achievement achievement = achievements.get(2);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_get_healpoints.jpg",
				achievement.getIconClosed());
	}

	public void testTeamDoctorIconOpen() {
		Achievement achievement = achievements.get(2);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_get_healpoints_bw.jpg",
				achievement.getIconOpen());
	}

	public void testTeamDoctorName() {
		Achievement achievement = achievements.get(2);
		assertEquals("Team Doctor", achievement.getName());
	}

	public void testTeamDoctorApiname() {
		Achievement achievement = achievements.get(2);
		assertEquals("tf_get_healpoints", achievement.getApiname());
	}

	public void testTeamDoctorDescription() {
		Achievement achievement = achievements.get(2);
		assertEquals("Accumulate 25000 heal points as a Medic.", achievement.getDescription());
	}

	public void testFlamethrowerIconClosed() {
		Achievement achievement = achievements.get(3);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_burn_playersinminimumtime.jpg",
				achievement.getIconClosed());
	}

	public void testFlamethrowerIconOpen() {
		Achievement achievement = achievements.get(3);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/tf_burn_playersinminimumtime_bw.jpg",
				achievement.getIconOpen());
	}

	public void testFlamethrowerName() {
		Achievement achievement = achievements.get(3);
		assertEquals("Flamethrower", achievement.getName());
	}

	public void testFlamethrowerApiname() {
		Achievement achievement = achievements.get(3);
		assertEquals("tf_burn_playersinminimumtime", achievement.getApiname());
	}

	public void testFlamethrowerDescription() {
		Achievement achievement = achievements.get(3);
		assertEquals("Set five enemies on fire in 30 seconds.", achievement.getDescription());
	}
}
