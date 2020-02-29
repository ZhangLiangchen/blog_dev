package blog.controller;

import blog.entity.TBlog;
import blog.service.TBlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TBlog)表控制层
 *
 * @author makejava
 * @since 2020-02-29 20:41:29
 */
@RestController
@RequestMapping("tBlog")
public class TBlogController {
    /**
     * 服务对象
     */
    @Resource
    private TBlogService tBlogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBlog selectOne(Long id) {
        return this.tBlogService.queryById(id);
    }

}