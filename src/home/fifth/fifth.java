package home.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class fifth {

    public static void readContent(String url) throws IOException {
        URL myURL = new URL(url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(myURL.openStream()))) // for autocloseable
            {
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        String sURL;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // for autocloseable
            while (true) {
                try {
                    System.out.println("Please input the URL that text do you want see(or word exit to quit program):");
                    sURL = reader.readLine();
                    if (sURL.equals("exit"))
                        break;
                    readContent(sURL);
                } catch (MalformedURLException e) {
                    System.out.println("Invalid format URL ");
                } catch (IOException e1) {
                    System.out.println("Error with reading rows ");
                }
            }
        } catch (IOException e) {
            System.out.println("Don't create reader");
        }
    }
 }

