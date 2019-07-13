package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 军辉
 * 2019-07-13 9:22
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
