package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Nav;
import cn.cupbread.glanzz.Service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/5/25 9:11
 * @Description ：
 * @Version: :
 */

@RestController
public class NavController {

    @Autowired
    private NavService navService;

    @GetMapping("/nav")
    public RetResponse getNav(){
        return new RetResponse().makeOKRsp(200,navService.get_nav_list());
    }
}
