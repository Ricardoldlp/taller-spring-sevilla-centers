package org.springframework.samples.petclinic.vet;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SpecialityRepository extends JpaRepository<Specialty, Integer> {

    /**
     * Retrieve all <code>Vet</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>Vet</code>s
     */
    @Transactional(readOnly = true)
    @Cacheable("specialties")
    List<Specialty> findAll() throws DataAccessException;


}