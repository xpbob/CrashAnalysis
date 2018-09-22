package com.xp.handler;

import com.xp.element.ProblemFrame;
import com.xp.util.Common;
import com.xp.util.ReaderUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class ProblemFrameHandler extends CommonHandler {
    private CommonHandler next;
    private static final String FLAG = "#";


    @Override
    protected String getMessageFromFile(String info, BufferedReader reader) {
        if (info.contains(FLAG)) {
            try {
                do {
                    if(info.startsWith(Common.END_FLAG)) {
                        break;
                    }
                    if(info.contains("Native memory allocation")){
                        StringBuilder sb= new StringBuilder(info);
                        sb.append(Common.NEXT_LINE);
                        sb.append(ReaderUtil.readFrameEndWithBlankLine(reader));
                        ProblemFrame.frame.setProblemInfo(sb.toString());
                    }
                    if(info.contains("An unexpected error")){

                        ProblemFrame.frame.setExceptionInfo(ReaderUtil.readFrameLineWithLength(4,reader));
                        info=reader.readLine();
                    }
                    if(info.contains("A fatal error")){
                        ProblemFrame.frame.setExceptionInfo(ReaderUtil.readFrameLineWithLength(4,reader));
                        info=reader.readLine();
                    }

                    if (info.contains("Problematic frame")) {
                        ProblemFrame.frame.setProblemInfo(ReaderUtil.readFrameWithEnd("#", reader));
                    }


                } while ((info = reader.readLine()) != null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return info;
    }
}
