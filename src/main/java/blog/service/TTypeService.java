package blog.service;

import blog.entity.TType;

import java.util.List;

/**
 * (TType)表服务接口
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */
public interface TTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TType queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tType 实例对象
     * @return 实例对象
     */
    TType insert(TType tType);

    /**
     * 修改数据
     *
     * @param tType 实例对象
     * @return 实例对象
     */
    TType update(TType tType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}