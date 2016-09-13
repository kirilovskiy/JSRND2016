package home.seventeenth.proxy.second;

import java.util.Set;

public class proxyServerApp {
	public static void main(String[] args){
		IContent content = new ProxyWebServer();		
		Set<String> listUrl = WebServer.initPages().keySet();

        for(int i = 1; i < 4; i++) {
            System.out.println("� request" + i);
            for(String url: listUrl) {
                System.out.println("[" + content.getSitePage(url) + "]");
            }
        }
	}

}
