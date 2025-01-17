package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "CUSTOMER")

@NamedQueries({
		@NamedQuery(name = "Customer.findById", query = "SELECT a FROM Customer a where a.id = :id and a.status = 1 and a.studio.status = 1 order by a.id desc"),
		@NamedQuery(name = "Customer.findByFinishDate", query = "SELECT a FROM Customer a where a.status = 1 and a.studio.status = 1 order by a.fixedTermTo asc"),
		@NamedQuery(name = "Customer.findByDay", query = "SELECT a FROM Customer a where a.status = 1 and a.studio.status = 1 order by a.rentDay asc"),
		@NamedQuery(name = "Customer.findByAgent", query = "SELECT a FROM Customer a where a.status = 1 and a.studio.status = 1 order by a.dateAgentSave desc"),
		@NamedQuery(name = "Customer.findByInchargedAgent", query = "SELECT a FROM Customer a where a.status = 1 and a.studio.status = 1 and a.user is not null order by a.user "),
		@NamedQuery(name = "Customer.findByInchargedAgentByUser", query = "SELECT a FROM Customer a where a.status = 1 and a.studio.status = 1 and a.user.id= :id and a.user is not null order by a.user")

})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "PRTBNumber", length = 100)
	private String PRTBNumber;

	@Column(name = "addressTenancy", length = 100)
	private String addressTenancy;

	@Column(name = "passportNumber", length = 100, nullable = false)
	private String passportNumber;

	@Column(name = "passportExpiryDate", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date passportExpiryDate;

	@Column(name = "gnibNumber", length = 50)
	private String gnibNumber;

	@Column(name = "gnibExpiryDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date gnibExpiryDate;

	@Column(name = "ppsNumber", length = 50)
	private String ppsNumber;

	@Column(name = "nationality", length = 50, nullable = false)
	private String nationality;

	@Column(name = "dateOfBirth", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Column(name = "placeOfBirth", length = 50)
	private String placeOfBirth;

	@Column(name = "phoneNumber", length = 20)
	private String phoneNumber;

	@Column(name = "dateOfCommencent", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateOfCommencent;

	@Column(name = "depositPaid", nullable = false)
	private BigDecimal depositPaid;

	@Column(name = "rentInAdvance", nullable = false)
	private BigDecimal rentInAdvance;

	@Column(name = "termOfTheTenancy", length = 20)
	private String termOfTheTenancy;

	@Column(name = "fixedTermFrom", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fixedTermFrom;

	@Column(name = "fixedTermTo", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fixedTermTo;

	@Transient
	private String fixedTermToFormat;

	@Transient
	private String fixedTermFromFormat;

	@Column(name = "rentDay", length = 2, nullable = false)
	private Integer rentDay;

	@Column(name = "agent", length = 30, nullable = false)
	private String agent;

	@Column(name = "dateAgentSave", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateAgentSave;

	@Transient
	private String dateAgentSaveFormat;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "status")
	private Integer status;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "id_studio")
	private Studio studio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private User user;

	@Transient
	private int countLineUser;

	@Column(name = "contentUnitTable", length = 15)
	private String contentUnitTable;

	@Column(name = "contentConditionTable", length = 15)
	private String contentConditionTable;

	@Column(name = "contentUnitChairs", length = 15)
	private String contentUnitChairs;

	@Column(name = "contentConditionChairs", length = 15)
	private String contentConditionChairs;

	@Column(name = "contentUnitFridgeClean", length = 15)
	private String contentUnitFridgeClean;

	@Column(name = "contentConditionFridgeClean", length = 15)
	private String contentConditionFridgeClean;

	@Column(name = "contentUnitCookerClean", length = 15)
	private String contentUnitCookerClean;

	@Column(name = "contentConditionCookerClean", length = 15)
	private String contentConditionCookerClean;

	@Column(name = "contentUnitDoubleBed", length = 15)
	private String contentUnitDoubleBed;

	@Column(name = "contentConditionDoubleBed", length = 15)
	private String contentConditionDoubleBed;

	@Column(name = "contentUnitDoubleMattress", length = 15)
	private String contentUnitDoubleMattress;

	@Column(name = "contentConditionDoubleMattress", length = 15)
	private String contentConditionDoubleMattress;

	@Column(name = "contentUnitSingleBed", length = 15)
	private String contentUnitSingleBed;

	@Column(name = "contentConditionSingleBed", length = 15)
	private String contentConditionSingleBed;

	@Column(name = "contentUnitSingleMattress", length = 15)
	private String contentUnitSingleMattress;

	@Column(name = "contentConditionSingleMattress", length = 15)
	private String contentConditionSingleMattress;

	@Column(name = "contentUnitBunkBed", length = 15)
	private String contentUnitBunkBed;

	@Column(name = "contentConditionBunkBed", length = 15)
	private String contentConditionBunkBed;

	@Column(name = "contentUnitWindowHandle", length = 15)
	private String contentUnitWindowHandle;

	@Column(name = "contentConditionWindowHandle", length = 15)
	private String contentConditionWindowHandle;

	@Column(name = "contentUnitDrawerChest", length = 15)
	private String contentUnitDrawerChest;

	@Column(name = "contentConditionDrawerChest", length = 15)
	private String contentConditionDrawerChest;

	@Column(name = "contentUnitWardrobe", length = 15)
	private String contentUnitWardrobe;

	@Column(name = "contentConditionWardrobe", length = 15)
	private String contentConditionWardrobe;

	@Column(name = "contentUnitKeysPerPerson", length = 15)
	private String contentUnitKeysPerPerson;

	@Column(name = "contentConditionKeysPerPerson", length = 15)
	private String contentConditionKeysPerPerson;

	@Column(name = "contentUnitLightBulb", length = 15)
	private String contentUnitLightBulb;

	@Column(name = "contentConditionLightBulb", length = 15)
	private String contentConditionLightBulb;

	@Column(name = "contentUnitBathroomShowerDrain", length = 15)
	private String contentUnitBathroomShowerDrain;

	@Column(name = "contentConditionBathroomShowerDrain", length = 15)
	private String contentConditionBathroomShowerDrain;

	@Column(name = "contentUnitBathroomSinkDrain", length = 15)
	private String contentUnitBathroomSinkDrain;

	@Column(name = "contentConditionBathroomSinkDrain", length = 15)
	private String contentConditionBathroomSinkDrain;

	@Column(name = "contentUnitBathroomHeadHose", length = 15)
	private String contentUnitBathroomHeadHose;

	@Column(name = "contentConditionBathroomHeadHose", length = 15)
	private String contentConditionBathroomHeadHose;

	@Column(name = "contentUnitBathroomToiletFlush", length = 15)
	private String contentUnitBathroomToiletFlush;

	@Column(name = "contentConditionBathroomToiletFlush", length = 15)
	private String contentConditionBathroomToiletFlush;

	@Column(name = "contentUnitKitchenSinkDrain", length = 15)
	private String contentUnitKitchenSinkDrain;

	@Column(name = "contentConditionKitchenSinkDrain", length = 15)
	private String contentConditionKitchenSinkDrain;

	@Column(name = "contentUnitWashingMachineClean", length = 15)
	private String contentUnitWashingMachineClean;

	@Column(name = "contentConditionWashingMachineClean", length = 15)
	private String contentConditionWashingMachineClean;

	@Column(name = "contentUnitDryerMachineClean", length = 15)
	private String contentUnitDryerMachineClean;

	@Column(name = "contentConditionDryerMachineClean", length = 15)
	private String contentConditionDryerMachineClean;

	@Column(name = "emergencyBrazilRg", length = 30)
	private String emergencyBrazilRg;

	@Column(name = "emergencBrazilCpf", length = 30)
	private String emergencBrazilCpf;

	@Column(name = "emergencBrazilFone", length = 30)
	private String emergencBrazilFone;

	@Column(name = "emergencBrazilEndereco", length = 30)
	private String emergencBrazilEndereco;

	@Column(name = "emergencBrazilBairro", length = 30)
	private String emergencBrazilBairro;

	@Column(name = "emergencBrazilComplemento", length = 30)
	private String emergencBrazilComplemento;

	@Column(name = "emergencBrazilCep", length = 30)
	private String emergencBrazilCep;

	@Column(name = "emergencBrazilCidade", length = 30)
	private String emergencBrazilCidade;

	@Column(name = "emergencBrazilEstado", length = 30)
	private String emergencBrazilEstado;

	@Column(name = "serPayCentralMonFriWhatsapp", length = 1)
	private String serPayCentralMonFriWhatsapp;

	@Column(name = "serPaySetOfKeys", length = 1)
	private String serPaySetOfKeys;

	@Column(name = "serPayEletricity", length = 1)
	private String serPayEletricity;

	@Column(name = "arrears", length = 10)
	private String arrears;

	@Column(name = "extraInformation", length = 5000)
	private String extraInformation;
	
	@Column(name = "totalcredit", length = 20)
	private String totalcredit;
	
	@Column(name = "totalcards", length = 20)
	private String totalcards;
	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", passportNumber=" + passportNumber + ", ppsNumber="
				+ ppsNumber + ", nationality=" + nationality + ", dateOfBirth=" + dateOfBirth + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((passportExpiryDate == null) ? 0 : passportExpiryDate.hashCode());
		result = prime * result + ((passportNumber == null) ? 0 : passportNumber.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
		result = prime * result + ((ppsNumber == null) ? 0 : ppsNumber.hashCode());
		result = prime * result + ((rentDay == null) ? 0 : rentDay.hashCode());
		result = prime * result + ((rentInAdvance == null) ? 0 : rentInAdvance.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (passportExpiryDate == null) {
			if (other.passportExpiryDate != null)
				return false;
		} else if (!passportExpiryDate.equals(other.passportExpiryDate))
			return false;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null)
				return false;
		} else if (!placeOfBirth.equals(other.placeOfBirth))
			return false;
		if (ppsNumber == null) {
			if (other.ppsNumber != null)
				return false;
		} else if (!ppsNumber.equals(other.ppsNumber))
			return false;
		if (rentDay == null) {
			if (other.rentDay != null)
				return false;
		} else if (!rentDay.equals(other.rentDay))
			return false;
		if (rentInAdvance == null) {
			if (other.rentInAdvance != null)
				return false;
		} else if (!rentInAdvance.equals(other.rentInAdvance))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Column(name = "serPayRentBook", length = 1)
	private String serPayRentBook;

	@Column(name = "serPayInternetPhoneTV", length = 1)
	private String serPayInternetPhoneTV;

	@Column(name = "serPayPainterPlumber", length = 1)
	private String serPayPainterPlumber;

	@Column(name = "serPayGeneralWasteRecycling", length = 1)
	private String serPayGeneralWasteRecycling;

	@Column(name = "serPayTransfServiceByCar", length = 1)
	private String serPayTransfServiceByCar;

	@Column(name = "serPaySupplyEletricKettle", length = 1)
	private String serPaySupplyEletricKettle;

	@Column(name = "serPaySpareFridgeCook", length = 1)
	private String serPaySpareFridgeCook;

	@Column(name = "serPaySpareDoorLock", length = 1)
	private String serPaySpareDoorLock;

	@Column(name = "serPayToiletSeat", length = 1)
	private String serPayToiletSeat;

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

	public String getPRTBNumber() {
		return PRTBNumber;
	}

	public void setPRTBNumber(String pRTBNumber) {
		PRTBNumber = pRTBNumber;
	}

	public String getAddressTenancy() {
		return addressTenancy;
	}

	public void setAddressTenancy(String addressTenancy) {
		this.addressTenancy = addressTenancy;
	}

	public Date getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public String getGnibNumber() {
		return gnibNumber;
	}

	public void setGnibNumber(String gnibNumber) {
		this.gnibNumber = gnibNumber;
	}

	public Date getGnibExpiryDate() {
		return gnibExpiryDate;
	}

	public void setGnibExpiryDate(Date gnibExpiryDate) {
		this.gnibExpiryDate = gnibExpiryDate;
	}

	public String getPpsNumber() {
		return ppsNumber;
	}

	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getDepositPaid() {
		return depositPaid;
	}

	public void setDepositPaid(BigDecimal depositPaid) {
		this.depositPaid = depositPaid;
	}

	public BigDecimal getRentInAdvance() {
		return rentInAdvance;
	}

	public void setRentInAdvance(BigDecimal rentInAdvance) {
		this.rentInAdvance = rentInAdvance;
	}

	public String getTermOfTheTenancy() {
		return termOfTheTenancy;
	}

	public void setTermOfTheTenancy(String termOfTheTenancy) {
		this.termOfTheTenancy = termOfTheTenancy;
	}

	public Date getFixedTermFrom() {
		return fixedTermFrom;
	}

	public void setFixedTermFrom(Date fixedTermFrom) {
		this.fixedTermFrom = fixedTermFrom;
	}

	public Date getFixedTermTo() {
		return fixedTermTo;
	}

	public void setFixedTermTo(Date fixedTermTo) {
		this.fixedTermTo = fixedTermTo;
	}

	public Integer getRentDay() {
		return rentDay;
	}

	public void setRentDay(Integer rentDay) {
		this.rentDay = rentDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDateOfCommencent() {
		return dateOfCommencent;
	}

	public void setDateOfCommencent(Date dateOfCommencent) {
		this.dateOfCommencent = dateOfCommencent;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Date getDateAgentSave() {
		return dateAgentSave;
	}

	public void setDateAgentSave(Date dateAgentSave) {
		this.dateAgentSave = dateAgentSave;
	}

	public String getDateAgentSaveFormat() {
		if (dateAgentSave != null) {
			dateAgentSaveFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ").format(dateAgentSave);
		}
		return dateAgentSaveFormat;
	}

	public void setDateAgentSaveFormat(String dateAgentSaveFormat) {
		this.dateAgentSaveFormat = dateAgentSaveFormat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFixedTermToFormat() {
		if (fixedTermTo != null) {
			fixedTermToFormat = new SimpleDateFormat("dd/MM/yyyy").format(fixedTermTo);
		}
		return fixedTermToFormat;
	}

	public void setFixedTermToFormat(String fixedTermToFormat) {
		this.fixedTermToFormat = fixedTermToFormat;
	}

	public String getFixedTermFromFormat() {
		if (fixedTermFrom != null) {
			fixedTermFromFormat = new SimpleDateFormat("dd/MM/yyyy").format(fixedTermFrom);
		}
		return fixedTermFromFormat;
	}

	public void setFixedTermFromFormat(String fixedTermFromFormat) {
		this.fixedTermFromFormat = fixedTermFromFormat;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCountLineUser() {
		return countLineUser;
	}

	public void setCountLineUser(int countLineUser) {
		this.countLineUser = countLineUser;
	}

	public String getContentUnitTable() {
		return contentUnitTable;
	}

	public void setContentUnitTable(String contentUnitTable) {
		this.contentUnitTable = contentUnitTable;
	}

	public String getContentConditionTable() {
		return contentConditionTable;
	}

	public void setContentConditionTable(String contentConditionTable) {
		this.contentConditionTable = contentConditionTable;
	}

	public String getContentUnitChairs() {
		return contentUnitChairs;
	}

	public void setContentUnitChairs(String contentUnitChairs) {
		this.contentUnitChairs = contentUnitChairs;
	}

	public String getContentConditionChairs() {
		return contentConditionChairs;
	}

	public void setContentConditionChairs(String contentConditionChairs) {
		this.contentConditionChairs = contentConditionChairs;
	}

	public String getContentUnitFridgeClean() {
		return contentUnitFridgeClean;
	}

	public void setContentUnitFridgeClean(String contentUnitFridgeClean) {
		this.contentUnitFridgeClean = contentUnitFridgeClean;
	}

	public String getContentConditionFridgeClean() {
		return contentConditionFridgeClean;
	}

	public void setContentConditionFridgeClean(String contentConditionFridgeClean) {
		this.contentConditionFridgeClean = contentConditionFridgeClean;
	}

	public String getContentUnitCookerClean() {
		return contentUnitCookerClean;
	}

	public void setContentUnitCookerClean(String contentUnitCookerClean) {
		this.contentUnitCookerClean = contentUnitCookerClean;
	}

	public String getContentConditionCookerClean() {
		return contentConditionCookerClean;
	}

	public void setContentConditionCookerClean(String contentConditionCookerClean) {
		this.contentConditionCookerClean = contentConditionCookerClean;
	}

	public String getContentUnitDoubleBed() {
		return contentUnitDoubleBed;
	}

	public void setContentUnitDoubleBed(String contentUnitDoubleBed) {
		this.contentUnitDoubleBed = contentUnitDoubleBed;
	}

	public String getContentConditionDoubleBed() {
		return contentConditionDoubleBed;
	}

	public void setContentConditionDoubleBed(String contentConditionDoubleBed) {
		this.contentConditionDoubleBed = contentConditionDoubleBed;
	}

	public String getContentUnitDoubleMattress() {
		return contentUnitDoubleMattress;
	}

	public void setContentUnitDoubleMattress(String contentUnitDoubleMattress) {
		this.contentUnitDoubleMattress = contentUnitDoubleMattress;
	}

	public String getContentConditionDoubleMattress() {
		return contentConditionDoubleMattress;
	}

	public void setContentConditionDoubleMattress(String contentConditionDoubleMattress) {
		this.contentConditionDoubleMattress = contentConditionDoubleMattress;
	}

	public String getContentUnitSingleBed() {
		return contentUnitSingleBed;
	}

	public void setContentUnitSingleBed(String contentUnitSingleBed) {
		this.contentUnitSingleBed = contentUnitSingleBed;
	}

	public String getContentConditionSingleBed() {
		return contentConditionSingleBed;
	}

	public void setContentConditionSingleBed(String contentConditionSingleBed) {
		this.contentConditionSingleBed = contentConditionSingleBed;
	}

	public String getContentUnitSingleMattress() {
		return contentUnitSingleMattress;
	}

	public void setContentUnitSingleMattress(String contentUnitSingleMattress) {
		this.contentUnitSingleMattress = contentUnitSingleMattress;
	}

	public String getContentConditionSingleMattress() {
		return contentConditionSingleMattress;
	}

	public void setContentConditionSingleMattress(String contentConditionSingleMattress) {
		this.contentConditionSingleMattress = contentConditionSingleMattress;
	}

	public String getContentUnitBunkBed() {
		return contentUnitBunkBed;
	}

	public void setContentUnitBunkBed(String contentUnitBunkBed) {
		this.contentUnitBunkBed = contentUnitBunkBed;
	}

	public String getContentConditionBunkBed() {
		return contentConditionBunkBed;
	}

	public void setContentConditionBunkBed(String contentConditionBunkBed) {
		this.contentConditionBunkBed = contentConditionBunkBed;
	}

	public String getContentUnitWindowHandle() {
		return contentUnitWindowHandle;
	}

	public void setContentUnitWindowHandle(String contentUnitWindowHandle) {
		this.contentUnitWindowHandle = contentUnitWindowHandle;
	}

	public String getContentConditionWindowHandle() {
		return contentConditionWindowHandle;
	}

	public void setContentConditionWindowHandle(String contentConditionWindowHandle) {
		this.contentConditionWindowHandle = contentConditionWindowHandle;
	}

	public String getContentUnitDrawerChest() {
		return contentUnitDrawerChest;
	}

	public void setContentUnitDrawerChest(String contentUnitDrawerChest) {
		this.contentUnitDrawerChest = contentUnitDrawerChest;
	}

	public String getContentConditionDrawerChest() {
		return contentConditionDrawerChest;
	}

	public void setContentConditionDrawerChest(String contentConditionDrawerChest) {
		this.contentConditionDrawerChest = contentConditionDrawerChest;
	}

	public String getContentUnitWardrobe() {
		return contentUnitWardrobe;
	}

	public void setContentUnitWardrobe(String contentUnitWardrobe) {
		this.contentUnitWardrobe = contentUnitWardrobe;
	}

	public String getContentConditionWardrobe() {
		return contentConditionWardrobe;
	}

	public void setContentConditionWardrobe(String contentConditionWardrobe) {
		this.contentConditionWardrobe = contentConditionWardrobe;
	}

	public String getContentUnitKeysPerPerson() {
		return contentUnitKeysPerPerson;
	}

	public void setContentUnitKeysPerPerson(String contentUnitKeysPerPerson) {
		this.contentUnitKeysPerPerson = contentUnitKeysPerPerson;
	}

	public String getContentConditionKeysPerPerson() {
		return contentConditionKeysPerPerson;
	}

	public void setContentConditionKeysPerPerson(String contentConditionKeysPerPerson) {
		this.contentConditionKeysPerPerson = contentConditionKeysPerPerson;
	}

	public String getContentUnitLightBulb() {
		return contentUnitLightBulb;
	}

	public void setContentUnitLightBulb(String contentUnitLightBulb) {
		this.contentUnitLightBulb = contentUnitLightBulb;
	}

	public String getContentConditionLightBulb() {
		return contentConditionLightBulb;
	}

	public void setContentConditionLightBulb(String contentConditionLightBulb) {
		this.contentConditionLightBulb = contentConditionLightBulb;
	}

	public String getContentUnitBathroomShowerDrain() {
		return contentUnitBathroomShowerDrain;
	}

	public void setContentUnitBathroomShowerDrain(String contentUnitBathroomShowerDrain) {
		this.contentUnitBathroomShowerDrain = contentUnitBathroomShowerDrain;
	}

	public String getContentConditionBathroomShowerDrain() {
		return contentConditionBathroomShowerDrain;
	}

	public void setContentConditionBathroomShowerDrain(String contentConditionBathroomShowerDrain) {
		this.contentConditionBathroomShowerDrain = contentConditionBathroomShowerDrain;
	}

	public String getContentUnitBathroomSinkDrain() {
		return contentUnitBathroomSinkDrain;
	}

	public void setContentUnitBathroomSinkDrain(String contentUnitBathroomSinkDrain) {
		this.contentUnitBathroomSinkDrain = contentUnitBathroomSinkDrain;
	}

	public String getContentConditionBathroomSinkDrain() {
		return contentConditionBathroomSinkDrain;
	}

	public void setContentConditionBathroomSinkDrain(String contentConditionBathroomSinkDrain) {
		this.contentConditionBathroomSinkDrain = contentConditionBathroomSinkDrain;
	}

	public String getContentUnitBathroomHeadHose() {
		return contentUnitBathroomHeadHose;
	}

	public void setContentUnitBathroomHeadHose(String contentUnitBathroomHeadHose) {
		this.contentUnitBathroomHeadHose = contentUnitBathroomHeadHose;
	}

	public String getContentConditionBathroomHeadHose() {
		return contentConditionBathroomHeadHose;
	}

	public void setContentConditionBathroomHeadHose(String contentConditionBathroomHeadHose) {
		this.contentConditionBathroomHeadHose = contentConditionBathroomHeadHose;
	}

	public String getContentUnitBathroomToiletFlush() {
		return contentUnitBathroomToiletFlush;
	}

	public void setContentUnitBathroomToiletFlush(String contentUnitBathroomToiletFlush) {
		this.contentUnitBathroomToiletFlush = contentUnitBathroomToiletFlush;
	}

	public String getContentConditionBathroomToiletFlush() {
		return contentConditionBathroomToiletFlush;
	}

	public void setContentConditionBathroomToiletFlush(String contentConditionBathroomToiletFlush) {
		this.contentConditionBathroomToiletFlush = contentConditionBathroomToiletFlush;
	}

	public String getContentUnitKitchenSinkDrain() {
		return contentUnitKitchenSinkDrain;
	}

	public void setContentUnitKitchenSinkDrain(String contentUnitKitchenSinkDrain) {
		this.contentUnitKitchenSinkDrain = contentUnitKitchenSinkDrain;
	}

	public String getContentConditionKitchenSinkDrain() {
		return contentConditionKitchenSinkDrain;
	}

	public void setContentConditionKitchenSinkDrain(String contentConditionKitchenSinkDrain) {
		this.contentConditionKitchenSinkDrain = contentConditionKitchenSinkDrain;
	}

	public String getContentUnitWashingMachineClean() {
		return contentUnitWashingMachineClean;
	}

	public void setContentUnitWashingMachineClean(String contentUnitWashingMachineClean) {
		this.contentUnitWashingMachineClean = contentUnitWashingMachineClean;
	}

	public String getContentConditionWashingMachineClean() {
		return contentConditionWashingMachineClean;
	}

	public void setContentConditionWashingMachineClean(String contentConditionWashingMachineClean) {
		this.contentConditionWashingMachineClean = contentConditionWashingMachineClean;
	}

	public String getContentUnitDryerMachineClean() {
		return contentUnitDryerMachineClean;
	}

	public void setContentUnitDryerMachineClean(String contentUnitDryerMachineClean) {
		this.contentUnitDryerMachineClean = contentUnitDryerMachineClean;
	}

	public String getContentConditionDryerMachineClean() {
		return contentConditionDryerMachineClean;
	}

	public void setContentConditionDryerMachineClean(String contentConditionDryerMachineClean) {
		this.contentConditionDryerMachineClean = contentConditionDryerMachineClean;
	}

	public String getEmergencyBrazilRg() {
		return emergencyBrazilRg;
	}

	public void setEmergencyBrazilRg(String emergencyBrazilRg) {
		this.emergencyBrazilRg = emergencyBrazilRg;
	}

	public String getEmergencBrazilCpf() {
		return emergencBrazilCpf;
	}

	public void setEmergencBrazilCpf(String emergencBrazilCpf) {
		this.emergencBrazilCpf = emergencBrazilCpf;
	}

	public String getEmergencBrazilFone() {
		return emergencBrazilFone;
	}

	public void setEmergencBrazilFone(String emergencBrazilFone) {
		this.emergencBrazilFone = emergencBrazilFone;
	}

	public String getEmergencBrazilEndereco() {
		return emergencBrazilEndereco;
	}

	public void setEmergencBrazilEndereco(String emergencBrazilEndereco) {
		this.emergencBrazilEndereco = emergencBrazilEndereco;
	}

	public String getEmergencBrazilBairro() {
		return emergencBrazilBairro;
	}

	public void setEmergencBrazilBairro(String emergencBrazilBairro) {
		this.emergencBrazilBairro = emergencBrazilBairro;
	}

	public String getEmergencBrazilComplemento() {
		return emergencBrazilComplemento;
	}

	public void setEmergencBrazilComplemento(String emergencBrazilComplemento) {
		this.emergencBrazilComplemento = emergencBrazilComplemento;
	}

	public String getEmergencBrazilCep() {
		return emergencBrazilCep;
	}

	public void setEmergencBrazilCep(String emergencBrazilCep) {
		this.emergencBrazilCep = emergencBrazilCep;
	}

	public String getEmergencBrazilCidade() {
		return emergencBrazilCidade;
	}

	public void setEmergencBrazilCidade(String emergencBrazilCidade) {
		this.emergencBrazilCidade = emergencBrazilCidade;
	}

	public String getEmergencBrazilEstado() {
		return emergencBrazilEstado;
	}

	public void setEmergencBrazilEstado(String emergencBrazilEstado) {
		this.emergencBrazilEstado = emergencBrazilEstado;
	}

	public String getSerPayCentralMonFriWhatsapp() {
		return serPayCentralMonFriWhatsapp;
	}

	public void setSerPayCentralMonFriWhatsapp(String serPayCentralMonFriWhatsapp) {
		this.serPayCentralMonFriWhatsapp = serPayCentralMonFriWhatsapp;
	}

	public String getSerPaySetOfKeys() {
		return serPaySetOfKeys;
	}

	public void setSerPaySetOfKeys(String serPaySetOfKeys) {
		this.serPaySetOfKeys = serPaySetOfKeys;
	}

	public String getSerPayEletricity() {
		return serPayEletricity;
	}

	public void setSerPayEletricity(String serPayEletricity) {
		this.serPayEletricity = serPayEletricity;
	}

	public String getSerPayRentBook() {
		return serPayRentBook;
	}

	public void setSerPayRentBook(String serPayRentBook) {
		this.serPayRentBook = serPayRentBook;
	}

	public String getSerPayInternetPhoneTV() {
		return serPayInternetPhoneTV;
	}

	public void setSerPayInternetPhoneTV(String serPayInternetPhoneTV) {
		this.serPayInternetPhoneTV = serPayInternetPhoneTV;
	}

	public String getSerPayPainterPlumber() {
		return serPayPainterPlumber;
	}

	public void setSerPayPainterPlumber(String serPayPainterPlumber) {
		this.serPayPainterPlumber = serPayPainterPlumber;
	}

	public String getSerPayGeneralWasteRecycling() {
		return serPayGeneralWasteRecycling;
	}

	public void setSerPayGeneralWasteRecycling(String serPayGeneralWasteRecycling) {
		this.serPayGeneralWasteRecycling = serPayGeneralWasteRecycling;
	}

	public String getSerPayTransfServiceByCar() {
		return serPayTransfServiceByCar;
	}

	public void setSerPayTransfServiceByCar(String serPayTransfServiceByCar) {
		this.serPayTransfServiceByCar = serPayTransfServiceByCar;
	}

	public String getSerPaySupplyEletricKettle() {
		return serPaySupplyEletricKettle;
	}

	public void setSerPaySupplyEletricKettle(String serPaySupplyEletricKettle) {
		this.serPaySupplyEletricKettle = serPaySupplyEletricKettle;
	}

	public String getSerPaySpareFridgeCook() {
		return serPaySpareFridgeCook;
	}

	public void setSerPaySpareFridgeCook(String serPaySpareFridgeCook) {
		this.serPaySpareFridgeCook = serPaySpareFridgeCook;
	}

	public String getSerPaySpareDoorLock() {
		return serPaySpareDoorLock;
	}

	public void setSerPaySpareDoorLock(String serPaySpareDoorLock) {
		this.serPaySpareDoorLock = serPaySpareDoorLock;
	}

	public String getSerPayToiletSeat() {
		return serPayToiletSeat;
	}

	public void setSerPayToiletSeat(String serPayToiletSeat) {
		this.serPayToiletSeat = serPayToiletSeat;
	}

	public String getArrears() {
		return arrears;
	}

	public void setArrears(String arrears) {
		this.arrears = arrears;
	}

	public String getExtraInformation() {
		return extraInformation;
	}

	public void setExtraInformation(String extraInformation) {
		this.extraInformation = extraInformation;
	}

	public String getTotalcredit() {
		return totalcredit;
	}

	public void setTotalcredit(String totalcredit) {
		this.totalcredit = totalcredit;
	}

	public String getTotalcards() {
		return totalcards;
	}

	public void setTotalcards(String totalcards) {
		this.totalcards = totalcards;
	}

}