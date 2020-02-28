package cn.cupbread.glanzz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Date: 2020/2/25
 * @Author: CupOfBread
 * @Description:
 */
@Entity
@Table(name = "glanzz_permission")
@Accessors(chain = true)
@Data
public class Permission {
    @Id
    @GeneratedValue
    private Long id;

    private String userGroup;  //用户组
    private String perm;  //具体权限
}
