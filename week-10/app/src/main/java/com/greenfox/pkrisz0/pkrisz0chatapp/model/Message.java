package com.greenfox.pkrisz0.pkrisz0chatapp.model;

/**
 * Created by Sir Robin on 2017. 11. 16..
 */

public class Message {
    String username;
    String text;

    public Message() {
    }

    public Message(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
