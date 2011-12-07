package net.guto.steamer;

import junit.framework.TestCase;

import org.w3c.dom.Document;

import static net.guto.steamer.Steamer.getDocument;

public class L4D2StatsTest extends TestCase {

	Stats stats;

	protected Stats execute(StatsClient client) {
		Document document = getDocument("src/test/resources/gutomaia-l4d2.xml");
		return client.getStats("gutomaia", "l4d2", document);
	}

	@Override
	protected void setUp() throws Exception {
		StatsClient client = new StatsClient();
		stats = execute(client);
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
}