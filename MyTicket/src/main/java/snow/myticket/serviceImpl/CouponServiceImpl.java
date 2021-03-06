package snow.myticket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snow.myticket.bean.Coupon;
import snow.myticket.repository.CouponRepository;
import snow.myticket.service.CouponService;

import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public List<Coupon> getCouponsByMemberId(Integer memberId) {
        return couponRepository.findByMemberIdAndStatusAndExpirationDateAfter(memberId,0,new Date());
    }

    @Override
    public Coupon getCouponById(Integer couponId) {
        return couponRepository.findById(couponId);
    }

    @Override
    public void addCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }


    @Override
    public void useCoupon(Integer couponId) {
        couponRepository.setCouponInvalid(couponId);
    }
}
