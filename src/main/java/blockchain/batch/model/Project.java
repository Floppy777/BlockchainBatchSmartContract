package blockchain.batch.model;

import java.sql.Date;

public class Project {

	private int id;
	private String name;
	private String address;
	private Float amountTotal;
	private Float amountWanted;
	private Integer nbDonation;
	private Date updatedAt;
	private Date endDate;
	private Boolean isClosed;
	private Integer progress;
	
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
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updateAt) {
		this.updatedAt = updateAt;
	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", address=" + address + ", amountTotal=" + amountTotal
				+ ", amountWanted=" + amountWanted + ", nbDonation=" + nbDonation + ", updatedAt=" + updatedAt
				+ ", endDate=" + endDate + ", isClosed=" + isClosed + ", progress=" + progress + "]";
	}
}
