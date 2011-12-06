package net.guto.steamer;

import junit.framework.TestCase;

public class SteamTest extends TestCase {

	public void testBasic() {
		Steamer steamer = new Steamer();
		SteamUser gutomaia = steamer.getUser("gutomaia");
		assertNotNull(gutomaia);
		assertEquals("gutomaia", gutomaia.getSteamId());
	} 
}
