package cn.xy.bean;

import java.util.List;

public class OperatorComments {
    private Comments comments;
    private List<Reply> replyList;
    private String userName;
    private String GoodsNmae;

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public String getGoodsNmae() {
        return GoodsNmae;
    }

    public void setGoodsNmae(String goodsNmae) {
        GoodsNmae = goodsNmae;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
