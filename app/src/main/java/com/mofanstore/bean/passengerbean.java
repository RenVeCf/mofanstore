package com.mofanstore.bean;

import java.io.Serializable;

public class passengerbean implements Serializable {
    private String id;
    private String name;
    private String global_roaming;
    private String contacts_phone;
    private String contacts_name;
    private String contacts_wxcode;
    private String children_num;
    private String adult_num;
    private String luggageless_num;
    private String luggagegreater_num;
    private String ctime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGlobal_roaming() {
        return global_roaming;
    }

    public void setGlobal_roaming(String global_roaming) {
        this.global_roaming = global_roaming;
    }

    public String getContacts_phone() {
        return contacts_phone;
    }

    public void setContacts_phone(String contacts_phone) {
        this.contacts_phone = contacts_phone;
    }

    public String getContacts_name() {
        return contacts_name;
    }

    public void setContacts_name(String contacts_name) {
        this.contacts_name = contacts_name;
    }

    public String getContacts_wxcode() {
        return contacts_wxcode;
    }

    public void setContacts_wxcode(String contacts_wxcode) {
        this.contacts_wxcode = contacts_wxcode;
    }

    public String getChildren_num() {
        return children_num;
    }

    public void setChildren_num(String children_num) {
        this.children_num = children_num;
    }

    public String getAdult_num() {
        return adult_num;
    }

    public void setAdult_num(String adult_num) {
        this.adult_num = adult_num;
    }

    public String getLuggageless_num() {
        return luggageless_num;
    }

    public void setLuggageless_num(String luggageless_num) {
        this.luggageless_num = luggageless_num;
    }

    public String getLuggagegreater_num() {
        return luggagegreater_num;
    }

    public void setLuggagegreater_num(String luggagegreater_num) {
        this.luggagegreater_num = luggagegreater_num;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
