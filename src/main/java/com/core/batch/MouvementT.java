/**
 * 
 */
package com.core.batch;

import java.util.Date;

/**
 * @author vdibi
 *
 */
public class MouvementT{
	public int id;
	public int id_content;
	public String title;
	public String transaction_type;
	public String gamme;
	public String profil;
	public String comment;
	public Date createdAt;
	public Date releasedAt;
	public String valueConcaneded;
	
	public void setValueConcaneded(String valueConcaneded) {
		this.valueConcaneded = valueConcaneded;
	}

	public MouvementT(){
		
	}
	
	public MouvementT( String title,
			String transaction_type, String comment,String valueConcaneded,String gamme,String profil,Date createdAt) {
		super();
		
		this.title = title;
		this.transaction_type = transaction_type;
		this.comment = comment;
		this.valueConcaneded = valueConcaneded;
		this.gamme = gamme;
		this.profil = profil;
		this.createdAt = createdAt;
		
	}
	
	public MouvementT(int id, int id_content, String title,
			String transaction_type, String comment, Date createdAt,
			Date releasedAt,String valueConcaneded,String gamme,String profil) {
		super();
		this.id = id;
		this.id_content = id_content;
		this.title = title;
		this.transaction_type = transaction_type;
		this.comment = comment;
		this.createdAt = createdAt;
		this.releasedAt = releasedAt;
		this.valueConcaneded = valueConcaneded;
		this.gamme = gamme;
		this.profil = profil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_content() {
		return id_content;
	}
	public void setId_content(int id_content) {
		this.id_content = id_content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getReleasedAt() {
		return releasedAt;
	}
	public void setReleasedAt(Date releasedAt) {
		this.releasedAt = releasedAt;
	}

	public String getValueConcaneded() {
		return valueConcaneded;
	}

	public String getGamme() {
		return gamme;
	}

	public String setGamme(String gamme) {
		return this.gamme = gamme;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

}
