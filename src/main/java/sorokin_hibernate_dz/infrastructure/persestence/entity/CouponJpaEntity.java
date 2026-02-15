package sorokin_hibernate_dz.infrastructure.persestence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coupon")
public class CouponJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ManyToMany
    @JoinTable(
            name = "coupon_clients",
            joinColumns = @JoinColumn(
                    name = "client_id", nullable = false
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "coupon_id", nullable = false
            )
    )
    private List<ClientJpaEntity> clients = new ArrayList<>();


    public static CouponJpaEntity create(String code, Double discount) {
        return new CouponJpaEntity(code, discount);
    }

    public static CouponJpaEntity of(Long id, String code, Double discount) {
        return new CouponJpaEntity(id, code, discount);
    }

    private CouponJpaEntity(Long id, String code, Double discount) {
        this.id = id;
        this.code = code;
        this.discount = discount;
    }

    private CouponJpaEntity(String code, Double discount) {
        this.code = code;
        this.discount = discount;
    }

    public void addClient(ClientJpaEntity clientJpaEntity){
        clients.add(clientJpaEntity);
    }

    public void removeClient(ClientJpaEntity clientJpaEntity){
        clients.remove(clientJpaEntity);
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Double getDiscount() {
        return discount;
    }

    private CouponJpaEntity() {}
}
