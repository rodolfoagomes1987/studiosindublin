
package mbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.AddressDao;
import dao.StudioDao;
import model.Address;
import model.Customer;
import model.Studio;

@ManagedBean
@SessionScoped
public class StudioMBean {

	private DataModel<Studio> studios = new ArrayDataModel<Studio>();
	StudioDao dao = new StudioDao();
	AddressDao daoAddress = new AddressDao();
	Studio studio = new Studio();
	Address address = new Address();
	Integer addressId = 0;

	public String editAction() {
		refreshListModel();
		return "studio.xhtml";

	}

	// action listener event
	public void attrListener(ActionEvent event) {

		addressId = (Integer) event.getComponent().getAttributes().get("actionDsLogin");

		address = daoAddress.byId(addressId);

		refreshListModel();

	}

	private void refreshListModel() {

		List<Studio> listFlats = dao.listByAddress(address.getId());

		studios = new ListDataModel<Studio>(listFlats);
		/*
		 * for (Studio studio : studios) {
		 * 
		 * System.out.println(studio.getDescription()); for (Customer c :
		 * studio.getCustomers()) { System.out.println("--- " + c.getName()); } }
		 * 
		 * System.out.println(3);
		 */

	}

	public void prepararAlterar(ActionEvent event) {
		studio = studios.getRowData();
	}

	public void remove(ActionEvent event) {
		studio.setStatus(0);
		for (Customer c : studio.getCustomers()) {
			c.setStatus(0);

		}
		dao.update(studio);
		studio = new Studio();

		refreshListModel();

	}

	public void save(ActionEvent event) {
		studio.setStatus(1);
		dao.update(studio);
		studio = new Studio();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "studio", "Studio saved!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		refreshListModel();

	}

	public void preparAdd(ActionEvent event) {
		studio = new Studio();
		studio.setAddress(address);

	}

	public DataModel<Studio> getStudios() {
		return studios;
	}

	public void setStudios(DataModel<Studio> studios) {
		this.studios = studios;
	}

	public StudioDao getDao() {
		return dao;
	}

	public void setDao(StudioDao dao) {
		this.dao = dao;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public AddressDao getDaoAddress() {
		return daoAddress;
	}

	public void setDaoAddress(AddressDao daoAddress) {
		this.daoAddress = daoAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

}
