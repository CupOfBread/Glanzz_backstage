package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Entity.User;
import cn.cupbread.glanzz.Service.ArticleService;
import cn.cupbread.glanzz.Service.ClassificationService;
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

    @PostMapping("/md5")
    public RetResponse md5(HttpServletRequest request){
        return new RetResponse().makeOKRsp(200, SecureUtil.md5(request.getParameter("md5")));
    }

    @GetMapping("/test")
    public RetResponse test(HttpServletRequest request){
//        classificationService.save_classifi(new Classification().setName("哈哈").setEname("hh"));
        articleService.save_article(new Article().setClassification(classificationService.get_classifi_by_id((long)4)).setUser(userService.get_user_byMail("123@123.com")));
        return new RetResponse().makeOKRsp(200, "200",articleService.get_article_page_all(0,10, Sort.Direction.DESC));
    }
}
