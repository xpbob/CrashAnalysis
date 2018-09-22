package com.xp.element;

import com.xp.util.Common;

public class ProcessFrame implements Frame {
    public static ProcessFrame frame = new ProcessFrame();


    private String exceptions;

    private String compilation;

    private String events;

    private ProcessFrame() {
    }


    public String getExceptions() {
        return exceptions;
    }

    public void setExceptions(String exceptions) {
        this.exceptions = exceptions;
    }

    public String getCompilation() {
        return compilation;
    }

    public void setCompilation(String compilation) {
        this.compilation = compilation;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (exceptions != null) {
            sb.append("jvm异常信息：");
            sb.append(Common.NEXT_LINE);
            sb.append(exceptions);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        if (compilation != null) {
            sb.append("编译事件：");
            sb.append(Common.NEXT_LINE);
            sb.append(compilation);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        if (events != null) {
            sb.append("事件信息：");
            sb.append(Common.NEXT_LINE);
            sb.append(events);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        return sb.toString();
    }

    @Override
    public String getFrameInfo() {
        return "运行过程信息";
    }
}
