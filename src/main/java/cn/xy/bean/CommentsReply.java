package cn.xy.bean;

import java.util.List;

public class CommentsReply {
    private Comments comments;
    private List<ReplyUser> replyList;
    private String userName;

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public List<ReplyUser> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<ReplyUser> replyList) {
        this.replyList = replyList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
