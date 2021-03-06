package snow.myticket.service;

import snow.myticket.bean.Coupon;
import snow.myticket.bean.Member;
import snow.myticket.bean.Orders;
import snow.myticket.bean.Seat;

import java.util.List;
import java.util.Map;

public interface MemberService {
    /**
     * 根据邮箱获取会员实体
     * @param email 会员邮箱
     * @return 会员实体
     */
    Member getMember(String email);

    /**
     * 得到所有有效会员实体
     * @return 会员列表
     */
    List<Member> getAllMembers();

    /**
     * 在DB中创建会员实体
     * @param member 会员实体
     */
    void createMember(Member member);

    /**
     * 取消会员资格/不可恢复
     * @param email 会员邮箱
     */
    void cancelMember(String email);

    /**
     * 修改会员信息
     * @param member 会员实体
     */
    void modifyMemberInfo(Member member);

    /**
     * 查看会员余额是否足够支付
     * @param memberId 会员ID
     * @param sum 待支付总金额
     * @return 是否足够
     */
    boolean checkMemberBalance(Integer memberId, Double sum);

    /**
     * 计算订单总价
     * @param orders 订单实体
     * @return 订单总价
     */
    Double calculateTotalPrice(Orders orders);

    /**
     * 会员预定订单
     * @param orders 订单实体
     * @return 订单实体
     */
    Orders reserveOrders(Orders orders);

    /**
     * 会员预定座位
     * @param seat 座位实体
     */
    void reserveOrdersSeat(Seat seat);

    /**
     * 取消订单, 3天之内取消返还80%,否则返还50%
     * @param ordersId 订单ID
     * @return map信息
     */
    Map<String,String> cancelOrders(Integer ordersId);

    /**
     * 通过会员余额支付订单
     * @param ordersId 订单ID
     */
    void payByMemberAccount(Integer ordersId);

    /**
     * 通过支付宝或网上银行支付订单
     * @param ordersId 订单ID
     * @param account 支付宝或网上银行账户
     */
    void payByExternalAccount(Integer ordersId, String account);

    /**
     * 兑换优惠券
     * @param coupon 优惠券实体
     * @param amount 数量
     */
    void convertCoupons(Coupon coupon, Integer amount);

}
