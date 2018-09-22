package com.xp.checker;

import com.xp.GuiLayout;
import com.xp.element.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultChecker implements CheckerInterface {
    @Override
    public GuiLayout check() {
        return buildLayout();
    }
    public GuiLayout buildLayout(){
        GuiLayout layout =new GuiLayout();
        layout.setAdvice("程序没有判断出问题，请联系作者。");
        List<Frame> frameList=new ArrayList<>();
        frameList.add(ProblemFrame.frame);
        frameList.add(ThreadFrame.frame);
        frameList.add(ProcessFrame.frame);
        frameList.add(SystemFrame.frame);
        layout.setShowList(frameList);
        return layout;
    }
}
