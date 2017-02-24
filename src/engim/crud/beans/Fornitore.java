package engim.crud.beans;

public class Fornitore implements BeanInterface {
	
	private String Codf;
	private String nome;
	private String citta_sede;
	private int n_soci;
	
	public Fornitore() {
		super();
	}
	
	
	public Fornitore(String codf, String nome, String citta_sede, int n_soci) {
		super();
		Codf = codf;
		this.nome = nome;
		this.citta_sede = citta_sede;
		this.n_soci = n_soci;
	}
	
	public String getCodf() {
		return Codf;
	}
	public void setCodf(String codf) {
		Codf = codf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCitta_sede() {
		return citta_sede;
	}
	public void setCitta_sede(String citta_sede) {
		this.citta_sede = citta_sede;
	}
	public int getN_soci() {
		return n_soci;
	}
	public void setN_soci(int n_soci) {
		this.n_soci = n_soci;
	}

	@Override
	public String toString() {
		return "Fornitore [Codf=" + Codf + ", nome=" + nome + ", citta_sede=" + citta_sede + ", n_soci=" + n_soci + "]";
	}

	@Override
	public String[] attributeToArrayString() {
		String [] str = new String[]{Codf,nome,citta_sede, String.valueOf(n_soci)};
		return str;
	}
	
	

}
