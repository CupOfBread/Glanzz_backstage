package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Service.ArticleService;
import cn.cupbread.glanzz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Date: 2020/3/23
 * @Author: CupOfBread
 * @Description:
 */

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @GetMapping("/articles")
    public RetResponse getArticles(HttpServletRequest request, HttpSession session) {
        String query = request.getParameter("query");
        System.out.println("query:" + query);
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        System.out.println(page.toString() + size.toString());
//        articleService.save_article(new Article().setTitle("123123123").setUser(userService.get_user_byMail("123@123.com")));
        if (query.equals("")) {
            return new RetResponse().makeOKRsp(200, "SUCCESS", articleService.get_article_page_all(page, size, Sort.Direction.DESC));
        } else {
            return new RetResponse().makeOKRsp(200, "SUCCESS", articleService.search_article_page_all(query, page, size, Sort.Direction.DESC));
        }
    }

    @GetMapping("/articles/{id}")
    public RetResponse getArticle(HttpServletRequest request, HttpSession session, @PathVariable Long id) {
        Article article=articleService.get_article_by_id(id);
        if (article!=null){
            return new RetResponse().makeOKRsp(200,article);
        }else {
            return new RetResponse().makeErrRsp(404,"NOT FOUND");
        }

    }

    @PostMapping("/articles/changePublish")
    public RetResponse changePublish(HttpServletRequest request) {
        Long articleId = Long.parseLong(request.getParameter("id"));
        Boolean publish = Boolean.parseBoolean(request.getParameter("publish"));
//        System.out.println(articleId.toString()+publish);
        Article article = articleService.change_article_publish_state(articleId);
        if (article.getPublish() == publish) {
            return new RetResponse().makeOKRsp(200);
        } else {
            return new RetResponse().makeErrRsp(500, "内部错误，状态更改失败");
        }
    }

    @PostMapping("/articles/del")
    public RetResponse delArticle(HttpServletRequest request){
        Long articleId = Long.parseLong(request.getParameter("id"));
        articleService.del_article(articleId);
        return new RetResponse().makeOKRsp(200);
    }
}
