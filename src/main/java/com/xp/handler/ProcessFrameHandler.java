package com.xp.handler;

import com.xp.element.ProcessFrame;
import com.xp.util.Common;
import com.xp.util.ReaderUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessFrameHandler extends CommonHandler {
    @Override
    protected String getMessageFromFile(String info, BufferedReader reader) {
        if (info.contains("P R O C E S S")) {

            try {
                while ((info = reader.readLine()) != null) {

                    if (info.startsWith("Compilation events")) {
                        ProcessFrame.frame.setCompilation(ReaderUtil.readFrameEndWithBlankLine(reader));
                        info = reader.readLine();
                    }
                    if (info.startsWith("Internal exceptions ")) {
                        ProcessFrame.frame.setExceptions(ReaderUtil.readFrameEndWithBlankLine(reader));
                        info = reader.readLine();
                    }

                    if (info.startsWith("Events")) {
                        ProcessFrame.frame.setEvents(ReaderUtil.readFrameEndWithBlankLine(reader));
                        info = reader.readLine();
                    }

                    if (info.startsWith(Common.END_FLAG)) {
                        break;
                    }


                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return info;
    }
}
