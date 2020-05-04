package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Comment;
import cn.cupbread.glanzz.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUser(User user);
    Page<Comment> findByContentLike(String query, Pageable pageable);

}
