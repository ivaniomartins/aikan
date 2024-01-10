package com.aikan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtAtendimento;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_paciente")
	private Paciente paciente;

	@JsonIgnore
	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
	private List<ItemAtendimento> itens = new ArrayList<>();

	public Atendimento() {

	}

	public Atendimento(Long cdAtendimento, Date dtAtendimento, Paciente paciente) {
		this.cdAtendimento = cdAtendimento;
		this.dtAtendimento = dtAtendimento;
		this.paciente = paciente;

	}

	public Long getCdAtendimento() {
		return cdAtendimento;
	}

	public void setCdAtendimento(Long cdAtendimento) {
		this.cdAtendimento = cdAtendimento;
	}

	public Date getDtAtendimento() {
		return dtAtendimento;
	}

	public void setDtAtendimento(Date dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<ItemAtendimento> getItens() {
		return itens;
	}

	public void setItens(List<ItemAtendimento> itens) {
		this.itens = itens;
	}

	public List<ItemAtendimento> getItemAtendimentos() {
		return itens;
	}

	public void setAtendimentos(List<ItemAtendimento> itens) {

		this.itens = itens;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(getPaciente().getCdPaciente());
		sb.append(getPaciente().getNmPaciente());
		sb.append(getCdAtendimento());

		return sb.toString();
	}

}
