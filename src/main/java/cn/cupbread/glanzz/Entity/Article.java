package cn.cupbread.glanzz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2020/2/22
 * @Author: CupOfBread
 * @Description:
 */
@Entity
@Table(name = "glanzz_article")
//@ToString(callSuper = true,exclude = {"comments"})
//@JsonIgnoreProperties(value = {"comments"})
@Accessors(chain = true)
@Data
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    private String title;  //标题
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private String headPicture; //头图
    private Long views;
    private Boolean commentable;  //是否可评论
    private Boolean publish;  //是否发布
    private Boolean recommend;  //是否推荐
    private String createTime;  //创建时间
    private String updateTime;  //最后更新时间

    @ManyToOne
    private Classification classification;

//    @OrderColumn
//    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
//    private List<Tag> tags=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

//    @OrderColumn
    @OneToMany(mappedBy = "article",fetch = FetchType.EAGER)
    private List<Comment> comments=new ArrayList<>();

}
