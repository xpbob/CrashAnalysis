package com.xp.util;

import java.io.BufferedReader;
import java.io.IOException;

public class ReaderUtil {

    public static String readFrameLineWithLength(int length, BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            if (line.trim().length() > length) {
                sb.append(line);
                while ((line = reader.readLine()) != null) {
                    if (line.trim().length() > length) {
                        sb.append(line);
                    }else {
                        break;
                    }
                }
                break;

            }

        }
        return sb.toString();

    }

    public static String readFrameContainsWord(String word, BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains(word)) {
                sb.append(line);
                sb.append(Common.NEXT_LINE);
                break;
            }
        }
        return sb.toString();

    }

    public static String readFrameEndWithBlankLine(BufferedReader reader) throws IOException {

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().equals("")) {
                break;
            }
            sb.append(line);
            sb.append(Common.NEXT_LINE);

        }
        return sb.toString();

    }





    public static String readFrameWithEnd(String end, BufferedReader reader) throws IOException {

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().equals(end)) {
                break;
            }
            sb.append(line);
            sb.append(Common.NEXT_LINE);

        }
        return sb.toString();

    }

    public static String readFrameWithBlankCount(int count, BufferedReader reader) throws IOException {

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().equals("")) {
                count--;
                if(count==0){
                    break;
                }
            }
            sb.append(line);
            sb.append(Common.NEXT_LINE);

        }
        return sb.toString();

    }
}
