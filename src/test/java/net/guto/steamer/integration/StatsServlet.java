package net.guto.steamer.integration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StatsServlet extends HttpServlet {

	private static final long serialVersionUID = 8309217551078307997L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		counter++;
		requestURI = req.getRequestURI();
		String xml = req.getParameter("xml");
		if (xml != null && Pattern.matches("^/id/([a-zA-Z0-9]+)/stats/([a-zA-Z0-9]+)$", requestURI)) {
			Pattern pattern = Pattern.compile("^/id/([a-zA-Z0-9]+)/stats/([a-zA-Z0-9]+)$");
			Matcher m = pattern.matcher(requestURI);
			m.find();
			username = m.group(1);
			game = m.group(2);
			InputStream in = new FileInputStream("src/test/resources/" + username.toLowerCase() + "-" + game.toLowerCase() + ".xml");
			OutputStream out = resp.getOutputStream();
			byte[] buf = new byte[1024];
			int count = 0;
			while ((count = in.read(buf)) >= 0) {
				out.write(buf, 0, count);
			}
			out.flush();
			in.close();
			out.close();
		} else {
			resp.setStatus(404);
		}
	}

	public int counter = 0;

	public String requestURI;
	public String username;
	public String game;
}
