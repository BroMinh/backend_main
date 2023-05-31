package com.haui.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillId implements Serializable {
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "ROOM_ID")
    private Long roomId;
}
