package blog.dao;

import blog.entity.TTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TTag)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-29 20:41:34
 */

@Mapper
public interface TTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TTag queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TTag> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tTag 实例对象
     * @return 对象列表
     */
    List<TTag> queryAll(TTag tTag);

    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 影响行数
     */
    int insert(TTag tTag);

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 影响行数
     */
    int update(TTag tTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}