package com.haui.project.repository;

import com.haui.project.entity.Bill;
import com.haui.project.entity.BillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, BillId> {
}
