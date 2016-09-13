package home.seventeenth.proxy.second;

import java.util.HashMap;

public class ProxyWebServer implements IContent {
	private WebServer server;
	private HashMap<String, String> cache;
	
	public ProxyWebServer() {
		cache = new HashMap<String, String>();
	} 
	
	@Override
	public String getSitePage(String url) {
		if (server == null)
			server = new WebServer();
		if (isDinamicPage(url)){
			return server.getSitePage(url);
		}
		if (!cache.containsKey(url)){
			cache.put(url, server.getSitePage(url));
		}
		System.out.print("+ Proxy: ");
		return cache.get(url);
	}

	@Override
	public boolean isDinamicPage(String url) {
		return server.isDinamicPage(url);
	}

}
