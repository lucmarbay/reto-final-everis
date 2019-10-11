package org.springframework.samples.petclinic.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.service.OfertaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ofertas")
public class OfertaRestController {
	@Autowired
	private OfertaService ofertaService;
	
	@GetMapping(value="/{id}")
    public Oferta findOfertasById(@PathVariable int id) {
        return ofertaService.findById(id);
    }

	@GetMapping("/")
	public Collection<Oferta> getOfertas(){
		return ofertaService.findAll();
	}
}
