package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@SQLDelete(sql = "UPDATE accounts SET status='closed' WHERE id=?")
@Where(clause = "status NOT IN('closed', 'blocked')")
@Entity
public class Accounts implements Serializable {

	@Id
	private Integer id;
	private String name;
	private Float bal;
	private String bankname;
	private String status;

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

	public Float getBal() {
		return bal;
	}

	public void setBal(Float bal) {
		this.bal = bal;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Accounts [id=" + id + ", name=" + name + ", bal=" + bal + ", bankname=" + bankname + ", status="
				+ status + "]";
	}

}
