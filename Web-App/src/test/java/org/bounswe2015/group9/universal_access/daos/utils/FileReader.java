package org.bounswe2015.group9.universal_access.daos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {
    public static String readFromFile(String path) throws IOException {
        String content = null;

        InputStream is = System.class.getResourceAsStream(path);
        if (is == null)
            throw new IOException("File not found!");

        InputStreamReader isr = new InputStreamReader(is);

        int i;
        char[] cList = new char[1000];
        StringBuilder sb = new StringBuilder();

        while ((i = isr.read(cList)) != -1) {
            sb.append(cList, 0, i);
        }

        content = sb.toString();

        return content;
    }
}

