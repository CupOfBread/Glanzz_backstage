package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ArticleService {
    Page<Article> get_article_page_all(int page, int size, Sort.Direction direction);
    Page<Article> search_article_page_all(String query,int page, int size, Sort.Direction direction);
    Article save_article(Article article);
    void del_article(Long id);
    Article get_article_by_id(Long id);
    List<Comment> get_article_comment(Long articleId);
    Article change_article_publish_state(Long id);
}
