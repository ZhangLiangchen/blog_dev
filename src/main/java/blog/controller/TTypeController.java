package blog.controller;

import blog.entity.TType;
import blog.service.TTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TType)表控制层
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
@RestController
@RequestMapping("tType")
public class TTypeController {
    /**
     * 服务对象
     */
    @Resource
    private TTypeService tTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TType selectOne(Long id) {
        return this.tTypeService.queryById(id);
    }

}