package blog.service;

import blog.entity.TTag;

import java.util.List;

/**
 * (TTag)表服务接口
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
public interface TTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TTag queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TTag> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    TTag insert(TTag tTag);

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    TTag update(TTag tTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}