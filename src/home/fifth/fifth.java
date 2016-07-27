package home.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class fifth {

    public static void readContent(String url) throws IOException {
        URL myURL = null;
        try {
            myURL = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(myURL.openStream()));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            throw new MalformedURLException();
        } catch (IOException e){
            throw new IOException();
        }

    }

    public static void main(String[] args) {
        String sURL;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
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

