package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.dto.DadosCadastroMedico;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "medicos")
@Entity(name = "Medico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

	public Medico(DadosCadastroMedico dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.crm = dados.crm();
		this.telefone = dados.telefone();
		this.especialidade= dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
		this.ativo = true;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String crm;
	private String telefone;
	private Boolean ativo;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	@Embedded
	private Endereco endereco;

	public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}		
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}			
	}

	public void excluir() {
		this.ativo = false;
	}
	
}
