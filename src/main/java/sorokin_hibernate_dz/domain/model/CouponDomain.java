package sorokin_hibernate_dz.domain.model;

import java.util.Objects;

public class CouponDomain {
    private Long id;
    private String code;
    private Double discount;


    public static CouponDomain create(String code, Double discount){
        return new CouponDomain(code, discount);
    }

    public static CouponDomain of(Long id, String code, Double discount) {
        return new CouponDomain(id, code, discount);
    }

    private CouponDomain(String code, Double discount) {
        updateCode(code);
        updateDiscount(discount);
    }

    private CouponDomain(Long id, String code, Double discount) {
        setId(id);
        updateCode(code);
        updateDiscount(discount);
    }

    public Double getDiscount() {
        return discount;
    }
    public void updateDiscount(Double discount) {
        if (discount == null || discount <= 0 || discount > 100) {
            throw new IllegalArgumentException(
                    "The discount should be between 1 and 100"
            );
        }

        this.discount = discount;
    }

    public String getCode() {
        return code;
    }
    public void updateCode(String code) {
        if (code == null || code.isBlank() || code.length() > 255) {
            throw new IllegalArgumentException(
                    "Code cannot be null or blank and must be less than 255 character"
            );
        }

        this.code = code;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id){
        if (id == null || id < 0) {
            throw new IllegalArgumentException(
                    "The id cannot be null and negative (ID: %d)"
                            .formatted(id)
            );
        }

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CouponDomain coupon)) return false;
        return Objects.equals(id, coupon.id) && Objects.equals(code, coupon.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "CouponDomain{" +
                "discount=" + discount +
                ", code='" + code + '\'' +
                ", id=" + id +
                '}';
    }
}
