package net.guto.steamer;

import static net.guto.steamer.Steamer.getDocument;

import java.util.List;

import org.w3c.dom.Document;

import junit.framework.TestCase;

public class L4D2StatsAchievementTest extends TestCase {

	protected List<Achievement> executeGetAchievements(StatsClient client) {
		Document document = getDocument("src/test/resources/gutomaia-l4d2.xml");
		return client.getAchievements("gutomaia", "L4D2", document);
	}

	List<Achievement> achievements;
	
	{
		StatsClient client = new StatsClient();
		achievements = executeGetAchievements(client);
	}
	
	public void testAchievementsSize() {
		assertNotNull(achievements);
		assertEquals(67, achievements.size());
	}

	public void testAcidReflexIconClosed() {
		Achievement achievement = achievements.get(0);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/8d94a8ffcb20fd11de547a6972bcef319fd93bf6.jpg",
				achievement.getIconClosed());
	}

	public void testAcidReflexIconOpen() {
		Achievement achievement = achievements.get(0);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/19c4af0f9bb24b719a086cbd3b63961d8348bf2b.jpg",
				achievement.getIconOpen());
	}

	public void testAcidReflexName() {
		Achievement achievement = achievements.get(0);
		assertEquals("ACID REFLEX", achievement.getName());
	}

	public void testAcidReflexApiname() {
		Achievement achievement = achievements.get(0);
		assertEquals("ach_kill_spitter_fast", achievement.getApiname());
	}

	public void testAcidReflexDescription() {
		Achievement achievement = achievements.get(0);
		assertEquals("Kill a Spitter before she is able to spit.", achievement.getDescription());
	}

	public void testAcidReflexTimeStamp() {
		Achievement achievement = achievements.get(0);
		assertNotNull(achievement.getTimestamp());
		assertEquals("1292701736000", Long.toString(achievement.getTimestamp().getTime()));
	}

	public void testAcidReflexIsAchieved() {
		Achievement achievement = achievements.get(0);
		assertTrue(achievement.isAchieved());
	}

	public void testCrassMenagerieIconClosed() {
		Achievement achievement = achievements.get(1);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/b1b772b233b812fd410aee1f175f8b1cb4fe4e43.jpg",
				achievement.getIconClosed());
	}

	public void testCrassMenagerieIconOpen() {
		Achievement achievement = achievements.get(1);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/1921292f1593086aa0dc7d29124e4c0c1119e084.jpg",
				achievement.getIconOpen());
	}

	public void testCrassMenagerieName() {
		Achievement achievement = achievements.get(1);
		assertEquals("CRASS MENAGERIE", achievement.getName());
	}

	public void testCrassMenagerieApiname() {
		Achievement achievement = achievements.get(1);
		assertEquals("ach_kill_every_uncommon_infected", achievement.getApiname());
	}

	public void testCrassMenagerieDescription() {
		Achievement achievement = achievements.get(1);
		assertEquals("Kill one of each Uncommon Infected.", achievement.getDescription());
	}

	public void testCrassMenagerieTimestamp() {
		Achievement achievement = achievements.get(1);
		assertNotNull(achievement.getTimestamp());
		assertEquals("1292451219000", Long.toString(achievement.getTimestamp().getTime()));
	}

	public void testCrassMenagerieIsAchieved() {
		Achievement achievement = achievements.get(1);
		assertTrue(achievement.isAchieved());
	}

	public void testARideDeniedIconClosed() {
		Achievement achievement = achievements.get(2);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/b65a6518c0680448e996e2190d1ed6b00ad14935.jpg",
				achievement.getIconClosed());
	}

	public void testARideDeniedIconOpen() {
		Achievement achievement = achievements.get(2);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/95bb3011848b129b4b7483017a970700a0a22bd1.jpg",
				achievement.getIconOpen());
	}

	public void testARideDeniedName() {
		Achievement achievement = achievements.get(2);
		assertEquals("A RIDE DENIED", achievement.getName());
	}

	public void testARideDeniedApiname() {
		Achievement achievement = achievements.get(2);
		assertEquals("ach_save_player_from_jockey_fast", achievement.getApiname());
	}

	public void testARideDeniedDescription() {
		Achievement achievement = achievements.get(2);
		assertEquals("Kill a Jockey within 2 seconds of it jumping on a Survivor.", achievement.getDescription());
	}

	public void testArmoryOfOneIconClosed() {
		Achievement achievement = achievements.get(3);

		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/4eb2b093ce1dd442da4a62c9a0659602fbfc0d1e.jpg",
				achievement.getIconClosed());
	}

	public void testArmoryOfOneIconOpen() {
		Achievement achievement = achievements.get(3);
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/4fc103dcb52ccc748b5bdea66924d1bf5c9e0705.jpg",
				achievement.getIconOpen());
	}

	public void testArmoryOfOneName() {
		Achievement achievement = achievements.get(3);
		assertEquals("ARMORY OF ONE", achievement.getName());
	}

	public void testArmoryOfOneApiname() {
		Achievement achievement = achievements.get(3);
		assertEquals("ach_deploy_ammo_upgrade", achievement.getApiname());
	}

	public void testArmoryOfOneDescription() {
		Achievement achievement = achievements.get(3);
		assertEquals("Deploy an ammo upgrade and have your team use it.", achievement.getDescription());
	}
}
