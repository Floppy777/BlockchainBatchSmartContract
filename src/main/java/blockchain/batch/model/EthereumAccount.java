package blockchain.batch.model;

public class EthereumAccount {

	private String address;
	private String password;
	private String utcFile;
	
	public EthereumAccount(){}
	
	public EthereumAccount(String address, String password,String file){
		this.address = address;
		this.password = password;
		this.utcFile = file;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUtcFile() {
		return utcFile;
	}

	public void setUtcFile(String utcFile) {
		this.utcFile = utcFile;
	}

	@Override
	public String toString() {
		return "EthereumAccount [address=" + address + ", password=" + password + ", utcFile=" + utcFile + "]";
	}
}
