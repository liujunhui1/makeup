package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 9:22
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {

    @Override
    List<Comment> findAll();

    Comment findById(int id);

    List<Comment> findByUserId(int userId);

    List<Comment> findByGoodsId(int goodsId);
}
