package blog.entity;

import java.io.Serializable;

/**
 * (TTag)实体类
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
public class TTag implements Serializable {
    private static final long serialVersionUID = -54626739759529977L;

    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}