package com.my.line_bot_dynamo.models;

public class Meta{
    private String name;
    private String content;

    public Meta() {
    }

    public Meta(String name, String content) {
        this.name = name;
        this.content = content;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}