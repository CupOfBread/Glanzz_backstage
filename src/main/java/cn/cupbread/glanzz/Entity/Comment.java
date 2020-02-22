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
@Table(name = "glanzz_comment")
@Accessors(chain = true)
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //创建时间
    private Boolean publish;  //发布状态

    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComment = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;
}
