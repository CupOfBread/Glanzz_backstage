package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Comment;
import cn.cupbread.glanzz.Entity.User;
import cn.cupbread.glanzz.Service.ArticleService;
import cn.cupbread.glanzz.Service.CommentService;
import cn.cupbread.glanzz.Service.TokenService;
import cn.cupbread.glanzz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/4/26 16:29
 * @Description ：
 * @Version: :
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/comments")
    public RetResponse getComments(HttpServletRequest request){
        String query = request.getParameter("query");
        System.out.println("query:" + query);
        int page = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("size"));
        System.out.println("PageInfo:"+page + size);

        if (query.equals("")) {
            return new RetResponse().makeOKRsp(200, "SUCCESS", commentService.get_comment_page(page, size, Sort.Direction.DESC));
        } else {
            return new RetResponse().makeOKRsp(200, "SUCCESS", commentService.get_comment_page(query, page, size, Sort.Direction.DESC));
        }
    }

    @GetMapping("/comments/user")
    public RetResponse getCommentByUser(HttpServletRequest request){
        String mail=request.getParameter("mail");
        return new RetResponse().makeOKRsp(200,commentService.get_comment_list_by_user(mail));
    }

    @GetMapping("/comments/article")
    public RetResponse getCommentByArticle(HttpServletRequest request){
        String articleId=request.getParameter("id");
        return new RetResponse().makeOKRsp(200,articleService.get_article_by_id(Long.parseLong(articleId)).getComments());
    }

    @PostMapping("/comments")
    public RetResponse addComment(HttpServletRequest request){
        String id=request.getParameter("id");
        String articleId=request.getParameter("articleId");
        User user=null;
        String content=request.getParameter("conent");
        String createTime=request.getParameter("createTime");
        Boolean publish=Boolean.parseBoolean(request.getParameter("publish"));
        Comment comment=new Comment();
        if (id!=null){
            comment=commentService.get_comment_by_id(Long.parseLong(id));
        }else {
            user=userService.get_user_byMail(tokenService.check_token(request.getHeader("Authorization")).getMail());
        }
        comment.setContent(content).setCreateTime(createTime).setUser(user).setPublish(publish)
                .setArticle(articleService.get_article_by_id(Long.parseLong(articleId)));
        return new RetResponse().makeOKRsp(200,commentService.save_comment(comment));
    }

    @PostMapping("/comments/del")
    public RetResponse delComment(HttpServletRequest request){
        Long id=Long.parseLong(request.getParameter("id"));
        commentService.del_comment(id);
        return new RetResponse().makeOKRsp(200);
    }
}
