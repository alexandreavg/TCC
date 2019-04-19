package com.example.alexa.projetotcc.DAO;

import com.fasterxml.jackson.databind.JsonNode;

public class Message {
    public boolean isBelongsToCurrentUs;
    private String ID;
    private JsonNode data;
    private long timestamp;
    private String clientID;
    private Member member;

    public Message(String ID, JsonNode data, long timestamp, String clientID, Member member) {
        this.ID = ID;
        this.data = data;
        this.timestamp = timestamp;
        this.clientID = clientID;
        this.member = member;
    }

    public Message() {
    }

    public Message(String asText, MemberData data, boolean isBelongsToCurrentUs) {
    }

    public String getID() {
        return ID;
    }

    public JsonNode getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getClientID() {
        return clientID;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ID='" + ID + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                ", clientID='" + clientID + '\'' +
                ", member=" + member +
                '}';
    }

    /*
    private String text; // message body
    private MemberData memberData; // data of the user that sent this message
    private boolean belongsToCurrentUser; // is this message sent by us?

    public Message(String text, MemberData memberData, boolean belongsToCurrentUser) {
        this.text = text;
        this.memberData = memberData;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public MemberData getMemberData() {
        return memberData;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }*/
}
