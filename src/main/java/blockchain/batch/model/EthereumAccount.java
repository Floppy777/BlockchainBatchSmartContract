package blockchain.batch.model;

public class EthereumAccount {

	private String address;
	private String password;
	
	public EthereumAccount(){}
	
	public EthereumAccount(String address, String password){
		this.address = address;
		this.password = password;
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

	@Override
	public String toString() {
		return "EthereumAccount [address=" + address + ", password=" + password + "]";
	}
}
