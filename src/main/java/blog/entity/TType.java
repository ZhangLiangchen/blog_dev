package blog.entity;

import java.io.Serializable;

/**
 * (TType)实体类
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
public class TType implements Serializable {
    private static final long serialVersionUID = 479635581056321032L;

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

    @Override
    public String toString() {
        return "TType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}