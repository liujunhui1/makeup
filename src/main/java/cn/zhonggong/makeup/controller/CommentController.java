package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.Comment;
import cn.zhonggong.makeup.service.CommentService;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 军辉
 * 2019-07-22 9:30
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/addcomment")
    public ResultVO addCommit(Comment comment) {
        return commentService.addCommit(comment);
    }

    @DeleteMapping("/deletebyid")
    public ResultVO deleteCommitById(@RequestParam(value = "id", required = true) int id) {
        return commentService.deleteCommitById(id);
    }

    @GetMapping("/getall")
    public ResultVO findAll() {
        return commentService.findAll();
    }

    @GetMapping("/getbyid")
    public ResultVO findById(@RequestParam(value = "id", required = true) int id) {
        return commentService.findById(id);
    }


    @GetMapping("/getbyuserid")
    public ResultVO findByUserId(@RequestParam(value = "userId", required = true) int userId) {
        return commentService.findByUserId(userId);
    }

    @GetMapping("/getbygoodsid")
    public ResultVO findByGoodsId(@RequestParam(value = "goodsId", required = true) int goodsId) {
        return commentService.findByGoodsId(goodsId);
    }


    @GetMapping("/selectcomment")
    public ResultVO selectComment(@RequestParam(value = "cur", required = true, defaultValue = "1") int cur,
                                  @RequestParam(value = "size", required = true, defaultValue = "10") int size,
                                  @RequestParam(value = "search", required = true, defaultValue = "") String search) {
        return commentService.selectComment(cur - 1, size, search);
    }
}
