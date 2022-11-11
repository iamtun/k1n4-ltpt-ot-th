package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
@AttributeOverride(name = "name", column = @Column(name = "patient_name"))
public class Patient extends Person implements Serializable{
	private String address;
	@Column(name = "date_of_birth")
	private Date DOB;

	@ElementCollection(fetch = FetchType.EAGER)
	Set<Treatment> treatments;

	public Patient(String id, String name, Set<String> phones, String address, Date dOB, Set<Treatment> treatments) {
		super(id, name, phones);
		this.address = address;
		DOB = dOB;
		this.treatments = treatments;
	}

	public Patient() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Set<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(Set<Treatment> treatments) {
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return super.toString() +  "Patient [address=" + address + ", DOB=" + DOB + ", treatments=" + treatments + "]";
	}

}
