package com.aikan.model;



import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdProcedimento;
	private String nmProcedimento;
	private Double vlProcedimento;

	public Procedimento() {

	}

	public Procedimento(Long cdProcedimento, String nmProcedimento, Double vlProcedimento) {
		this.cdProcedimento = cdProcedimento;
		this.nmProcedimento = nmProcedimento;
		this.vlProcedimento = vlProcedimento;

	}

	public Long getCdProcedimento() {
		return cdProcedimento;
	}

	public void setCdProcedimento(Long cdProcedimento) {
		this.cdProcedimento = cdProcedimento;
	}

	public String getNmProcedimento() {
		return nmProcedimento;
	}

	public void setNmProcedimento(String nmProcedimento) {
		this.nmProcedimento = nmProcedimento;
	}

	public Double getVlProcedimento() {
		return vlProcedimento;
	}

	public void setVlProcedimento(Double vlProcedimento) {
		this.vlProcedimento = vlProcedimento;
	}
	
	

}
