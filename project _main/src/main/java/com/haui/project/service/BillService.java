package com.haui.project.service;

//import com.haui.project.repository.BillRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BillService {
//    @Autowired
//    private BillRepository billRepository;
//}

import com.haui.project.entity.Bill;
import com.haui.project.entity.BillId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    public List<Bill> getListBill();
    public Bill getBillById(BillId id);
    //    public List<Bill> searchBill(String keyword);
    public Bill createBill(Bill newBill);
    public boolean deleteBill(BillId id);
    public Bill updateBill(BillId id, Bill upBill);

}