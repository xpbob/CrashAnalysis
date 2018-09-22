package com.xp.element;

import com.xp.util.Common;

public class ProblemFrame implements Frame{
    public static ProblemFrame frame = new ProblemFrame();
    private String problemInfo;


    private String exceptionInfo;

    private ProblemFrame() {
    }

    public void setProblemInfo(String problemInfo) {
        this.problemInfo = problemInfo;
    }

    public String getProblemInfo() {
        return problemInfo;
    }


    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if(problemInfo!=null){
            sb.append("问题模块：");
            sb.append(Common.NEXT_LINE);
            sb.append(problemInfo);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);
        }
        if(exceptionInfo!=null){
            sb.append("异常模块：");
            sb.append(Common.NEXT_LINE);
            sb.append(exceptionInfo);
            sb.append(Common.NEXT_LINE);
            sb.append(Common.LINE);
            sb.append(Common.NEXT_LINE);

        }


        return sb.toString();
    }

    @Override
    public String getFrameInfo() {
        return "可能的问题点";
    }
}
