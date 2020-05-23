package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.User;
import cn.cupbread.glanzz.Service.TokenService;
import cn.cupbread.glanzz.Service.UserService;
import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/4/20 18:16
 * @Description ：
 * @Version: :
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/user")
    public RetResponse getUserAll(HttpServletRequest request) {
        return new RetResponse().makeOKRsp(200, userService.get_user_list());
    }

    @PostMapping("/user/del")
    public RetResponse delUser(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getParameter("id"));
        userService.del_user(userId);
        return new RetResponse().makeOKRsp(200);
    }

    @GetMapping("/user/info")
    public RetResponse getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        User user = userService.get_user_byMail(tokenService.check_token(token).getMail());
        return new RetResponse().makeOKRsp(200, user.setPassword(""));
    }

    @PostMapping("/user/info")
    public RetResponse updateUserInfo(HttpServletRequest request){
        User user=new User();
        String id=request.getParameter("id");
        if (id!=null) user=userService.get_user_byId(Long.parseLong(id));

        String userName=request.getParameter("userName");
        String mail=request.getParameter("mail");
        String gravatar=request.getParameter("gravatar");
        String description=request.getParameter("description");
        String state=request.getParameter("state");
        String createTime=request.getParameter("createTime");
        String userGroup=request.getParameter("userGroup");
        String wx=request.getParameter("wx");
        String qq=request.getParameter("qq");

        String password=request.getParameter("password");
        if (password!=null){
            System.out.println(password);
            password= SecureUtil.md5(password);
            user.setPassword(password);
        }
        user.setUserName(userName).setMail(mail).setGravatar(gravatar).setDescription(description)
                .setState(state).setCreateTime(createTime).setUserGroup(userGroup).setWx(wx).setQq(qq);
        return new RetResponse().makeOKRsp(200,userService.add_user(user));


    }
}
