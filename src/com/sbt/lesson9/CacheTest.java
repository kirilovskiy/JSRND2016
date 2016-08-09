package com.sbt.lesson9;

import java.io.*;

class DataHolder implements Serializable{
    String value = "AAAAAAAAAA";
}

public class CacheTest {
    public static void main(String[] args) throws IOException {
        String fileName = "links.bin";
        DataHolder dataHolder = new DataHolder();

        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(fileName))) {
            fout.writeObject(dataHolder);
            dataHolder.value="BBBBBBBBBB";
            fout.reset();
            fout.writeUnshared(dataHolder);//fout.writeObject(dataHolder);
            dataHolder.value="CCCCCCCCCC";
            fout.reset();
            fout.writeUnshared(dataHolder);//fout.writeObject(dataHolder);
        }

        DataHolder dataHolder1;
        DataHolder dataHolder2;
        DataHolder dataHolder3;

        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(fileName))) {
            dataHolder1 = (DataHolder) fin.readObject();
            dataHolder2 = (DataHolder) fin.readObject();
            dataHolder3 = (DataHolder) fin.readObject();

            System.out.println(dataHolder1 == dataHolder2);
            System.out.println(dataHolder1 == dataHolder3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
