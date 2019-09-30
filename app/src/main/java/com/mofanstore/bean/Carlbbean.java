package com.mofanstore.bean;

import java.io.Serializable;
import java.util.List;

public class Carlbbean implements Serializable{
    private List<Caritenbean> data;

    public List<Caritenbean> getData() {
        return data;
    }

    public void setData(List<Caritenbean> data) {
        this.data = data;
    }
}
