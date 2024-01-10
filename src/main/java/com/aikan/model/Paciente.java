package com.aikan.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdPaciente;
	private String nmPaciente;
	private String raca;
	private Double peso;
	private Date dtNascimento;
	private String especie;

	// UM ANIMAL TEM UM TUTOR

	@ManyToOne
	@JoinColumn(name = "cod_tutor")
	private Tutor tutor;

	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<>();

	public Paciente() {

	}

	public Paciente(Long cdPaciente, String nmPaciente, String raca, Double peso, Date dtNascimento, Tutor tutor) {
		this.cdPaciente = cdPaciente;
		this.nmPaciente = nmPaciente;
		this.raca = raca;
		this.peso = peso;
		this.dtNascimento = dtNascimento;
		this.tutor = tutor;

	}

	public Long getCdPaciente() {
		return cdPaciente;
	}

	public void setCdPaciente(Long cdPaciente) {
		this.cdPaciente = cdPaciente;
	}

	public String getNmPaciente() {
		return nmPaciente;
	}

	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {

		this.atendimentos = atendimentos;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Código: ");
		sb.append(getCdPaciente());
		sb.append("Nome: ");
		sb.append(getNmPaciente());
		sb.append("Especie: ");
		sb.append(getEspecie());
		sb.append("Data de Nascimento: ");
		// sb.append(sdf.parseObject(getDtNascimento()));
		sb.append("Tutor: ");
		sb.append(getTutor().getNome());

		return sb.toString();

	}

}
