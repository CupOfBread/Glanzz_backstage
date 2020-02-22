package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */

@RestController
public class TestController {

    @PostMapping("/test")
    public RetResponse test(){
        return new RetResponse().makeOKRsp(200);
    }
}
