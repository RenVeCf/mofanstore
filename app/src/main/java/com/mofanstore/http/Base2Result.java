package com.mofanstore.http;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XY on 2017/4/5.
 */
public class Base2Result<T> implements Serializable {


    public List<T> data;
    public String code;
    public String msg;
}
