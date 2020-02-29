package blog.service;

import blog.entity.TBlogTags;

import java.util.List;

/**
 * (TBlogTags)表服务接口
 *
 * @author makejava
 * @since 2020-02-29 20:41:32
 */
public interface TBlogTagsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlogTags queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TBlogTags> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tBlogTags 实例对象
     * @return 实例对象
     */
    TBlogTags insert(TBlogTags tBlogTags);

    /**
     * 修改数据
     *
     * @param tBlogTags 实例对象
     * @return 实例对象
     */
    TBlogTags update(TBlogTags tBlogTags);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}