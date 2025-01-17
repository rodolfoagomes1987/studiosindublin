package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "ADDRESS")
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a where a.status = 1 order by a.description asc")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@Column(name = "status")
	private Integer status;

	// bi-directional many-to-one association to ResidentialType
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "address", cascade = { CascadeType.ALL })
	private List<Studio> residentialTypes;

	public Address() {
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

	public List<Studio> getResidentialTypes() {
		return this.residentialTypes;
	}

	public void setResidentialTypes(List<Studio> residentialTypes) {
		this.residentialTypes = residentialTypes;
	}

	public Studio addResidentialType(Studio residentialType) {
		getResidentialTypes().add(residentialType);
		residentialType.setAddress(this);

		return residentialType;
	}

	public Studio removeResidentialType(Studio residentialType) {
		getResidentialTypes().remove(residentialType);
		residentialType.setAddress(null);

		return residentialType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSizeActivateStudios() {

		int cont = 0;

		if (residentialTypes != null)
			for (Studio s : residentialTypes) {

				if (s.getStatus().intValue() == 1)
					cont++;
			}

		return cont;

	}

}