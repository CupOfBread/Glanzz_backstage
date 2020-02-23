package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
