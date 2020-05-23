package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.User;

import java.util.List;

public interface UserService {
    RetResponse check_user(String mail, String password);
    User get_user_byMail(String mail);
    User get_user_byId(Long id);
    User add_user(User user);
    List<User> get_user_list();
    void del_user(Long id);
}
