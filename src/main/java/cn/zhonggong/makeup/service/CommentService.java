package cn.zhonggong.makeup.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import cn.zhonggong.makeup.domain.Comment;
import cn.zhonggong.makeup.vo.ResultVO;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 10:16
 */
public interface CommentService {

    ResultVO addCommit(Comment comment);

    ResultVO deleteCommitById(int id);

    ResultVO findAll();

    ResultVO findById(int id);

    ResultVO findByUserId(int userId);

    ResultVO findByGoodsId(int goodsId);

    ResultVO selectComment(int cur, int size, String search);


}
