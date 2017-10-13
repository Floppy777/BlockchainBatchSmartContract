package core.batch.model;

public class Project {

	private Integer id;
	private String name;
	private String address;
	private String desc;
	private Integer montant;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Integer getMontant() {
		return montant;
	}
	
	public void setMontant(Integer montant) {
		this.montant = montant;
	}
}
