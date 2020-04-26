package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Service.UserService;
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

    @GetMapping("/user")
    public RetResponse getUserAll(HttpServletRequest request){
        return new RetResponse().makeOKRsp(200,userService.get_user_list());
    }

    @PostMapping("/user/del")
    public RetResponse delUser(HttpServletRequest request){
        Long userId = Long.parseLong(request.getParameter("id"));
        userService.del_user(userId);
        return new RetResponse().makeOKRsp(200);
    }
}
