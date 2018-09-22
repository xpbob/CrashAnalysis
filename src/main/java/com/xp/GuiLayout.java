package com.xp;

import com.xp.element.Frame;

import java.util.List;

public class GuiLayout {
    private String advice;
    private List<Frame> showList;

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public List<Frame> getShowList() {
        return showList;
    }

    public void setShowList(List<Frame> showList) {
        this.showList = showList;
    }
}
