package net.guto.steamer;

import java.util.List;

import junit.framework.TestCase;

import org.w3c.dom.Document;

import static net.guto.steamer.Steamer.getDocument;

public class L4D2StatsTest extends TestCase {

	Stats stats;

	protected Stats executeGetStats(StatsClient client) {
		Document document = getDocument("src/test/resources/gutomaia-l4d2.xml");
		return client.getStats("gutomaia", "l4d2", document);
	}

	@Override
	protected void setUp() throws Exception {
		StatsClient client = new StatsClient();
		stats = executeGetStats(client);
		assertNotNull(stats);
	}

	public void testL4D2GameFriendlyName() {
		assertEquals("L4D2", stats.getGameFriendlyName());
	}

	public void testL4D2GameName() {
		assertEquals("Left 4 Dead 2", stats.getGameName());
	}

	public void testL4D2GameLink() {
		assertEquals("http://store.steampowered.com/app/550", stats.getGameLink());
	}

	public void testL4D2GameIcon() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/7d5a243f9500d2f8467312822f8af2a2928777ed.jpg",
				stats.getGameIcon());
	}

	public void testL4D2Logo() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142.jpg",
				stats.getGameLogo());
	}

	public void testL4D2LogoSmall() {
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/apps/550/205863cc21e751a576d6fff851984b3170684142_thumb.jpg",
				stats.getGameLogoSmall());
	}
	
	public void testL4D2PlayerSteamID64(){
		assertEquals("76561197985077150",stats.getSteamID64().toString());
	}

	
	public void testL4D2PlayerCustomURL(){
		assertEquals("gutomaia",stats.getPlayerCustomURL());
	}
	
	public void testL4D2StatsHoursPlayed(){
		assertEquals("0.0", stats.getStatsHoursPlayerd().toString());
	}
	
	public void testAchievements() {
		Document document = getDocument("src/test/resources/gutomaia-l4d2.xml");

		StatsClient client = new StatsClient();
		List<Achievement> achievements = client.getAchievements("gutomaia", "L4D2", document);

		assertNotNull(achievements);
		assertEquals(67, achievements.size());

		Achievement achievement = achievements.get(0);

		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/8d94a8ffcb20fd11de547a6972bcef319fd93bf6.jpg",
				achievement.getIconClosed());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/19c4af0f9bb24b719a086cbd3b63961d8348bf2b.jpg",
				achievement.getIconOpen());
		assertEquals("ACID REFLEX", achievement.getName());
		assertEquals("ach_kill_spitter_fast", achievement.getApiname());
		assertEquals("Kill a Spitter before she is able to spit.", achievement.getDescription());

		achievement = achievements.get(1);

		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/b1b772b233b812fd410aee1f175f8b1cb4fe4e43.jpg",
				achievement.getIconClosed());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/1921292f1593086aa0dc7d29124e4c0c1119e084.jpg",
				achievement.getIconOpen());
		assertEquals("CRASS MENAGERIE", achievement.getName());
		assertEquals("ach_kill_every_uncommon_infected", achievement.getApiname());
		assertEquals("Kill one of each Uncommon Infected.", achievement.getDescription());

		achievement = achievements.get(2);

		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/b65a6518c0680448e996e2190d1ed6b00ad14935.jpg",
				achievement.getIconClosed());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/95bb3011848b129b4b7483017a970700a0a22bd1.jpg",
				achievement.getIconOpen());
		assertEquals("A RIDE DENIED", achievement.getName());
		assertEquals("ach_save_player_from_jockey_fast", achievement.getApiname());
		assertEquals("Kill a Jockey within 2 seconds of it jumping on a Survivor.", achievement.getDescription());

		achievement = achievements.get(3);

		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/4eb2b093ce1dd442da4a62c9a0659602fbfc0d1e.jpg",
				achievement.getIconClosed());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/550/4fc103dcb52ccc748b5bdea66924d1bf5c9e0705.jpg",
				achievement.getIconOpen());
		assertEquals("ARMORY OF ONE", achievement.getName());
		assertEquals("ach_deploy_ammo_upgrade", achievement.getApiname());
		assertEquals("Deploy an ammo upgrade and have your team use it.", achievement.getDescription());
	}

}