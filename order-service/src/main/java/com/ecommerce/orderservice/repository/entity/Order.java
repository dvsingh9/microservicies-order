package com.ecommerce.orderservice.repository.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "myOrder")
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private String customerName;

    private LocalDateTime orderDate;

    private String  shippingAddress;

    private Integer orderTotal;

    @Column
    @ElementCollection(targetClass= UUID.class)
    private Set<UUID> orderItems;

    @CreatedBy
    @Column
    private String createdBy;

    @LastModifiedBy
    @Column
    private String updatedBy;

    @CreatedDate
    @Column
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedOn;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID();
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
