package net.guto.steamer.integration;

import java.util.List;

import net.guto.steamer.Achievement;
import net.guto.steamer.L4D2StatsTest;
import net.guto.steamer.Stats;
import net.guto.steamer.StatsClient;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class L4D2StatsIT extends L4D2StatsTest {

	public final int port = 8080;
	Server server;
	StatsServlet statsServlet;

	@Override
	protected Stats executeGetStats(StatsClient client) {
		return client.getStats("gutomaia", "l4d2");
	}

	@Override
	protected List<Achievement> executeGetAchievements(StatsClient client) {
		return client.getAchievements("gutomaia", "L4D2");
	}

	@Override
	protected void setUp() throws Exception {
		try {
			WebAppContext fakeSteam = new WebAppContext();
			fakeSteam.setWar("src/test/webapp");
			fakeSteam.setContextPath("/");
			statsServlet = new StatsServlet();
			ServletHolder statsHolder = new ServletHolder(statsServlet);
			statsHolder.setInitOrder(1);
			fakeSteam.addServlet(statsHolder, "/*");
			server = new Server(port);
			server.setStopAtShutdown(false);
			server.setHandler(fakeSteam);
			server.start();
		} catch (Exception e) {
			server = null;
			fail("Failing while stating server");
		}
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (server != null) server.stop();
		statsServlet = null;
	}
}
