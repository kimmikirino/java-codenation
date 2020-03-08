package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.*;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(this.existeTime(id)) {
			throw new IdentificadorUtilizadoException("Identificador para o time ja esta sendo utilizado");
		} else {
			Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			times.add(time);
		}
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(!this.existeTime(idTime)) {
			throw new TimeNaoEncontradoException("Time nao encontrado");
		}

		Time time = this.getTimeById(id);
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		time.addJogador(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador jogador = this.getJogador(idJogador);
		Time time = this.getTimeById(jogador.getIdTime());
		time.setIdJogadorCapitao(jogador.getId());
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = this.getTimeById(idTime);

		if(time.getIdJogadorCapitao() == null){
			throw new CapitaoNaoInformadoException("O capitão ainda não foi especificado!");
		}
		return time.getIdJogadorCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return this.getJogador(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return this.getTimeById(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> listaIdJogadores = new ArrayList<>();
		this.getTimeById(idTime).getJogadores().forEach(jogador -> {
			listaIdJogadores.add(jogador.getId());
		});

		return listaIdJogadores.stream().sorted().collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = this.getTimeById(idTime);

		return 	time.getJogadores()
				.stream().max((j1, j2) -> j1.getNivelHabilidade().compareTo(j2.getNivelHabilidade()))
				.get()
				.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		List<Jogador> listaJogadores = this.getTimeById(idTime).getJogadores();

		return listaJogadores
				.stream()
				.sorted(Comparator.comparing(Jogador::getDataNascimento)
						.thenComparing(Jogador::getId))
				.findFirst()
				.get()
				.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

		List<Long> idTimes = new ArrayList<>();
		for(Time time : times){
			idTimes.add(time.id);
		}
		return idTimes;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		return this.getTimeById(idTime).getJogadores()
				.stream()
				.max((Comparator.comparing(Jogador::getSalario)))
				.get()
				.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return this.getJogador(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return 	times.stream()
				.map(t -> t.getJogadores())
				.flatMap( jogadors -> jogadors.stream())
				.sorted (Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.limit(top)
				.map(l -> l.getId()).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa = this.getTimeById(timeDaCasa);
		Time timeFora = this.getTimeById(timeDeFora);

		if(timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())){
			return timeFora.getCorUniformeSecundario();
		}

		return timeFora.getCorUniformePrincipal();
	}

	boolean existeTime(Long id) {
		return times.contains(id);
	}

	Time getTimeById(Long id) {
		Time time = times.parallelStream().
				filter(team -> team.getId().equals(id)).
				findFirst().orElse(null);

		if(time == null) {
			throw new TimeNaoEncontradoException("Time nao encontrado!");
		}

		return time;
	}

	Jogador getJogador(Long id) {
		for (Time time:times) {
			for (Jogador jogador:time.getJogadores()) {
				if( id.equals(jogador.getId())){
					return jogador;
				}
			}
		}

		throw new JogadorNaoEncontradoException("O jogador nao foi encontrado");
	}
}
