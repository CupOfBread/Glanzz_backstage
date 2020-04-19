package cn.cupbread.glanzz.Controller;

import cn.cupbread.glanzz.Component.RetResponse;
import cn.cupbread.glanzz.Entity.Classification;
import cn.cupbread.glanzz.Service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/4/14/014 21:24
 * @Description ：
 * @Version: :
 */

@RestController
public class ClassifiController {
    @Autowired
    private ClassificationService classificationService;

    // 获取所有分类
    @GetMapping("/classifi")
    public RetResponse getClassification(HttpServletRequest request) {
        return new RetResponse().makeOKRsp(200,classificationService.get_classifi_list());
    }
    // 新增
    @PostMapping("/classifi")
    public RetResponse newClassification(HttpServletRequest request) {
        String name=request.getParameter("name");
        String ename=request.getParameter("ename");
        String pic=request.getParameter("pic");
        String parent=request.getParameter("parent");
        Classification classification=classificationService.save_classifi(new Classification().setName(name).setEname(ename).setPic(pic));
        return new RetResponse().makeOKRsp(200,classification);
    }

    //  删除
    @PostMapping("/classifi/del")
    public RetResponse delClassification(HttpServletRequest request) {
        Long classifyId = Long.parseLong(request.getParameter("id"));
        classificationService.del_classifi(classifyId);
        return new RetResponse().makeOKRsp(200);
    }
}
