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
		assertEquals(10.8f, game.getHoursLast2Weeks(), 0f);
		assertEquals("10.8", Float.toString(game.getHoursLast2Weeks()));
		assertEquals(17.5f, game.getHoursOnRecord(), 0f);
		assertEquals("17.5", Float.toString(game.getHoursOnRecord()));
		assertNull(game.getStatsLink());
		assertNull(game.getGlobalStatsLink());
		
		game = games.get(2);
		assertEquals(21660, game.getAppID());
		assertEquals("Street Fighter IV", game.getName());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/21660/6620b31699a355290d82dc18c9c73319ff0e2ac5.jpg",
				game.getLogo());
		assertEquals("http://store.steampowered.com/app/21660", game.getStoreLink());
		assertEquals(0.7f, game.getHoursLast2Weeks(), 0f);
		assertEquals("0.7", Float.toString(game.getHoursLast2Weeks()));
		assertEquals(25.7f, game.getHoursOnRecord(), 0f);
		assertEquals("25.7", Float.toString(game.getHoursOnRecord()));
		assertNull(game.getStatsLink());
		assertNull(game.getGlobalStatsLink());
		
		game = games.get(3);
		assertEquals(49400, game.getAppID());
		assertEquals("Magic: The Gathering - Duels of the Planeswalkers", game.getName());
		assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/49400/c108ccd1273bf897ba57a080f4a86584ace2dfda.jpg",
				game.getLogo());
		assertEquals("http://store.steampowered.com/app/49400", game.getStoreLink());
		assertEquals(0.5f, game.getHoursLast2Weeks(), 0f);
		assertEquals("0.5", Float.toString(game.getHoursLast2Weeks()));
		assertEquals(9.6f, game.getHoursOnRecord(), 0f);
		assertEquals("9.6", Float.toString(game.getHoursOnRecord()));
		assertEquals("http://steamcommunity.com/id/gutomaia/stats/Planeswalkers", game.getStatsLink());
		assertEquals("http://steamcommunity.com/stats/Planeswalkers/achievements/", game.getGlobalStatsLink());
	}
}