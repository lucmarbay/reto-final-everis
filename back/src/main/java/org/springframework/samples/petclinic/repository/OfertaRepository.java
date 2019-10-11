package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

	/*Oferta findById(int id) throws DataAccessException;

	void save(Oferta oferta) throws DataAccessException;

	Collection<Oferta> findAll() throws DataAccessException;

	void delete(Oferta oferta) throws DataAccessException;*/

	Collection<Oferta> findByFechaExpiracionGreaterThanEqual(Date date);
}
