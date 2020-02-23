package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
