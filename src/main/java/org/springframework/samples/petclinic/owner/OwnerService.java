package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner findById(int id) {
		return this.ownerRepository.findById(id);
	}
	
	public List<Owner> findByLastName(String lastName){
		return ownerRepository.findByLastName(lastName);
	}
	
	public List<Owner> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName){
		return ownerRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
	}
	public List<Owner> searchOwner (String query){
		return ownerRepository.searchOwner(query);
	}
	
	public List<Owner> findByOrderByLastName(){
		return ownerRepository.findByOrderByLastName();
	}
	
	public List<Owner> findAll(){
		return ownerRepository.findAll();
	}
}
