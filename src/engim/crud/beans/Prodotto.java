package engim.crud.beans;

public class Prodotto implements BeanInterface{
	
	private String CodP;
	private String nome;
	private String magazzino;
	private int qta;
	private String colore;
	private String taglia;
	

	public Prodotto() {
		super();
	}
	
	
	public Prodotto(String codP, String nome, int qta, String colore, String taglia,String magazzino) {
		super();
		CodP = codP;
		this.nome = nome;
		this.magazzino = magazzino;
		this.qta = qta;
		this.colore = colore;
		this.taglia = taglia;
	}
	
	public String getCodP() {
		return CodP;
	}
	public void setCodP(String codP) {
		CodP = codP;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMagazzino() {
		return magazzino;
	}
	public void setMagazzino(String magazzino) {
		this.magazzino = magazzino;
	}
	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	@Override
	public String toString() {
		return "Prodotto [CodP=" + CodP + ", nome=" + nome + ", magazzino=" + magazzino + ", qta=" + qta + ", colore="
				+ colore + ", taglia=" + taglia + "]";
	}

	@Override
	public String[] attributeToArrayString() {
		String [] str = new String[]{CodP,nome,taglia, colore, String.valueOf(qta), magazzino};
		return str;
	}
	
	
	
}
