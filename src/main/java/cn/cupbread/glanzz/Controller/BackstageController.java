package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.DAO.ArticleRepository;
import cn.cupbread.glanzz.DAO.ClassificationRepository;
import cn.cupbread.glanzz.DAO.CommentRepository;
import cn.cupbread.glanzz.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/5/25 10:38
 * @Description ：
 * @Version: :
 */

@RestController
public class BackstageController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassificationRepository classificationRepository;

    @GetMapping("/server/stati")
    public RetResponse get_statistic(){
        HashMap<String,Long> statistic=new HashMap<>();
        statistic.put("article",articleRepository.count());
        statistic.put("comment",commentRepository.count());
        statistic.put("user",userRepository.count());
        return new RetResponse().makeOKRsp(200,statistic);
    }
}
