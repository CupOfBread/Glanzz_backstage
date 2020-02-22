package cn.cupbread.glanzz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */
@Entity
@Table(name = "glanzz_tag")
@Accessors(chain = true)
@Data
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    private String name;  //标签名称

    @ManyToMany(mappedBy = "tags")
    private List<Article> articles=new ArrayList<>();
}
