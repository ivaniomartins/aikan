package com.aikan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTutor;
	private String nome;
	private String cpf;
	private String email;

	// UM TUTOR PODE TER VÁRIOS ANIMAIS;
	@JsonIgnore
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
	private List<Paciente> pacientes = new ArrayList<>();

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public Tutor() {

	}

	public Tutor(Long codTutor, String nome, String cpf, String email, List<Paciente> pacientes) {
		super();
		this.codTutor = codTutor;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.pacientes = pacientes;
	}

	public Long getCodTutor() {
		return codTutor;
	}

	public void setCodTutor(Long codTutor) {
		this.codTutor = codTutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPacientes(List<Paciente> pacientes) {

		this.pacientes = pacientes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codTutor, cpf, email, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		return Objects.equals(codTutor, other.codTutor) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Tutor [codTutor=" + codTutor + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + "]";
	}

}
