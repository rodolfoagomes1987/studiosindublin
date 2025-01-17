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
import model.Address;
import model.Customer;
import model.Studio;

@ManagedBean
@SessionScoped
public class AddressMBean {

	private DataModel<Address> addresses = new ArrayDataModel<Address>();
	private Address address;
	private AddressDao dao = new AddressDao();

	public DataModel<Address> getAddresses() {
		address = null;
		List<Address> listAddress = dao.list();
		addresses = new ListDataModel<Address>(listAddress);
		return addresses;
	}

	public void setaddresss(DataModel<Address> dm) {
		addresses = dm;
	}

	public void prepararIncluir(ActionEvent event) {
		address = new Address();
	}

	public void prepararAlterar(ActionEvent event) {
		address = addresses.getRowData();
	}

	public void gravar(ActionEvent event) {
		address.setStatus(1);
		dao.update(address);
		address = new Address();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "address", "Address saved!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void remove(ActionEvent event) {
		address.setStatus(0);
		for (Studio s : address.getResidentialTypes()) {
			s.setStatus(0);
			for (Customer c : s.getCustomers()) {
				c.setStatus(0);

			}
		}
		dao.update(address);
		address = new Address();

		getAddresses();

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressDao getDao() {
		return dao;
	}

	public void setDao(AddressDao dao) {
		this.dao = dao;
	}

	public void setAddresses(DataModel<Address> addresses) {
		this.addresses = addresses;
	}

}
