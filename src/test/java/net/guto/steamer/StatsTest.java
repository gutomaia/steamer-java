package net.guto.steamer;

import java.util.List;

import junit.framework.TestCase;

public class StatsTest extends TestCase {

	public void testL4D2Stats() {
		StatsClient client = new StatsClient();
		List<Achievement> achievements = client.getAchievements("gutomaia", "l4d2");
		assertNotNull(achievements);
		assertEquals(67, achievements.size());
	}
}
