package net.guto.steamer;

import static net.guto.steamer.Steamer.getDocument;
import junit.framework.TestCase;

import org.w3c.dom.Document;

public class TF2StatsTest extends TestCase {

	Stats stats;

	protected Stats execute(StatsClient client) {
		Document document = getDocument("src/test/resources/gutomaia-tf2.xml");
		return client.getStats("gutomaia", "tf2", document);
	}

	@Override
	protected void setUp() throws Exception {
		StatsClient client = new StatsClient();
		stats = execute(client);
		assertNotNull(stats);
	}

	public void testTF2getVisibilityState(){
		assertEquals(3, stats.getVisibilityState());		
	}
	
	public void testTF2GameFriendlyName() {
		assertEquals("TF2", stats.getGameFriendlyName());
	}

	public void testTF2GameName() {
		assertEquals("Team Fortress 2", stats.getGameName());
	}

	public void testTF2GameLink() {
		assertEquals("http://store.steampowered.com/app/440", stats.getGameLink());
	}

	public void testTF2GameIcon() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/e3f595a92552da3d664ad00277fad2107345f743.jpg",
				stats.getGameIcon());
	}

	public void testTF2Logo() {
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg",
				stats.getGameLogo());
	}

	public void testTF2LogoSmall() {
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8_thumb.jpg",
				stats.getGameLogoSmall());
	}
	
	public void testTF2PlayerSteamID64(){
		assertEquals("76561197985077150",stats.getSteamID64().toString());
	}

	public void testTF2PlayerCustomURL(){
		assertEquals("gutomaia",stats.getPlayerCustomURL());
	}

}
