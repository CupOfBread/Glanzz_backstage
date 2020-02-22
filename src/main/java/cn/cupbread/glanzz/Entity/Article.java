package cn.cupbread.glanzz.Entity;

import lombok.Data;
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
    private String views;
    private Boolean commentable;  //是否可评论
    private Boolean publish;  //是否发布
    private Boolean recommend;  //是否推荐
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;  //最后更新时间

    @ManyToOne
    private Classification classification;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments=new ArrayList<>();

}
