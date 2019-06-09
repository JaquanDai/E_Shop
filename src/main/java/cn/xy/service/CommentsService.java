package cn.xy.service;

import cn.xy.bean.Comments;
import cn.xy.bean.CommentsReply;
import cn.xy.bean.Reply;

import java.util.List;
import java.util.Map;

public interface CommentsService {
    public List<CommentsReply> getGoodsComments(int goodsId);
    public Reply addReply(Reply reply);
    public CommentsReply addComments(Comments comments);
}
