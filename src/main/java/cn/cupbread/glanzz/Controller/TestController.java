package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Entity.Comment;
import cn.cupbread.glanzz.Entity.User;
import cn.cupbread.glanzz.Service.ArticleService;
import cn.cupbread.glanzz.Service.ClassificationService;
import cn.cupbread.glanzz.Service.CommentService;
import cn.cupbread.glanzz.Service.UserService;
import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */

@RestController
public class TestController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/md5")
    public RetResponse md5(HttpServletRequest request){
        return new RetResponse().makeOKRsp(200, SecureUtil.md5(request.getParameter("md5")));
    }

    @GetMapping("/test")
    public RetResponse test(HttpServletRequest request){
//        classificationService.save_classifi(new Classification().setName("哈哈").setEname("hh"));
//        articleService.save_article(new Article().setClassification(classificationService.get_classifi_by_id((long)4)).setUser(userService.get_user_byMail("123@123.com")));

//        Comment comment=new Comment();
//        comment.setUser(userService.get_user_byMail("123@123.com"));
//        comment.setArticle(articleService.get_article_by_id((long)10));
//        commentService.save_comment(comment);
        return new RetResponse().makeOKRsp(200, "200",commentService.get_comment_page(0,10, Sort.Direction.DESC));
    }
}
