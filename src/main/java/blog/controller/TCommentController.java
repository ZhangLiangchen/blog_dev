package blog.controller;

import blog.entity.TComment;
import blog.service.TCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TComment)表控制层
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
@RestController
@RequestMapping("tComment")
public class TCommentController {
    /**
     * 服务对象
     */
    @Resource
    private TCommentService tCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TComment selectOne(Long id) {
        return this.tCommentService.queryById(id);
    }

}