package snow.myticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import snow.myticket.bean.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer>{

    /**
     * 根据ID，获取修改信息实体
     * @param reviewId ID
     * @return 修改信息实体
     */
    Review findById(Integer reviewId);

    /**
     * 根据状态，获取修改信息列表
     * @param status 状态
     * @return 修改信息列表
     */
    List<Review> findByStatus(Integer status);

    /**
     * 获取场馆修改状态
     * @param stadiumCode 场馆编码
     * @return 状态码
     */
    @Query("SELECT r.status FROM Review r WHERE r.stadiumCode = ?1 and r.status = 0")
    Integer getModifyStatus(String stadiumCode);

    /**
     * 修改场馆信息审核的状态
     * @param reviewId 审核ID
     * @param status 状态码
     */
    @Transactional
    @Modifying
    @Query("UPDATE Review r SET r.status = ?2 WHERE r.id = ?1")
    void changeModifyStatus(Integer reviewId, Integer status);
}
