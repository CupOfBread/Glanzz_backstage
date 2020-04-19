package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByTitleLike(String query, Pageable pageable);
}
