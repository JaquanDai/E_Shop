package cn.xy.controller;

import cn.xy.bean.Comments;
import cn.xy.bean.CommentsReply;
import cn.xy.bean.Reply;
import cn.xy.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/comments/{goodsId}")
    @ResponseBody
    public List<CommentsReply> getGoodsComments(@PathVariable("goodsId") int goodsId){
        return commentsService.getGoodsComments(goodsId);
    }

    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    @ResponseBody
    public Reply addReply(@RequestBody(required=true) Reply reply){

        return commentsService.addReply(reply);
    }

    @RequestMapping(value = "/addComments",method = RequestMethod.POST)
    @ResponseBody
    public CommentsReply addComments(@RequestBody(required=true) Comments comments){
        return commentsService.addComments(comments);
    }
}
