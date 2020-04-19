package cn.cupbread.glanzz.Interceptor;

import cn.cupbread.glanzz.Entity.Token;
import cn.cupbread.glanzz.Service.TokenService;
import cn.cupbread.glanzz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: 2020/2/26
 * @Author: CupOfBread
 * @Description:
 */
@Component
public class BackstageInterceptor implements HandlerInterceptor {


    private static TokenService tokenService;
    private static UserService userService;

    @Autowired
    public void setService(TokenService tokenService,UserService userService){
        BackstageInterceptor.tokenService=tokenService;
        BackstageInterceptor.userService=userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String token=request.getHeader("Authorization");
        String path=request.getServletPath();


        // token校验
        if (token==null) {
            response.sendRedirect("/code/901");
            return false;
        }
        Token token1=tokenService.check_token(token);
        if (token1==null){
            response.sendRedirect("/code/901");
            return false;
        }
//
//        // 权限校验
//        request.setAttribute("user",userService.get_user_byMail(token1.getMail()));
        return true;
    }
}
