package blog.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("t_tag")
public class Tag {
    private Long id;
    private String name;

    @TableField(exist = false)
    private List<Blog> blogs = new ArrayList<>();
}
