package com.ecommerce.orderitemservice.repository.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private String productName;

    private String productCode;

    private Integer salePrice;

    private Integer quantity;

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
