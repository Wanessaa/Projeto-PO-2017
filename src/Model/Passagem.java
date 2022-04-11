package Model;

public class Passagem {
    
	private String origem;
	private String destino;
	private String data;
	private String hora;
	private double preco;
	private String tipo;
	private String cod_passagem;
	private String id_onibus;
	private String Status;
	

	public Passagem(String origem,String destino,String data,String hora,double preco,String tipo,String cod_passagem, String id_onibus,String Status) {
		this.origem=origem;
		this.destino=destino;
		this.data=data;
		this.hora=hora;
		this.preco=preco;
		this.tipo=tipo;
		this.cod_passagem=cod_passagem;
		this.id_onibus=id_onibus;
		this.setStatus("disponível");
		
		
		
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String getCod_passagem() {
		return cod_passagem;
	}


	public void setCod_passagem(String cod_passagem) {
		this.cod_passagem = cod_passagem;
	}


	public String getId_onibus() {
		return id_onibus;
	}


	public void setId_onibus(String id_onibus) {
		this.id_onibus = id_onibus;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	

}


