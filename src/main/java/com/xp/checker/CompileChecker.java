package com.xp.checker;

import com.xp.GuiLayout;
import com.xp.element.*;
import com.xp.util.Common;

import java.util.ArrayList;
import java.util.List;

public class CompileChecker implements CheckerInterface {

    @Override
    public GuiLayout check() {
        String problemInfo = ProblemFrame.frame.getProblemInfo();
        if (problemInfo != null && (problemInfo.contains("0x00")||problemInfo.contains(" J "))) {
            return buildLayout();
        }
        return null;
    }

    public GuiLayout buildLayout(){

        StringBuilder sb =new StringBuilder();
        sb.append("这是一个解释器的问题，就是jvm把字节码转化成机器码出错了。");
        sb.append(Common.NEXT_LINE);
        sb.append("引起这种情况的原因有很多，一般都是jdk的bug");
        sb.append(Common.NEXT_LINE);
        sb.append("可以更换不同的jvm模式");
        sb.append(Common.NEXT_LINE);
        sb.append("例如-XInt,纯解释模式");
        sb.append(Common.NEXT_LINE);
        sb.append("在运行过程信息中有编译情况，可以查看具体编译到谁出错了");
        sb.append(Common.NEXT_LINE);
        sb.append("可以通过排除编译这些类来试试");
        sb.append(Common.NEXT_LINE);


        GuiLayout layout =new GuiLayout();
        layout.setAdvice(sb.toString());
        List<Frame> frameList=new ArrayList<>();
        frameList.add(ProblemFrame.frame);
        frameList.add(ThreadFrame.frame);
        frameList.add(ProcessFrame.frame);
        frameList.add(SystemFrame.frame);
        layout.setShowList(frameList);
        return layout;

    }


}
