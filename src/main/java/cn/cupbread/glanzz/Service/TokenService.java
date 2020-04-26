package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Entity.Token;
import cn.cupbread.glanzz.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface TokenService {

    Token create_token(String mail);
    Token check_token(String token);
}
