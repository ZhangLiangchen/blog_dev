package blog.controller;

import blog.entity.TTag;
import blog.service.TTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TTag)表控制层
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
@RestController
@RequestMapping("tTag")
public class TTagController {
    /**
     * 服务对象
     */
    @Resource
    private TTagService tTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TTag selectOne(Long id) {
        return this.tTagService.queryById(id);
    }

}