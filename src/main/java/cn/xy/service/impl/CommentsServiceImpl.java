package cn.xy.service.impl;

import cn.xy.bean.Comments;
import cn.xy.bean.CommentsReply;
import cn.xy.bean.Reply;
import cn.xy.bean.ReplyUser;
import cn.xy.dao.CommentsDao;
import cn.xy.dao.ReplyDao;
import cn.xy.dao.UserDao;
import cn.xy.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDao commentsDao;
    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private UserDao userDao;
    public List<CommentsReply> getGoodsComments(int goodsId) {
        List<Comments> commentsList = commentsDao.getGoodsComments(goodsId);
        List<CommentsReply> commentsReplyList = new ArrayList<CommentsReply>();
        for(Comments comment:commentsList){
            List<Reply> replies = replyDao.getReplyByCommentId(comment.getComment_id());
            List<ReplyUser> replyList = new ArrayList<ReplyUser>();
            for(Reply reply:replies){
                String name = userDao.getUser(reply.getUser_id()).getUser_name();
                ReplyUser replyUser = new ReplyUser();
                replyUser.setReply(reply);
                replyUser.setUserName(name);
                replyList.add(replyUser);
            }
            String userName = userDao.getUser(comment.getUser_id()).getUser_name();
            CommentsReply commentsReply= new CommentsReply();
            commentsReply.setComments(comment);
            commentsReply.setReplyList(replyList);
            commentsReply.setUserName(userName);
            commentsReplyList.add(commentsReply);
        }
        return commentsReplyList;
    }

    public ReplyUser addReply(Reply reply) {
        ReplyUser replyUser = new ReplyUser();
        replyDao.addReply(reply);
        replyUser.setReply(reply);
        String name = userDao.getUser(reply.getUser_id()).getUser_name();
        replyUser.setUserName(name);
        return replyUser;
    }
}
