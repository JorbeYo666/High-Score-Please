package com.example.myapplication.entity;

public class ChatMessage {
    private String content;
    private boolean isBot;

    public ChatMessage(String content, boolean isBot) {
        this.content = content;
        this.isBot = isBot;
    }

    public String getContent() {
        return content;
    }

    public boolean isBot() {
        return isBot;
    }
}
