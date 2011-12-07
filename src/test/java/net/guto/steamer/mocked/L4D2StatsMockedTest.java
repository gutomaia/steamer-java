package net.guto.steamer.mocked;

import static net.guto.steamer.mocked.XMLUtil.loadXml;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.guto.steamer.L4D2StatsTest;
import net.guto.steamer.Stats;
import net.guto.steamer.StatsClient;
import net.guto.steamer.Steamer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StatsClient.class, Steamer.class, HttpClient.class, HttpGet.class, DocumentBuilderFactory.class, DocumentBuilder.class })
public class L4D2StatsMockedTest extends L4D2StatsTest {
	
	@Override
	protected Stats execute(StatsClient client){
		return client.getStats("gutomaia", "l4d2");
	}


	@Override
	public void setUp() throws Exception {
		HttpClient client = mock(HttpClient.class);
		Steamer.client = client;
		HttpGet request = mock(HttpGet.class);
		HttpResponse response = mock(HttpResponse.class);

		whenNew(HttpGet.class).withNoArguments().thenReturn(request);
		when(client.execute(request)).thenReturn(response);

		HttpEntity entity = mock(HttpEntity.class);
		when(response.getEntity()).thenReturn(entity);
		InputStream is = mock(InputStream.class);
		when(entity.getContent()).thenReturn(is);

		DocumentBuilderFactory factory = mock(DocumentBuilderFactory.class);
		DocumentBuilder builder = mock(DocumentBuilder.class);

		mockStatic(DocumentBuilderFactory.class);
		when(DocumentBuilderFactory.newInstance()).thenReturn(factory);
		when(factory.newDocumentBuilder()).thenReturn(builder);
		when(builder.parse(is)).thenReturn(loadXml("gutomaia-l4d2.xml"));
		super.setUp();
	}

	public void tearDown() throws Exception {
		Steamer.client = null;
		super.tearDown();
	}
}