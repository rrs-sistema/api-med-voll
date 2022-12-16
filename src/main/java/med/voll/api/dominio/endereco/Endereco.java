package med.voll.api.dominio.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
	
	public Endereco(DadosEndereco endereco) {
		this.logradouro = endereco.logradouro();
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.cidade = endereco.cidade();
		this.uf = endereco.uf();
		this.numero = endereco.numero();		
		this.complemento = endereco.complemento();	
	}
	
	private String logradouro;
	private String bairro; 
	private String cep; 
	private String cidade; 
	private String uf; 
	private String numero;
	private String complemento;
	
}
