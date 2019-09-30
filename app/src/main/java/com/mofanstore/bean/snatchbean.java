package com.mofanstore.bean;

import java.io.Serializable;
import java.util.List;

public class snatchbean implements Serializable {
    private String id;
    private String user_id;
    private String driver_id;
    private String appointment_id;
    private String car_mold_id;
    private String additional_id;
    private String spell_order_id;
    private String car_charge_id;
    private String cost;
    private String astatus;
    private String time;
    private String start_time;
    private String complaint_statue;
    private String addition;
    private String out_trade_no;
    private String statue_code;
    private String driver_cost;
    private String type;
    private String pay_statue;
    private String statue;
    private String start;
    private String start_lng_lat;
    private String pass_lng_lat;
    private String num;
    private String end;
    private String end_lng_lat;
    private String car_mold;
    private String staname;
    private String luggageless_num;
    private String luggagegreater_num;
    private String pass;
    private String actual_pay;
    private String flight_number;
    private String distance;
    private start_locationbean start_location;
    private start_locationbean end_location;
    private List<passengerbean> passenger;
    private List<start_locationbean> pass_location;

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public List<start_locationbean> getPass_location() {
        return pass_location;
    }

    public void setPass_location(List<start_locationbean> pass_location) {
        this.pass_location = pass_location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAstatus() {
        return astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public start_locationbean getStart_location() {
        return start_location;
    }

    public void setStart_location(start_locationbean start_location) {
        this.start_location = start_location;
    }

    public start_locationbean getEnd_location() {
        return end_location;
    }

    public void setEnd_location(start_locationbean end_location) {
        this.end_location = end_location;
    }

    public String getStart_lng_lat() {
        return start_lng_lat;
    }

    public void setStart_lng_lat(String start_lng_lat) {
        this.start_lng_lat = start_lng_lat;
    }

    public String getPass_lng_lat() {
        return pass_lng_lat;
    }

    public void setPass_lng_lat(String pass_lng_lat) {
        this.pass_lng_lat = pass_lng_lat;
    }

    public String getDriver_cost() {
        return driver_cost;
    }

    public void setDriver_cost(String driver_cost) {
        this.driver_cost = driver_cost;
    }

    public String getStatue_code() {
        return statue_code;
    }

    public void setStatue_code(String statue_code) {
        this.statue_code = statue_code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getActual_pay() {
        return actual_pay;
    }

    public void setActual_pay(String actual_pay) {
        this.actual_pay = actual_pay;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getCar_mold_id() {
        return car_mold_id;
    }

    public void setCar_mold_id(String car_mold_id) {
        this.car_mold_id = car_mold_id;
    }

    public String getAdditional_id() {
        return additional_id;
    }

    public void setAdditional_id(String additional_id) {
        this.additional_id = additional_id;
    }

    public String getSpell_order_id() {
        return spell_order_id;
    }

    public void setSpell_order_id(String spell_order_id) {
        this.spell_order_id = spell_order_id;
    }

    public String getCar_charge_id() {
        return car_charge_id;
    }

    public void setCar_charge_id(String car_charge_id) {
        this.car_charge_id = car_charge_id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getComplaint_statue() {
        return complaint_statue;
    }

    public void setComplaint_statue(String complaint_statue) {
        this.complaint_statue = complaint_statue;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getPay_statue() {
        return pay_statue;
    }

    public void setPay_statue(String pay_statue) {
        this.pay_statue = pay_statue;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd_lng_lat() {
        return end_lng_lat;
    }

    public void setEnd_lng_lat(String end_lng_lat) {
        this.end_lng_lat = end_lng_lat;
    }

    public String getCar_mold() {
        return car_mold;
    }

    public void setCar_mold(String car_mold) {
        this.car_mold = car_mold;
    }

    public String getStaname() {
        return staname;
    }

    public void setStaname(String staname) {
        this.staname = staname;
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

    public List<passengerbean> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<passengerbean> passenger) {
        this.passenger = passenger;
    }
}
