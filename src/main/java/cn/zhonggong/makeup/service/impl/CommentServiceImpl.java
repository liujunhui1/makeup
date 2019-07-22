package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Comment;
import cn.zhonggong.makeup.repository.CommentRepository;
import cn.zhonggong.makeup.service.CommentService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.util.SpecificationUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 军辉
 * 2019-07-21 16:36
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public ResultVO addCommit(Comment comment) {
        log.info("新增评论:" + comment);
        if (comment == null || "".equals(comment)) {
            return ResultVOUtil.Fail("评论为空");
        } else {
            commentRepository.save(comment);
            return ResultVOUtil.Success("添加评论成功", 1, comment);
        }
    }

    @Override
    public ResultVO deleteCommitById(int id) {
        if (id <= 0) {
            return ResultVOUtil.Fail("评论id有误");
        } else {
            Comment comment = commentRepository.findById(id);
            if (comment != null) {
                commentRepository.delete(comment);
                return ResultVOUtil.Success("删除评论成功");
            } else {
                return ResultVOUtil.Fail("评论为空，无需删除");
            }
        }
    }

    @Override
    public ResultVO findAll() {
        List<Comment> commentList = commentRepository.findAll();
        if (commentList.size() == 0) {
            return ResultVOUtil.Fail("评论量为空");
        }
        return ResultVOUtil.Success("评论查询成功", commentList.size(), commentList);

    }

    @Override
    public ResultVO findByUserId(int userId) {
        if (userId <= 0) {
            return ResultVOUtil.Fail("userId错误，请核对后再使用");
        } else {
            List<Comment> commentList = commentRepository.findByUserId(userId);
            if (commentList.size() == 0) {
                return ResultVOUtil.Fail("当前用户的评论量为0");
            } else {
                return ResultVOUtil.Success("查询成功", commentList.size(), commentList);
            }
        }
    }

    @Override
    public ResultVO findByGoodsId(int goodsId) {
        if (goodsId <= 0) {
            return ResultVOUtil.Fail("goodsId错误");
        } else {
            List<Comment> commentList = commentRepository.findByGoodsId(goodsId);
            if (commentList.size() == 0) {
                return ResultVOUtil.Fail("当前商品的评论量为0");
            } else {
                return ResultVOUtil.Success("查询成功", commentList.size(), commentList);
            }
        }
    }

    @Override
    public ResultVO findById(int id) {
        if (id <= 0) {
            return ResultVOUtil.Fail("评论id有误");
        } else {
            Comment comment = commentRepository.findById(id);
            if (comment == null) {
                return ResultVOUtil.Fail("评论为空");
            } else {
                return ResultVOUtil.Success("评论查询成功", 1, comment);
            }
        }

    }

    @Override
    public ResultVO selectComment(int cur, int size, String search) {
        Sort sort = null;
        Pageable pageable = null;
        Page<Comment> page = null;

        if ("".equals(search)) {
            //根据 id 倒序
            sort = new Sort(Sort.Direction.DESC, "id");
            pageable = PageRequest.of(cur, size, sort);
            page = commentRepository.findAll(pageable);
        } else {
            //只能填入int类型的属性
            String[] property = {"id", "goodsId"};
            Specification<Comment> specification = new SpecificationUtil<Comment>(search).getSpe(property, "userAccount");
            sort = new Sort(Sort.Direction.ASC, "goodsId");
            pageable = PageRequest.of(cur, size, sort);
            page = commentRepository.findAll(specification, pageable);
        }

        if (page.getTotalElements() == 0) {
            return ResultVOUtil.Fail("查询失败");
        }
        log.info("查询评论：" + page.getContent());


        return ResultVOUtil.Success("查询评论成功", page.getTotalElements(), page.getContent());
    }
}
