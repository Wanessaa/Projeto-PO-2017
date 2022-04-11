package Model;

public class Venda {



	//chaves estrageiras
	private String cod_atendente;
	private String cod_passagem;
	private String onibus_id;
	private String nome_cliente;
	private String id;
	private String cpf_comprador;
	private String datanasc;
	private String rg;
	private String hora;
	private boolean preferencial;

	public  Venda(String cod_atendente, String cod_passagem, String onibus_id,String nome_cliente
			,String id, String cpf_comprador,String datanasc, String rg,String hora,boolean preferencial) {
		this.cod_atendente=cod_atendente;
		this.cod_passagem= cod_passagem;
		this.onibus_id= onibus_id;
		this.nome_cliente= nome_cliente;
		this.id= id;
		this.cpf_comprador= cpf_comprador;
		this.datanasc=datanasc;
		this.rg= rg;
		this.hora=hora;
		this.preferencial=preferencial;


	}


	public boolean getPreferencial() {
		return preferencial;
	}

	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCpf_comprador() {
		return cpf_comprador;
	}

	public void setCpf(String cpf_comprador) {
		this.cpf_comprador = cpf_comprador;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}



	public String getCod_atendente() {
		return cod_atendente;
	}



	public void setCod_atendente(String cod_atendente) {
		this.cod_atendente = cod_atendente;
	}



	public String getCod_passagem() {
		return cod_passagem;
	}



	public void setCod_passagem(String cod_passagem) {
		this.cod_passagem = cod_passagem;
	}



	public String getOnibus_id() {
		return onibus_id;
	}



	public void setOnibus_id(String onibus_id) {
		this.onibus_id = onibus_id;
	}


}
