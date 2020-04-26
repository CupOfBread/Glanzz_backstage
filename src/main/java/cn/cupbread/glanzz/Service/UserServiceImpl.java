package cn.cupbread.glanzz.Service;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.DAO.UserRepository;
import cn.cupbread.glanzz.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Date: 2020/2/23
 * @Author: CupOfBread
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public RetResponse check_user(String mail, String password) {
        User user=userRepository.findByMail(mail);
        if (user==null) return new RetResponse().makeErrRsp(404,"用户不存在");
        if (!user.getState().equals("正常")) return new RetResponse().makeErrRsp(403,user.getState());
        if (!user.getPassword().equals(password)) return new RetResponse().makeErrRsp(422,"用户不存在");
        return new RetResponse().makeOKRsp(200,user);
    }

    @Transactional
    @Override
    public User get_user_byMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Transactional
    @Override
    public User add_user(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> get_user_list() {
        List<User> users=userRepository.findAll();
        for (User user:users) {
            user.setPassword(null);
        }
        return users;
    }

    @Override
    public void del_user(Long id) {
        userRepository.deleteById(id);
    }
}
