package com.xp.element;

import com.xp.util.Common;

public class ThreadFrame implements Frame {
    public static ThreadFrame frame = new ThreadFrame();

    private String currrentTheadInfo;
    private String stack;

    private ThreadFrame() {
    }

    public String getCurrrentTheadInfo() {
        return currrentTheadInfo;
    }

    public void setCurrrentTheadInfo(String currrentTheadInfo) {
        this.currrentTheadInfo = currrentTheadInfo;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (currrentTheadInfo != null) {
            sb.append("正在执行的线程信息：");
            sb.append(Common.NEXT_LINE);
            sb.append(currrentTheadInfo);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        if (stack != null) {
            sb.append("对应的堆栈信息：");
            sb.append(Common.NEXT_LINE);
            sb.append(stack);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        return sb.toString();
    }

    @Override
    public String getFrameInfo() {
        return "线程信息";
    }
}
