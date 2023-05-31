package com.haui.project.model.mapper;

import com.haui.project.entity.Bill;

public class BillMapper {
    public static Bill toBill(Bill bill){
        Bill tmp = new Bill();
        tmp.setBillId(bill.getBillId());
        tmp.setCustomer(bill.getCustomer());
        tmp.setRoom(bill.getRoom());

        return tmp;
    }
}
