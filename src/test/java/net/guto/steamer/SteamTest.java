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
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706.jpg",
				gutomaia.getAvatarIcon());
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_medium.jpg",
				gutomaia.getAvatarMedium());
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/avatars/56/566f5c7e9126864777b7d9d3cfe9f8e62e27f706_full.jpg",
				gutomaia.getAvatarFull());
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
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b.jpg",
				gobli.getAvatarIcon());
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b_medium.jpg",
				gobli.getAvatarMedium());
		assertEquals(
				"http://media.steampowered.com/steamcommunity/public/images/avatars/48/48fe321d0f0114062448151ea422656405420e0b_full.jpg",
				gobli.getAvatarFull());
		assertEquals("gobli", gobli.getCustomUrl());
		assertEquals("", gobli.getLocation());
	}

	public void testFetchGutoMaiaGames() {
		Steamer steamer = new Steamer();
		List<SteamGame> games = steamer.getGames("gutomaia");
		assertNotNull(games);
		assertEquals(285, games.size());
		SteamGame game = games.get(0);
		assertEquals(440, game.getAppID());
		assertEquals("Team Fortress 2", game.getName());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/440/07385eb55b5ba974aebbe74d3c99626bda7920b8.jpg",
				game.getLogo());
		assertEquals("http://store.steampowered.com/app/440", game.getStoreLink());
		assertEquals(13.5f, game.getHoursLast2Weeks(), 0f);
		assertEquals("13.5", Float.toString(game.getHoursLast2Weeks()));
		assertEquals(589.7f, game.getHoursOnRecord(), 0f);
		assertEquals("589.7", Float.toString(game.getHoursOnRecord()));
		assertEquals("http://steamcommunity.com/id/gutomaia/stats/TF2", game.getStatsLink());
		assertEquals("http://steamcommunity.com/stats/TF2/achievements/", game.getGlobalStatsLink());

		game = games.get(1);
		assertEquals(35010, game.getAppID());
		assertEquals("Batman: Arkham Asylum", game.getName());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/35010/172e0928b845c18491f1a8fee0dafe7a146ac129.jpg",
				game.getLogo());
		assertEquals("http://store.steampowered.com/app/35010", game.getStoreLink());

	}
}