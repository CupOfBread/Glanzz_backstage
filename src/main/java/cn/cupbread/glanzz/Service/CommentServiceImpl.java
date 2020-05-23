package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.DAO.CommentRepository;
import cn.cupbread.glanzz.DAO.UserRepository;
import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Entity.Comment;
import cn.cupbread.glanzz.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/4/26 17:13
 * @Description ：
 * @Version: :
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public Comment save_comment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void del_comment(Long id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Comment> get_comment_list_by_user(String mail) {
        User user=userRepository.findByMail(mail);
        if (user==null) return null;
        return commentRepository.findByUser(user);
    }

    @Transactional
    @Override
    public Comment get_comment_by_id(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Page<Comment> get_comment_page(String query,int page, int size, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, direction, "id");
        return commentRepository.findByContentLike(query,pageable);
    }

    @Override
    public Page<Comment> get_comment_page(int page, int size, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, direction, "id");
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment change_comment_publish_state(Long id) {
        Comment comment=commentRepository.findById(id).orElse(null);
        if (comment != null) {
            return commentRepository.save(comment.setPublish(!comment.getPublish()));
        } else return null;
    }
}
