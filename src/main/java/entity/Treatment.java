package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Treatment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	private String description;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "start_date")
	private Date startDate;

	public Treatment(Doctor doctor, String description, Date endDate, Date startDate) {
		super();
		this.doctor = doctor;
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
	}

	public Treatment() {
		super();
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Treatment [doctor=" + doctor + ", description=" + description + ", endDate=" + endDate + ", startDate="
				+ startDate + "]";
	}

}
