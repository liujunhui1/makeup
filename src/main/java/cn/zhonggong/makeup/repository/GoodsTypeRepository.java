package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 9:45
 * <p>
 * * 自定义 sql 语句
 * * 在SQL的查询方法上面使用@Query注解，如涉及到删除和修改在需要加上@Modifying.
 * * <p>
 * * 注意当调用自定义更新和删除sql操作时，会出现下面的异常
 * * org.springframework.dao.InvalidDataAccessApiUsageException:
 * * Executing an update/delete query; nested exception is javax.persistence.
 * * TransactionRequiredException: Executing an update/delete query
 * * <p>
 * * <p>
 * * 对于该异常的原因是更新和删除操作没有进行事务处理，
 * * 解决办法是在service层调用CustomerRepository接口的方法的方法上添加注解@Transactional进行事务的处理,
 * * 然后在调用service层的方法
 */
@Repository
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Integer>, JpaSpecificationExecutor<GoodsType> {

    /*
    from的表名称需要是实体类中的name的值*/
    //@Query("select distinct childName from tb_goodstype where mainId is  null")
    @Query("select new cn.zhonggong.makeup.domain.GoodsType(g.id, g.mainName) from tb_goodstype g where g.mainId  = null")
    List<GoodsType> findMainName();

    // @Query("select distinct mainName from GoodsType where mainId not null")
    // List<String> findChildName();
    @Query("select distinct childName from tb_goodstype where mainId is not null")
    List<String> findChildName();


    /*
  通过一级栏目查找二级栏目
   */
    List<String> findChildNameByMainId(int mainId);

    List<String> findChildNameByMainNameAndMainIdNotNull(String mainName);
}
