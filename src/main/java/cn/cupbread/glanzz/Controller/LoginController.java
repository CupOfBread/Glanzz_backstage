package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Token;
import cn.cupbread.glanzz.Entity.User;
import cn.cupbread.glanzz.Service.TokenService;
import cn.cupbread.glanzz.Service.UserService;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */
@RestController
public class LoginController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RetResponse login(HttpServletRequest request, HttpServletResponse response){
        String mail=request.getParameter("mail");
        String password=request.getParameter("password");
        RetResponse userRes=userService.check_user(mail,password);

        if (userRes.getCode()!=200) return userRes;
        User user=(User)userRes.getData();
        Token token=tokenService.create_token(user.getMail());

        JSONObject res=JSONUtil.createObj();
        res.put("username",user.getUserName());
        res.put("mail",user.getMail());
        res.put("gravatar",user.getGravatar());
        res.put("token",token.getToken());
        res.put("expTime",token.getExpTime());

        return new RetResponse().makeOKRsp(200,res);

    }
}
