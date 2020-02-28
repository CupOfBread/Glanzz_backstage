package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/2/27
 * @Author: CupOfBread
 * @Description:
 */
@RestController
@RequestMapping("/code")
public class StatusCodeController {

    //未授权
    @RequestMapping("/401")
    public RetResponse code_401(){
        return new RetResponse().makeErrRsp(401,"UNAUTHORIZED");
    }

    //拒绝访问
    @RequestMapping("/403")
    public RetResponse code_403(){
        return new RetResponse().makeErrRsp(403,"NOT FOUND");
    }

    //请求的资源不存在
    @RequestMapping("/404")
    public RetResponse code_404(){
        return new RetResponse().makeErrRsp(404,"NOT FOUND");
    }

    //token 过期
    @RequestMapping("/901")
    public RetResponse code_901(){
        return new RetResponse().makeErrRsp(901,"TOKEN EXPIRED");
    }

}
