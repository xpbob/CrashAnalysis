package com.xp.handler;

import java.io.BufferedReader;

public abstract class CommonHandler {

    private CommonHandler next;


    public void getMessage(String info, BufferedReader reader){

        info = getMessageFromFile(info,reader);
        if(next!=null){
            next.getMessage(info, reader);
        }
    }
    protected abstract String getMessageFromFile(String info, BufferedReader reader);

    public CommonHandler getNext() {
        return next;
    }

    public void setNext(CommonHandler next) {
        this.next = next;
    }
}
