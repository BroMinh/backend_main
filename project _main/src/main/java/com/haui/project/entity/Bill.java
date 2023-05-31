package com.haui.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BILL")
public class Bill {
    @EmbeddedId
    private BillId billId;
    @ManyToOne
    @MapsId("CUSTOMER_ID")
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @MapsId("ROOM_ID")
    @JoinColumn(name = "ROOM_ID")
    private Room room;
}
