package net.guto.steamer.mocked;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class XMLUtil {
	public static Document loadXml(String file)  {
		try {
			DOMParser parser = new DOMParser();
			parser.parse("src/test/resources/" + file);
			return parser.getDocument();
		} catch (Exception e) {
			return null;
		}
	}
}
