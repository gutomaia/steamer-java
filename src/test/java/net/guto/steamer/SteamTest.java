package net.guto.steamer;

import java.util.List;

import junit.framework.TestCase;

public class SteamTest extends TestCase {
	
	public void testFetchGutoMaiaData() {
		Steamer steamer = new Steamer();
		SteamUser gutomaia = steamer.getUser("gutomaia");
		assertNotNull(gutomaia);
		assertEquals("gutomaia", gutomaia.getSteamId());
		assertEquals(76561197985077150l, gutomaia.getSteamId64(), 0l);
		assertEquals("76561197985077150", gutomaia.getSteamId64().toString());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706.jpg", gutomaia.getAvatarIcon());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_medium.jpg", gutomaia.getAvatarMedium());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_full.jpg", gutomaia.getAvatarFull());
		assertEquals("gutomaia", gutomaia.getCustomUrl());
		assertEquals("Salvador, Bahia, Brazil", gutomaia.getLocation());
	}

	public void testFetchGobliData() {
		Steamer steamer = new Steamer();
		SteamUser gobli = steamer.getUser("gobli");
		assertNotNull(gobli);
		assertEquals("Gobli", gobli.getSteamId());
		assertEquals(76561198029691735l, gobli.getSteamId64(), 0l);
		assertEquals("76561198029691735", gobli.getSteamId64().toString());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b.jpg", gobli.getAvatarIcon());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b_medium.jpg", gobli.getAvatarMedium());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b_full.jpg", gobli.getAvatarFull());
		assertEquals("gobli", gobli.getCustomUrl());
		assertEquals("", gobli.getLocation());
	}
	
	public void testFetchGutoMaiaGames(){
		Steamer steamer = new Steamer();
		SteamUser gutomaia = steamer.getUser("gutomaia");
		assertNotNull(gutomaia);
		List<SteamGame> games = gutomaia.getGames();
		assertNotNull(games);
	}

}
