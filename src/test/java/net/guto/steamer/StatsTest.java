package net.guto.steamer;

import java.util.List;

import junit.framework.TestCase;

public class StatsTest extends TestCase {

	public void testAchievements() {
		StatsClient client = new StatsClient();
		List<Achievement> achievements = client.getAchievements("gutomaia", "l4d2");
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
	}
}
