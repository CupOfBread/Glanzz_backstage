package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.User;

public interface UserService {
    RetResponse check_user(String mail, String password);
    User get_user_byMail(String mail);
}
