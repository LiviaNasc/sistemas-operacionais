package com.example.atividade01;

public class SystemCall {
    public static final String RECEIVE_DATA = "RECEIVE_DATA";

    private String type;
    private String data;

    public SystemCall(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
