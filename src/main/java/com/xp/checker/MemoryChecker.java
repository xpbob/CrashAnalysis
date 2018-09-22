package com.xp.checker;

import com.xp.GuiLayout;
import com.xp.element.Frame;
import com.xp.element.ProblemFrame;
import com.xp.element.SystemFrame;
import com.xp.element.ThreadFrame;
import com.xp.util.Common;

import java.util.ArrayList;
import java.util.List;

public class MemoryChecker implements CheckerInterface {
    @Override
    public GuiLayout check() {
        String problemInfo = ProblemFrame.frame.getProblemInfo();
        if(problemInfo.contains("Native memory allocation")){
            return buildLayout();
        }
        return null;
    }

    public GuiLayout buildLayout(){
        StringBuilder sb=new StringBuilder();
        sb.append("这是一个内存申请问题。");
        sb.append(Common.NEXT_LINE);
        sb.append("jvm默认提供一些解决方案");
        sb.append(Common.NEXT_LINE);
        sb.append("  Reduce memory load on the system");
        sb.append(Common.NEXT_LINE);
        sb.append("  Increase physical memory or swap space");
        sb.append(Common.NEXT_LINE);
        sb.append("  Check if swap backing store is full");
        sb.append(Common.NEXT_LINE);
        sb.append("  Use 64 bit Java on a 64 bit OS");
        sb.append(Common.NEXT_LINE);
        sb.append("  Decrease Java heap size (-Xmx/-Xms)");
        sb.append(Common.NEXT_LINE);
        sb.append("  Decrease number of Java threads");
        sb.append(Common.NEXT_LINE);
        sb.append("  Decrease Java thread stack sizes (-Xss)");
        sb.append(Common.NEXT_LINE);
        sb.append("  Set larger code cache with -XX:ReservedCodeCacheSize=");
        sb.append(Common.NEXT_LINE);
        sb.append("可以根据这些手段进行排查，下面的模版会提供系统内存使用的情况，可以做参考。");
        sb.append(Common.NEXT_LINE);
        sb.append("如果发现物理内存充足，swap也充足，那可能是系统的参数限制了内存申请。");
        sb.append(Common.NEXT_LINE);
        sb.append("例如/proc/sys/vm/max_map_count");
        sb.append(Common.NEXT_LINE);
        sb.append("如果想查具体原因，需要根据jvm源码和下面的堆栈进行分析");
        GuiLayout layout=new GuiLayout();
        layout.setAdvice(sb.toString());
        List<Frame> frames=new ArrayList<>();
        frames.add(ProblemFrame.frame);
        frames.add(SystemFrame.frame);
        frames.add(ThreadFrame.frame);
        layout.setShowList(frames);
        return layout;
    }


}
