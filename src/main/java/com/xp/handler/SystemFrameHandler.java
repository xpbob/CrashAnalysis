package com.xp.handler;

import com.xp.element.SystemFrame;
import com.xp.util.ReaderUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class SystemFrameHandler extends CommonHandler {
    @Override
    protected String getMessageFromFile(String info, BufferedReader reader) {
        if (info.contains("S Y S T E M")) {

            try {
                SystemFrame.frame.setMemory(ReaderUtil.readFrameContainsWord("Memory", reader));
                info = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return info;


    }
}
