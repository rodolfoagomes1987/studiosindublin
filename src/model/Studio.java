package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the residential_type database table.
 * 
 */
@Entity
@Table(name = "STUDIO")
@NamedQuery(name = "Studio.findAllByAddress", query = "SELECT r FROM Studio r where r.status=1 and  r.address.id = :idAdress")
public class Studio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@Column(name = "status")
	private Integer status;

	// bi-directional many-to-one association to Address
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_address")
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "studio", cascade = { CascadeType.ALL })
	private List<Customer> customers;

	public Studio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getLastPositionArray() {
		if (customers != null && customers.size() != 0)
			return customers.size() - 1;
		return 0;
	}

	public int getCustomersSize() {

		ArrayList<Customer> ativosList = new ArrayList<Customer>();

		if (customers != null && customers.size() != 0) {

			for (Customer c : customers) {

				if (c.getStatus().intValue() == 1)
					ativosList.add(c);

			}

		}

		return ativosList.size();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}