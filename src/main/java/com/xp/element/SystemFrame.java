package com.xp.element;

import com.xp.util.Common;

public class SystemFrame implements Frame {
    public static SystemFrame frame = new SystemFrame();

    private String memory;

    private SystemFrame() {

    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (memory != null) {
            sb.append("机器内存信息：");
            sb.append(Common.NEXT_LINE);
            sb.append(memory);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        return sb.toString();
    }

    @Override
    public String getFrameInfo() {
        return "系统信息";
    }
}
