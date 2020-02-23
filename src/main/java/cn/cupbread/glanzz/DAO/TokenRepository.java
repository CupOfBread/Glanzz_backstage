package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findByToken(String token);
    Token findByMail(String mail);
}
