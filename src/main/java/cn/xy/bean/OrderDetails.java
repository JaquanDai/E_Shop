package cn.xy.bean;

public class OrderDetails {

    private int od_id;
    private int order_id;
    private int goods_id;
    private int quantity;
    private float details_price;

    public int getOd_id() {
        return od_id;
    }

    public void setOd_id(int od_id) {
        this.od_id = od_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
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

    public String getDetails_status() {
        return details_status;
    }

    public void setDetails_status(String details_status) {
        this.details_status = details_status;
    }

    private String details_status;

}
