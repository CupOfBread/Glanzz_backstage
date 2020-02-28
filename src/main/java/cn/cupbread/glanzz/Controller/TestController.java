package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.hutool.crypto.SecureUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */

@RestController
public class TestController {

    @PostMapping("/md5")
    public RetResponse md5(HttpServletRequest request){
        return new RetResponse().makeOKRsp(200, SecureUtil.md5(request.getParameter("md5")));
    }

    @GetMapping("/test")
    public RetResponse test(HttpServletRequest request){
        return new RetResponse().makeOKRsp(200, "200");
    }
}
