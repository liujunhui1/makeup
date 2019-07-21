package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.Comment;
import cn.zhonggong.makeup.vo.ResultVO;

/**
 * 军辉
 * 2019-07-13 10:16
 */
public interface CommentService {

    ResultVO addCommit(Comment comment);

    ResultVO deleteCommitById(int id);
}
