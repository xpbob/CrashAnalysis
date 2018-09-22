package com.xp.handler;

import com.xp.element.ThreadFrame;
import com.xp.util.Common;
import com.xp.util.ReaderUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadFrameHandler extends CommonHandler {




    @Override
    protected String getMessageFromFile(String info, BufferedReader reader) {
        if (info.contains("T H R E A D")) {

            try {
                ThreadFrame.frame.setCurrrentTheadInfo(ReaderUtil.readFrameContainsWord("Current thread", reader));
                info = reader.readLine();
                do {
                    if(info.startsWith(Common.END_FLAG)) {
                        break;
                    }
                    if (info.startsWith("Stack")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(info);
                        sb.append(Common.NEXT_LINE);
                        sb.append(ReaderUtil.readFrameWithBlankCount(2,reader));
                        ThreadFrame.frame.setStack(sb.toString());

                    }

                } while ((info = reader.readLine()) != null);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return info;
    }
}
