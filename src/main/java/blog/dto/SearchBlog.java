package blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 博客列表页进行多条件查询时所使用的类
 * 查询条件：标题、分类、年月
 * @author 浅忆
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SearchBlog {
    private String title;
    private Long typeId;
    private String date;
    private String nextDate;
}