package Model;

public class Onibus {

	private String tipo;
	 private String status;
	 private int numPoltrona;
	 private String id ;
	 
	   public Onibus (String tipo,String status,int numPoltrona,String id) {
		   this.tipo=tipo;
		   this.status=status;
		   this.numPoltrona=numPoltrona;
		   this.id=id;
	   }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumPoltrona() {
		return numPoltrona;
	}

	public void setNumPoltrona(int numPoltrona) {
		this.numPoltrona = numPoltrona;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
}