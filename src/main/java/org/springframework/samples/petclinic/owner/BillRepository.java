package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	
    @Transactional(readOnly = true)
    Bill findById(Integer id);
    
    @SuppressWarnings("unchecked")
	Bill save(Bill bill);
    
	@Query("SELECT btype FROM BillType btype ORDER BY btype.name")
	@Transactional(readOnly = true)
	List<BillType> findBillTypes();

}
