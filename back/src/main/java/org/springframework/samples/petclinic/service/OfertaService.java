package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.repository.OfertaRepository;
import org.springframework.stereotype.Service;
@Service
public class OfertaService {
	
	@Autowired
	public OfertaRepository ofertaRepository;
	
	public Oferta findById(int id) {
		return this.ofertaRepository.getOne(id);
	}
	
	public void save(Oferta oferta) {
		this.ofertaRepository.save(oferta);
		
	}
	public Collection<Oferta> findAll() {
		return this.ofertaRepository.findAll();
		
	}
	public void delete(Oferta oferta) {
		this.ofertaRepository.delete(oferta);
		
	}
	public Collection<Oferta> findByDateGreaterThanEqual(Date date) {
		return this.ofertaRepository.findByFechaExpiracionGreaterThanEqual(date);
		
	}
}