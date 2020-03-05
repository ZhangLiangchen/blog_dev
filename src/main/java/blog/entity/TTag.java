package blog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TTag {
    private Long id;
    private String name;

    private List<TBlog> blogs = new ArrayList<>();
}
