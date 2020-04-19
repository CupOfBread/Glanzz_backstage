package cn.cupbread.glanzz.Component;

import cn.hutool.crypto.SecureUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020/2/21
 * @Author: CupOfBread
 * @Description:
 */

@Component
public class StartedTips implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=====================项目启动完毕！=====================");
//        System.out.println(SecureUtil.md5("123456"));
    }
}
