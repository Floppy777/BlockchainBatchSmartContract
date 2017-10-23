package blockchain.batch.model;

import java.sql.Date;

public class Project {

	private int id;
	private String name;
	private String address;
	private Float amountTotal;
	private Float amountWanted;
	private Integer nbDonation;
	private Date updateAt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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

	public Float getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(Float amountTotal) {
		this.amountTotal = amountTotal;
	}

	public Float getAmountWanted() {
		return amountWanted;
	}

	public void setAmountWanted(Float amountWanted) {
		this.amountWanted = amountWanted;
	}

	public Integer getNbDonation() {
		return nbDonation;
	}

	public void setNbDonation(Integer nbDonation) {
		this.nbDonation = nbDonation;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", address=" + address + ", amountTotal=" + amountTotal
				+ ", amountWanted=" + amountWanted + ", nbDonation=" + nbDonation + "]";
	}
	
}
