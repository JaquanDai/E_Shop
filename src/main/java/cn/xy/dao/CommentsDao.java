package cn.xy.dao;

import cn.xy.bean.Comments;

import java.util.List;

public interface CommentsDao {
    public List<Comments> getGoodsComments(int goodsId);
}
