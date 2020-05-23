package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CommentService {
    Comment save_comment(Comment comment);
    void del_comment(Long id);
    List<Comment> get_comment_list_by_user(String mail);
    Comment get_comment_by_id(Long id);
    Page<Comment> get_comment_page(String query,int page, int size, Sort.Direction direction);
    Page<Comment> get_comment_page(int page, int size, Sort.Direction direction);
    Comment change_comment_publish_state(Long id);
}
