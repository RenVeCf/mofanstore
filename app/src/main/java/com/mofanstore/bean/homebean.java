package com.mofanstore.bean;

import java.util.List;

public class homebean {
    private List<bannerbean> banner;
    private List<noticebean> notice;
    private List<orderlistbean> orderlist;

    public List<bannerbean> getBanner() {
        return banner;
    }

    public void setBanner(List<bannerbean> banner) {
        this.banner = banner;
    }

    public List<noticebean> getNotice() {
        return notice;
    }

    public void setNotice(List<noticebean> notice) {
        this.notice = notice;
    }

    public List<orderlistbean> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<orderlistbean> orderlist) {
        this.orderlist = orderlist;
    }
}
