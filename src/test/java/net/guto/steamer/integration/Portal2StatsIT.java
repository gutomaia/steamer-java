package net.guto.steamer.integration;

import net.guto.steamer.Portal2StatsTest;
import net.guto.steamer.Stats;
import net.guto.steamer.StatsClient;
import net.guto.steamer.Steamer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class Portal2StatsIT extends Portal2StatsTest {

	public final int port = 9091;
	Server server;
	StatsServlet statsServlet;

	@Override
	protected Stats execute(StatsClient client) {
		return client.getStats("gutomaia", "portal2");
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
			Steamer.steamcommunity = "localhost:"+port;
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