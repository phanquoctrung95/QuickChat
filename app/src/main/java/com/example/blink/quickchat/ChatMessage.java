package com.example.blink.quickchat;

/**
 * Created by Blink on 2/25/2017.
 */

public class ChatMessage {
    private String name;
    private String text;

    public  ChatMessage(){
    }
    public ChatMessage(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

