package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the SCHEDULING database table.
 * 
 */
@Entity
@Table(name = "SCHEDULING")
@NamedQuery(name = "Scheduling.findAll", query = "SELECT s FROM Scheduling s")
@NamedQuery(name = "Scheduling.byTodayDate", query = "SELECT s FROM Scheduling s where cast(s.dateStart as date) = current_date()")
public class Scheduling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "address")
	private String address;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_end")
	private Date dateEnd;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_start")
	private Date dateStart;

	@Column(name = "isfullday")
	private int isfullday;

	@Column(name = "service_description")
	private String serviceDescription;

	public Scheduling() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		if (address != null) {
			address = address.trim();
			address = address.replace("'", "");
		}
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public int getIsfullday() {
		return this.isfullday;
	}

	public void setIsfullday(int isfullday) {
		this.isfullday = isfullday;
	}

	public String getServiceDescription() {
		if (serviceDescription != null) {
			serviceDescription = serviceDescription.trim();
			serviceDescription = serviceDescription.replace("'", "");
		}
		return this.serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

}