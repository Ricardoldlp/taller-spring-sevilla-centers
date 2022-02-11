package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillService {
	@Autowired
	private BillRepository billRepository;
	
	public void save(Bill bill) {
		this.billRepository.save(bill);
	}
	public Bill findById(Integer id) {
		return this.billRepository.findById(id);
	}
	public List<BillType> findBillTypes(){
		return this.billRepository.findBillTypes();
	}
	
	public void delete(Integer id) {
		this.billRepository.delete(id);
	}
}
