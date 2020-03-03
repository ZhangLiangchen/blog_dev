package blog.service.impl;

import blog.entity.TBlogTags;
import blog.mapper.TBlogTagsDao;
import blog.service.TBlogTagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBlogTags)表服务实现类
 *
 * @author makejava
 * @since 2020-02-29 20:41:32
 */
@Service("tBlogTagsService")
public class TBlogTagsServiceImpl implements TBlogTagsService {
    @Resource
    private TBlogTagsDao tBlogTagsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBlogTags queryById(Integer id) {
        return this.tBlogTagsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TBlogTags> queryAllByLimit(int offset, int limit) {
        return this.tBlogTagsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBlogTags 实例对象
     * @return 实例对象
     */
    @Override
    public TBlogTags insert(TBlogTags tBlogTags) {
        this.tBlogTagsDao.insert(tBlogTags);
        return tBlogTags;
    }

    /**
     * 修改数据
     *
     * @param tBlogTags 实例对象
     * @return 实例对象
     */
    @Override
    public TBlogTags update(TBlogTags tBlogTags) {
        this.tBlogTagsDao.update(tBlogTags);
        return this.queryById(tBlogTags.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tBlogTagsDao.deleteById(id) > 0;
    }
}