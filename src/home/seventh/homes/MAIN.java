package home.seventh.homes;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import home.seventh.iPlugin.Plugin;

public class MAIN {
	
	public static class PluginManager{
		private final String pluginRootDirectory;

		public PluginManager(String pluginRootDirectory){
			this.pluginRootDirectory = pluginRootDirectory;
		}

		public Plugin load(String pluginName, String pluginClassName) throws Exception{
			File jar = new File(pluginRootDirectory+pluginName+".jar");
			URL jarURL = jar.toURI().toURL();
			URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
			Class<?> pluginClass = classLoader.loadClass(pluginClassName);
			classLoader.close();
			return (Plugin) pluginClass.newInstance();
		}
	}
	
	public static void main(String[] args){
		PluginManager manager = new PluginManager("C:\\Users\\IdeaProjects\\JSRND2016\\src\\home\\seventh\\plugins\\");
		try {
			manager.load("plugin1","plugs.HelloPlugin").doUsefull();
			manager.load("plugin2","plugs.HelloPlugin").doUsefull();
		} catch (Exception e) {
			System.out.println("Ошибка при загрузке : " + e.toString());
		}
	}
}
