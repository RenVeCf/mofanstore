package com.mofanstore.bean;

import java.io.Serializable;
import java.util.List;

public class carlist2bean implements Serializable {
    private List<carlistbean> data;

    public List<carlistbean> getData() {
        return data;
    }

    public void setData(List<carlistbean> data) {
        this.data = data;
    }
}
