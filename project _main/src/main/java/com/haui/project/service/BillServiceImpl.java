package com.haui.project.service;

import com.haui.project.entity.Bill;
import com.haui.project.entity.BillId;
import com.haui.project.entity.User;
import com.haui.project.exeption.NotFoundException;
import com.haui.project.model.mapper.BillMapper;
import com.haui.project.model.mapper.UserMapper;
import com.haui.project.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl  implements BillService{
    private static ArrayList<Bill> bills = new ArrayList<>();
    @Autowired
    private BillRepository billRepository;


    @Override
    public List<Bill> getListBill() {
        List<Bill> result = new ArrayList<>();
        for(Bill bill:billRepository.findAll()){
            result.add(BillMapper.toBill(bill));
        }
        return result;
    }


//    total date


    @Override
    public Bill getBillById(BillId id) {
        Bill bill = billRepository.findById(id).orElseThrow(() -> new NotFoundException("Bill không tồn tại trong hệ thống"));
        return BillMapper.toBill(bill);
    }

//    public String unAccent(String s){
//        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}");
//        return pattern.matcher(temp).replaceAll("");
//    }
//    @Override
//    public List<Customer> searchCustomer(String keyword) {
//        List<Customer> result = new ArrayList<>();
//        for(Customer customer:customers){
//            if(customer.getCustomer_name().toLowerCase().contains(keyword.toLowerCase())
//                    || unAccent(customer.getCustomer_name()).toLowerCase().contains(unAccent(keyword.toLowerCase()))){
//                result.add(CustomerMapper.toCustomer(customer));
//            }else {
//                throw new NotFoundException("Không có customer cần tìm kiếm!");
//            }
//        }
//        return result;
//    }

    @Override
    public Bill createBill(Bill newBill){
        return billRepository.save(newBill);
    }



    @Override
    public boolean deleteBill(BillId id) {
        if(!billRepository.existsById(id)){
            throw new NotFoundException("Bill không tồn tại trong hệ thống");
        }
        billRepository.deleteById(id);
        return true;
    }

    @Override
    public Bill updateBill(BillId id, Bill upBill) {
        return billRepository.findById(id).map(bill -> {
            bill.setCustomer(upBill.getCustomer());
            bill.setRoom(upBill.getRoom());
            return  billRepository.save(bill);
        }).orElseThrow(() -> new NotFoundException("Bill không tồn tại trong hệ thống"));
    }
}



