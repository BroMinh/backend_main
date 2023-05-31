package com.haui.project.controller;

import com.haui.project.entity.Bill;
import com.haui.project.entity.BillId;
import com.haui.project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@CrossOrigin
public class BillController {
    @Autowired
    private BillService billService;
    @GetMapping("/getAll")
    public ResponseEntity<?> getListBill(){
        List<Bill> bills = billService.getListBill();
        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBillById(@PathVariable BillId id){
        Bill result = billService.getBillById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBill(@RequestBody Bill newBill){
        Bill bill = billService.createBill(newBill);
        return ResponseEntity.ok(bill);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> updateBill(@PathVariable BillId id,@RequestBody Bill upBill){
        Bill bill = billService.updateBill(id, upBill);
        return ResponseEntity.ok(bill);
    }

    @DeleteMapping(path="/delete/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteBill(@PathVariable BillId id){
        boolean bill = billService.deleteBill(id);
        return ResponseEntity.ok(bill);
    }
}
