package com.xp.checker;

import com.xp.GuiLayout;
import com.xp.element.*;
import com.xp.util.Common;

import java.util.ArrayList;
import java.util.List;

public class JVMChecker implements CheckerInterface {
    @Override
    public GuiLayout check() {

        String exceptionInfo = ProblemFrame.frame.getExceptionInfo();
        if (exceptionInfo != null) {
            return buildLayout();
        }

        return null;
    }

    public GuiLayout buildLayout() {
        StringBuilder sb =new StringBuilder();
        sb.append("这是jvm的错误导致的问题");
        sb.append(Common.NEXT_LINE);
        sb.append("请根据后面给的问题点来进行分析，需要根据openjdk的实现来帮助分析问题。");
        sb.append(Common.NEXT_LINE);
        sb.append("线程信息中的上下文也会告诉你代码执行到什么地方出的错");
        sb.append(Common.NEXT_LINE);
        sb.append("在运行过程信息栏目中查看内部错误信息。");
        sb.append(Common.NEXT_LINE);
        sb.append("这种错误有两个大方向可以排查");
        sb.append(Common.NEXT_LINE);
        sb.append(" 1,操作系统方面：是否是系统资源问题或者是参数问题导致");
        sb.append(Common.NEXT_LINE);
        sb.append(" 2,有第三方动态库的调用，导致错误");
        sb.append(Common.NEXT_LINE);
        sb.append("如果不是以上情况，有可能是jdk的bug，换个系统，或者换个jdk吧。");
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
