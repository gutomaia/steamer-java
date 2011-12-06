package net.guto.steamer;

import junit.framework.TestCase;

public class SteamTest extends TestCase {

	public void testBasic() {
		Steamer steamer = new Steamer();
		SteamUser gutomaia = steamer.getUser("gutomaia");
		assertNotNull(gutomaia);
		assertEquals("gutomaia", gutomaia.getSteamId());
		assertEquals(76561197985077150l, gutomaia.getSteamId64(), 0l);
		assertEquals("76561197985077150", gutomaia.getSteamId64().toString());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706.jpg", gutomaia.getAvatarIcon());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_medium.jpg", gutomaia.getAvatarMedium());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_full.jpg", gutomaia.getAvatarFull());
	}
}
