package org.springframework.samples.petclinic.model;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.rest.JacksonCustomOwnerDeserializer;
import org.springframework.samples.petclinic.rest.JacksonCustomOwnerSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="ofertas")
@JsonSerialize(using = JacksonCustomOwnerSerializer.class)
@JsonDeserialize(using = JacksonCustomOwnerDeserializer.class)
public class Oferta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotEmpty
	private int id;
	
	@Column(name = "Title")
	@NotEmpty
	private String titulo;
	
	@Column(name = "Description")
	@NotEmpty
	private String descripcion;
	
	@Column(name = "Discount")
	@NotEmpty
	@Digits(fraction = 1, integer = 3)
	private double descuento;
	
	@Column(name = "ExpireDate")
	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
	private Date fechaExpiracion;
	
	public Oferta() {
		
	}
	
	

	public Oferta(int id, String titulo, String descripcion, double descuento, Date fechaExpiracion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.fechaExpiracion = fechaExpiracion;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	
	@Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            .append("Titulo", this.getTitulo())
            .append("Descripcion", this.getDescripcion())
            .append("Descuento", this.getDescuento())
            .append("FechaExpiracion", this.getFechaExpiracion().toString())
            .toString();
    }
}