package cn.xy.bean;

public class UserAddress {

    private int ua_id;
    private int user_id;
    private String address;
    private String status;

    public int getUa_id() {
        return ua_id;
    }

    public void setUa_id(int ua_id) {
        this.ua_id = ua_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
