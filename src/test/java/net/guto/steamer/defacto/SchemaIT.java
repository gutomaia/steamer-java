package net.guto.steamer.defacto;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SchemaIT extends TestCase {

	public void testTF2Schema() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(new File("src/test/resources/schema/stats-tf2.schema.xml"));
			Schema schema = sf.newSchema(schemaFile);
			Validator validator = schema.newValidator();

			Document document = parser.parse(new File("src/test/resources/gutomaia-tf2.xml"));
			validator.validate(new DOMSource(document));
			document = parser.parse("http://steamcommunity.com/id/gutomaia/stats/tf2?xml=1");
			validator.validate(new DOMSource(document));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testPortal2Schema() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(new File("src/test/resources/schema/stats-portal2.schema.xml"));
			Schema schema = sf.newSchema(schemaFile);
			Validator validator = schema.newValidator();

			Document document = parser.parse(new File("src/test/resources/gutomaia-portal2.xml"));
			validator.validate(new DOMSource(document));
			document = parser.parse("http://steamcommunity.com/id/gutomaia/stats/portal2?xml=1");
			validator.validate(new DOMSource(document));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testL4D2Schema() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(new File("src/test/resources/schema/stats-l4d2.schema.xml"));
			Schema schema = sf.newSchema(schemaFile);
			Validator validator = schema.newValidator();

			Document document = parser.parse(new File("src/test/resources/gutomaia-l4d2.xml"));
			validator.validate(new DOMSource(document));
			document = parser.parse("http://steamcommunity.com/id/gutomaia/stats/l4d2?xml=1");
			validator.validate(new DOMSource(document));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
