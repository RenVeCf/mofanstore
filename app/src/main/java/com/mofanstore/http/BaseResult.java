package com.mofanstore.http;

import java.io.Serializable;

/**
 * Created by XY on 2017/4/5.
 */
public class  BaseResult<T> implements Serializable {


    public T data;

    public String code;
    public String msg;


}
