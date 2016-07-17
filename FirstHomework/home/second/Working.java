package home.second;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Working {
	
static class methods{ 
	
	static void method_readAllLines(String filename)throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(filename), Charset.forName("Cp1251")); //StandardCharsets.UTF_8); - русские не считывались
		List<String> lines1 = new ArrayList<String>();
		for(String s : lines)
			lines1.add(s.replaceAll(" ", ""));
		//System.out.println(s);
		Collections.sort(lines1);
		for(String s : lines1)
			System.out.println(s);
	}
	
	static void method_FileInputStream(String filename)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "Cp1251"));
		List<String> lines = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line.replaceAll(" ", ""));
		}
        //Collections.sort(lines);
		Collections.sort(lines, new Comparator<String>() {
			public int compare(String s1, String s2){
				return (-1)*s1.toString().compareTo(s2.toString()); // сортируем в обратном порядке, сравнивая compareTo
			}
		});		
		
		for(String s : lines)
		 	System.out.println(s);
		
	}
	
	static void method_FileReader(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename)); // нельзя установить кодировку, поэтому русский текст корявый
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
           	lines.add(line.replaceAll(" ",""));
        }
        //Collections.sort(lines);
		Collections.sort(lines, new Comparator<String>() {
			public int compare(String s1, String s2){
				return s1.length()-s2.length(); // отсортируем, сравнивая длины строк
			}
		});		
		
		for(String s : lines)
		 	System.out.println(s);
    }
}	
	
	public static void main(String[] args)  {     
		try{
			methods.method_readAllLines("C:\\1.txt");
			System.out.println();
			methods.method_FileInputStream("C:\\1.txt");
			System.out.println();
			methods.method_FileReader("C:\\1.txt");
		} catch (IOException e) {
	        e.printStackTrace();
		}	
	}
}
