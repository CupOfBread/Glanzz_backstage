package cn.cupbread.glanzz.DAO;

import cn.cupbread.glanzz.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByMail(String mail);
}
