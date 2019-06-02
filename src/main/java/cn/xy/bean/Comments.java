package cn.xy.bean;

import java.util.Date;

public class Comments {
    private int comment_id;
    private int user_id;
    private int goods_id;
    private String content;
    private int comment_time;
    private int star;
    private String comment_status;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getComment_time() {
        return comment_time;
    }

    public void setComment_time(int comment_time) {
        this.comment_time = comment_time;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment_status() {
        return comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }
}
