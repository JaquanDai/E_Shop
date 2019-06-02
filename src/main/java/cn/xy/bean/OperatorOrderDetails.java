package cn.xy.bean;

import java.util.Date;

public class OperatorOrderDetails {

    private int od_id;
    private String user_name;
    private int quantity;
    private float details_price;
    private String order_address;
    private int order_time;
    private String goods_name;
    private String details_status;
    private String user_phone;


    public int getOd_id() {
        return od_id;
    }

    public void setOd_id(int od_id) {
        this.od_id = od_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDetails_price() {
        return details_price;
    }

    public void setDetails_price(float details_price) {
        this.details_price = details_price;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public int getOrder_time() {
        return order_time;
    }

    public void setOrder_time(int order_time) {
        this.order_time = order_time;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getDetails_status() {
        return details_status;
    }

    public void setDetails_status(String details_status) {
        this.details_status = details_status;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
