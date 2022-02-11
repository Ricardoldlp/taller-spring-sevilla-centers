/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.vet.SpecialityRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	private static final Logger LOG = LoggerFactory.getLogger(PetClinicApplication.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
   
        
    }

    @Bean
    public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository, PetRepository petRepository, VisitRepository visitRepository) {
    	return (args) -> {
    		
    		LOG.info("********************************************************");
    		LOG.info("BOOTCAMP -Spring y Spring Data - vetRepository");
    		LOG.info("********************************************************");
    		/*	
    		LOG.info("Creamos un objeto Vet");
    		Vet vet = new Vet();
    		vet.setFirstName("Manuel");
    		vet.setLastName("Vargas Llosa");
    		
    		LOG.info("Persistimos en BBDD");
    		vet = vetRepository.save(vet);
    		
    		LOG.info("Comprobamos que se ha creado correctamente");
    		Vet vetAux = vetRepository.findOne(vet.getId());
    		LOG.info(vetAux.toString());
    		
    		LOG.info("Editamos el objeto añadimos una Speciality");
    		Specialty s = specialityRepository.findOne(1);
    		vet.addSpecialty(s);
    		vet=vetRepository.save(vet);
    		LOG.info(vet.toString());
    		
    		*/
    		LOG.info("Listamos todos los veterinarios");
    		for(Vet v: vetRepository.findAll()) {
    			LOG.info("Vet: "+v.getFirstName());
    		}

    		LOG.info("Listamos los veterinarios filtrando por lastName");
    		for(Vet v: vetRepository.findByLastName("Vargas Llosa")) {
    			LOG.info("Vet: "+v.getFirstName()+" "+v.getLastName());
    		}
    		LOG.info("Listamos los veterinarios filtrando por firstName y lastName");
    		for(Vet v: vetRepository.findByFirstNameAndLastName("Manuel","Vargas Llosa")) {
    			LOG.info("Vet: "+v.getFirstName()+" "+v.getLastName());
    		}
    		
    		LOG.info("Listamos los veterinarios filtrando por firstName o lastName");
    		for(Vet v: vetRepository.findByFirstNameOrLastName("Manuel","Vargas Llosa")) {
    			LOG.info("Vet: "+v.getFirstName()+" "+v.getLastName());
    		}
    		
    		LOG.info("Listamos los veterinarios filtrando especialidad");
    		for(Vet v: vetRepository.findBySpecialityName("radiology")) {
    			LOG.info("Vet: "+v.getFirstName()+" "+v.getLastName());
    		}
    		
    		LOG.info("Primera tarea del reto, mostrar mascotas nacidas en 2000 ordenadas por fecha de nacimiento ascendente");
    		for(Pet p: petRepository.findByBirthDate(2000)) {
    			LOG.info("Mascota: "+p.getName()+", nacida en : "+p.getBirthDate());
    		}
    		//El reto dice 2010, pero no hay mascotas nacidas en esa fecha
    		

    		LOG.info("Segunda tarea del reto, Introducir 3 visitas nuevas");
    		LOG.info("Mostramos las visitas actuales:");
    		for(Visit v:visitRepository.findAll()) {
    			LOG.info("Visita: "+v.getDate()+", "+v.getDescription());
    		}
    /*		
    		LOG.info("Introducimos las visitas");
    		Date date = new GregorianCalendar(2010, Calendar.FEBRUARY, 5).getTime();
    		Visit visit = new Visit();
    		visit.setDate(date);
    		visit.setDescription("1ª visita para el reto");
    		visit.setPetId(1);
    		
    		visit= visitRepository.save(visit);
    		

    		visit = new Visit();
    		date.setDate(12);
    		visit.setDate(date);
    		visit.setDescription("2ª visita para el reto");
    		visit.setPetId(1);
    		
    		visit= visitRepository.save(visit);

    		visit = new Visit();
    		date.setDate(19);
    		visit.setDate(date);
    		visit.setDescription("3ª visita para el reto");
    		visit.setPetId(1);
    		
    		visit= visitRepository.save(visit);
    		

    		LOG.info("Volvemos a mostrar las visitas:");
    		for(Visit v:visitRepository.findAll()) {
    			LOG.info("Visita: "+v.getDate()+", "+v.getDescription());
    		}
    		
    		*/
    		LOG.info("Visitas de la pet con id: 1");
    		for(Visit v:visitRepository.findByPetId(1)) {
    			LOG.info("Fecha: "+v.getDate()+", Descripción: "+v.getDescription());
    		}
    		
    		LOG.info("Mostramos las últimas 4 visitas");
    		for(Visit v:visitRepository.findTop4ByOrderByDateDesc()) {
    			LOG.info("Fecha: "+v.getDate()+", Descripción: "+v.getDescription());
    		}
    		
    	};
    }
    

}
