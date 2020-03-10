package blog.dto;

import blog.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 博客列表页显示数据所使用的类
 * @author 浅忆
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogTable {
    private Long id;
    private String title;
    private String updateTime;
    private Boolean published;
    private String typeName;
    private Integer views;
    /**
     * 根据发布确定博客状态，已发布/草稿箱
     */
    private String state;
}
