package net.guto.steamer;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathExpression;

public interface Field {
	XPathExpression getXPath();
	String getXPathString();
	QName getDataType();
}
