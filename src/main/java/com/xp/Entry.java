package com.xp;

import com.xp.checker.*;
import com.xp.handler.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Entry {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];

        ReadFile(filePath, buildHandler());

        showWithGui(getLayout(buildChecker()));


    }

    public static void showWithGui(GuiLayout guiLayout) {
        if (guiLayout == null) {
            guiLayout = new DefaultChecker().check();
        }
        JFrame  f =new JFrame ();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        f.setLayout(null);
        {
            JPanel jPanel = new JPanel();
            JTextArea  show = new JTextArea ();
            show.setText(guiLayout.getAdvice());
            show.setLineWrap(true);
            show.setEditable(false);
            show.setColumns(100);
            show.setAlignmentX(0);
            jPanel.add(show);
            tp.add(jPanel);
            tp.setTitleAt(0,"诊断信息");
        }
        int count =1;
        List<com.xp.element.Frame> showList = guiLayout.getShowList();
        for (com.xp.element.Frame frame : showList) {
            JPanel jPanel = new JPanel();
            JTextArea  tmp = new JTextArea ();
            tmp.setLineWrap(true);
            tmp.setEditable(false);
            tmp.setColumns(100);
            tmp.setRows(50);
            tmp.setAlignmentX(0);
            tmp.setText(frame.toString());
            jPanel.add(tmp);
            tp.add(jPanel);
            tp.setTitleAt(count++,frame.getFrameInfo());
        }
        f.setContentPane(tp);
        f.pack();
        f.setVisible(true);



    }


    public static CommonHandler buildHandler() {
        ProblemFrameHandler problemFrameHandler = new ProblemFrameHandler();
        ThreadFrameHandler threadFrameHandler = new ThreadFrameHandler();
        SystemFrameHandler systemFrameHandler = new SystemFrameHandler();
        ProcessFrameHandler processFrameHandler = new ProcessFrameHandler();
        problemFrameHandler.setNext(threadFrameHandler);

        threadFrameHandler.setNext(processFrameHandler);
        processFrameHandler.setNext(systemFrameHandler);
        return problemFrameHandler;
    }

    public static List<CheckerInterface> buildChecker() {
        List<CheckerInterface> checkerLists = new ArrayList<>();
        checkerLists.add(new MemoryChecker());
        checkerLists.add(new CompileChecker());
        checkerLists.add(new JVMChecker());

        return checkerLists;
    }

    public static GuiLayout getLayout(List<CheckerInterface> checkerLists) {
        GuiLayout guiLayout = null;
        for (CheckerInterface checkerList : checkerLists) {
            guiLayout = checkerList.check();
            if (guiLayout != null) {
                return guiLayout;
            }
        }


        return guiLayout;
    }

    public static void ReadFile(String filePath, CommonHandler handler) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                handler.getMessage(line, reader);

            }
        }

    }


}
