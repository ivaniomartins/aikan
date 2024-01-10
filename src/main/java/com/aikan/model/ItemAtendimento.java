package com.aikan.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ItemAtendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;

	
	@ManyToOne
	@JoinColumn(name = "id_procedimento")
	private Procedimento procedimento;

    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_atendimento")
	private Atendimento atendimento;

	public ItemAtendimento() {

	}

	public ItemAtendimento(Long idItem, Procedimento procedimento, Atendimento atendimento) {
		this.idItem = idItem;
		this.procedimento = procedimento;
		this.atendimento = atendimento;
	}
	
	

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public String  toString() {
		
   StringBuilder sb = new StringBuilder();
   sb.append(getAtendimento().getCdAtendimento());
   sb.append(", itens: ");
   sb.append(getIdItem());
   sb.append( ", procedimentos: ");
   sb.append(getProcedimento().getCdProcedimento());
		
		return sb.toString();	
		}

}
