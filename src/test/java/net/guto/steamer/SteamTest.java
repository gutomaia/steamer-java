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
	} 
}
