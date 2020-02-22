package cn.cupbread.glanzz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description: 分类
 */
@Entity
@Table(name = "glanzz_classification")
@Accessors(chain = true)
@Data
public class Classification {
    @Id
    @GeneratedValue
    private Long id;

    private String name;  //分类名称
    private String ename;  //分类别名[英文]
    private String pic;  //分类图片
    private String parent;  //上级分类

    @OneToMany(mappedBy = "classification")
    private List<Article> articles=new ArrayList<>();
}
