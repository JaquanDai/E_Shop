package cn.xy.dao;

import cn.xy.bean.Reply;

import java.util.List;

public interface ReplyDao {
    public List<Reply> getReplyByCommentId(int commentId);
    public void addReply(Reply reply);
}
