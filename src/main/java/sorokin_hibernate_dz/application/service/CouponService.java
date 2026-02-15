package sorokin_hibernate_dz.application.service;

import sorokin_hibernate_dz.application.mapper.CouponDtoMapper;
import sorokin_hibernate_dz.domain.repository.CouponRepository;
import sorokin_hibernate_dz.application.dto.createRequest.CouponCreateRequest;
import sorokin_hibernate_dz.application.dto.patchRequest.CouponPatchRequest;
import sorokin_hibernate_dz.application.dto.response.CouponResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    private final CouponRepository couponRepository;
    private final CouponDtoMapper dtoMapper;

    public CouponService(
            CouponRepository couponRepository,
            CouponDtoMapper dtoMapper) {
        this.couponRepository = couponRepository;
        this.dtoMapper = dtoMapper;
    }

    public CouponResponse applyCouponPatch(
            Long couponId,
            CouponPatchRequest patchRequest
    ) {
        var domain = couponRepository.findDomainByIdOrThrow(couponId);

        domain.updateCode(patchRequest.getCode());
        domain.updateDiscount(patchRequest.getDiscount());

        var savedDomain = couponRepository.save(domain);

        return dtoMapper.toResponse(savedDomain);
    }

    public CouponResponse createCoupon(CouponCreateRequest request) {
        var mappedDomain = dtoMapper.fromCreateRequest(request);

        var savedDomain = couponRepository.save(mappedDomain);

        return dtoMapper.toResponse(savedDomain);
    }

    public CouponResponse findCouponById(Long couponId) {
        var domain = couponRepository.findDomainByIdOrThrow(couponId);

        return dtoMapper.toResponse(domain);
    }

    public void addClientsToCoupon(Long couponId, List<Long> clientIds){
        couponRepository.addClients(couponId, clientIds);
    }

    public void removeClientsFromCoupon(Long couponId, List<Long> clientIds){
        couponRepository.removeClients(couponId, clientIds);
    }
}
