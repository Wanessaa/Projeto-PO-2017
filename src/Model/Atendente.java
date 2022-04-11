package Model;

public class Atendente {

	private String cod;
	private String cpf;
	private String nome;
	
	public Atendente(String cod,String cpf,String nome){
	   this.cod=cod;
	   this.cpf=cpf;
	   this.nome=nome;
		   
	   }
	   
	   public String getCod() {
			return cod;
		}


		public void setCod(String cod) {
			this.cod = cod;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getNome() {
            return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	

}
