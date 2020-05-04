package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.DAO.ArticleRepository;
import cn.cupbread.glanzz.Entity.Article;
import cn.cupbread.glanzz.Entity.Comment;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Date: 2020/3/10
 * @Author: CupOfBread
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Page<Article> get_article_page_all(int page, int size, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, direction, "id");
        return articleRepository.findAll(pageable);
    }

    @Override
    public Page<Article> search_article_page_all(String query, int page, int size, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, direction, "id");
        return articleRepository.findByTitleLike("%" + query + "%", pageable);
    }

    @Transactional
    @Override
    public Article save_article(Article article) {
        article.setUpdateTime(DateUtil.now());
        return articleRepository.save(article);
    }

    @Transactional
    @Override
    public void del_article(Long id) {
        articleRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Article get_article_by_id(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> get_article_comment(Long articleId) {
        Article article=articleRepository.findById(articleId).orElse(null);
        if (article!=null) return article.getComments();
        return null;
    }

    @Transactional
    @Override
    public Article change_article_publish_state(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article != null) {
            return articleRepository.save(article.setPublish(!article.getPublish()));
        } else return null;
    }
}
