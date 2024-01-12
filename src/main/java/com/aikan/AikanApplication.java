package com.aikan;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aikan.model.Atendimento;
import com.aikan.model.ItemAtendimento;
import com.aikan.model.Paciente;
import com.aikan.model.Procedimento;
import com.aikan.model.Tutor;
import com.aikan.model.enuns.Especie;
import com.aikan.repositories.AtendimentoRepository;
import com.aikan.repositories.ItemAtendimentoRepository;
import com.aikan.repositories.PacienteRepository;
import com.aikan.repositories.ProcedimentoRepository;
import com.aikan.repositories.TutorRepository;

@SpringBootApplication
public class AikanApplication implements CommandLineRunner {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ItemAtendimentoRepository itemRepository;

	static void main(String[] args) {
		SpringApplication.run(AikanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		Tutor t1 = new Tutor(null, "Ivanio Martins", "092.348.134-64", "ivaniomartins1991@gmail.com", null);
		Paciente p1 = new Paciente(null, "Nakia", "American-Bully", 20.1, sdf.parse("14/04/2023"), Especie.CANINA, t1);

		tutorRepository.saveAll(Arrays.asList(t1));
		pacienteRepository.saveAll(Arrays.asList(p1));

		Procedimento v1 = new Procedimento(null, "Vacina-Raiva", 70.0);
		procedimentoRepository.saveAll(Arrays.asList(v1));

		Atendimento a1 = new Atendimento(null, date, p1);

		ItemAtendimento i1 = new ItemAtendimento(null, v1, a1);

		atendimentoRepository.saveAll(Arrays.asList(a1));
		itemRepository.saveAll(Arrays.asList(i1));
	}

}
