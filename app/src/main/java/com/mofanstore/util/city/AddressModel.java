package com.mofanstore.util.city;

/**
 * Created by XY on 2016/5/17.
 */
public class AddressModel {
    private String province;  //产品ID
    private String city;//产品缩略图
    private String district;//产品名称

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
