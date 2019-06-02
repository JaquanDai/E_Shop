package cn.xy.service;

import cn.xy.bean.Comments;
import cn.xy.bean.CommentsReply;
import cn.xy.bean.Reply;
import cn.xy.bean.ReplyUser;

import java.util.List;
import java.util.Map;

public interface CommentsService {
    public List<CommentsReply> getGoodsComments(int goodsId);
    public ReplyUser addReply(Reply reply);
}
