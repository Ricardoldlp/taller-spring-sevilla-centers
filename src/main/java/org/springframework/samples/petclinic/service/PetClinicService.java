package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.vet.SpecialityRepository;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class PetClinicService implements IPetClinicService{

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	
	@Autowired
	private VetRepository vetRepository;
	
	@Autowired
	private SpecialityRepository specRepository;	

	/*Métodos de Owner*/
	public Owner findOwnerById(int id) {
		return this.ownerRepository.findById(id);
	}
	
	public List<Owner> findOwnerByLastName(String lastName){
		return ownerRepository.findByLastName(lastName);
	}
	
	public List<Owner> findOwnerByFirstNameContainingOrLastNameContaining(String firstName, String lastName){
		return ownerRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
	}
	public List<Owner> searchOwner (String query){
		return ownerRepository.searchOwner(query);
	}
	
	public List<Owner> findOwnerByOrderByLastName(){
		return ownerRepository.findByOrderByLastName();
	}
	
	public List<Owner> findOwnerAll(){
		return ownerRepository.findAll();
	}
	
	/* Métodos de Pet */
	
	public List<Pet> findPetsByBirdYear(int year){
		return petRepository.findByBirthDate(year);
	}
	
	/* Métodos de Visit*/
	public List<Visit> findPetVisitsByPetId(Integer petId){
		return visitRepository.findByPetId(petId);
	}

	public List<Visit> findFirstVisits(){
		return visitRepository.findTop10ByOrderByDateAsc();
	}

	public List<Visit> findLastVisits(){
		return visitRepository.findTop4ByOrderByDateDesc();
	}
	
}
