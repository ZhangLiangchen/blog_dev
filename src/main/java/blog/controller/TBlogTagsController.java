package blog.controller;

import blog.entity.TBlogTags;
import blog.service.TBlogTagsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TBlogTags)表控制层
 *
 * @author makejava
 * @since 2020-02-29 20:41:33
 */
@RestController
@RequestMapping("tBlogTags")
public class TBlogTagsController {
    /**
     * 服务对象
     */
    @Resource
    private TBlogTagsService tBlogTagsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBlogTags selectOne(Integer id) {
        return this.tBlogTagsService.queryById(id);
    }

}