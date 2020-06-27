package cn.cupbread.glanzz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
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
@JsonIgnoreProperties(value = {"articles"})
@Data
public class Classification implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;  //分类名称
    private String ename;  //分类别名[英文]
    private String pic;  //分类图片
    private String description;  //描述
    @ToString.Exclude
    @OneToMany(mappedBy = "classification",fetch = FetchType.EAGER)
    private List<Article> articles=new ArrayList<>();
}
