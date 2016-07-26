package com.sbt.lesson5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SomeExceptionText {
    public static void main(String[] args) {
        try{
            //Integer.parseInt("i'm not number!");

            if (false) {
                new URL("this is not url");
            }
            if (false) {
                new URL("www.google.com").getContent();
            }

            int a = 1/0;
        } catch(NumberFormatException e){
            System.out.println(e.toString());
        } catch(MalformedURLException e){
            System.out.println(e.toString());
        } catch(IOException | ArithmeticException e){
            System.out.println(e.toString());
        }
    }
}
