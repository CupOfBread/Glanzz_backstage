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
@Table(name = "glanzz_comment")
@ToString(callSuper = true,exclude = {"article"})
@JsonIgnoreProperties(value = {"article","parentComment"})
@Accessors(chain = true)
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private String createTime; //创建时间
    private Boolean publish;  //发布状态

    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Article article;

    @OneToMany(mappedBy = "parentComment",fetch = FetchType.EAGER)
    private List<Comment> replyComment = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Comment parentComment;
}
