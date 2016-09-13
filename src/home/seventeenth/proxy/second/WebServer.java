package home.seventeenth.proxy.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WebServer implements IContent {
	protected HashMap<String, String> pages;
	protected List<String> dinamicPages;
	
	public WebServer(){
		pages = initPages();
		dinamicPages = new ArrayList<String>();
		setDinamicPages();
	}
	
	public static HashMap<String, String> initPages(){
		HashMap<String, String> content = new HashMap<String, String>();
		content.put("purchase", "page with ordering registration");
		content.put("content", "page with main content");
		content.put("blog", "blog for our clients");
		content.put("customers", "our customers");
		content.put("news", "latest news content");
		content.put("garbage", "garbage content");
		return content;
	}
	
	private void setDinamicPages(){
		dinamicPages.add("customers");
		dinamicPages.add("garbage");
	}

	protected void printBanner(String textBanner){
		System.out.print(textBanner);
	}
	
	@Override
	public String getSitePage(String url) {
		printBanner("[content from server]");
		return pages.get(url);
	}

	@Override
	public boolean isDinamicPage(String url) {
		if (dinamicPages.contains(url)) return true;
		return false;
	}

}
