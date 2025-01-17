package mbean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import commun.SessionControl;
import dao.CustomerDao;
import dao.StudioDao;
import dao.UserDao;
import model.Customer;
import model.Studio;
import model.User;
import util.Constants;
import util.Util;

@ManagedBean
@SessionScoped
public class CustomerMBean {

	CustomerDao dao = new CustomerDao();
	StudioDao daoStudio = new StudioDao();
	Customer customer = new Customer();
	Studio studio = new Studio();
	Customer oldCustomer = new Customer();

	List<User> users = new ArrayList<User>();

	UserDao daoUser = new UserDao();

	private StreamedContent file;

	public String editAction() {

		return "customer.xhtml";
	}

	// action listener event
	public void attrListener(ActionEvent event) {

		customer = new Customer();
		oldCustomer = new Customer();

		Long customerId = Long.parseLong("" + event.getComponent().getAttributes().get("customerId"));
		Integer studioId = Integer.parseInt("" + event.getComponent().getAttributes().get("studioId"));

		customer = dao.byId(Integer.parseInt(customerId.toString()));
		studio = daoStudio.byId(studioId);
		if (studio != null && studio.getAddress() != null
				&& (customer.getAddressTenancy() == null || customer.getAddressTenancy().isEmpty()))
			customer.setAddressTenancy(studio.getDescription() + " - " + studio.getAddress().getDescription());

		if (customer == null)
			customer = new Customer();

		customer.setStudio(studio);

		users = daoUser.list();

	}

	public void preparAdd(ActionEvent event) {

		oldCustomer = customer;
		oldCustomer.setStatus(0);

		customer = new Customer();
		User u = (User) SessionControl.getSessionAttribute(Constants.USER_LOGGED);

		customer.setAgent(u.getLogin());
		customer.setDateAgentSave(new Date());
		customer.setStudio(studio);
		if (studio != null && studio.getAddress() != null)
			customer.setAddressTenancy(studio.getDescription() + "- " + studio.getAddress().getDescription());

		
		Util.copyInventoryAndServicePayment(oldCustomer, customer);
	}

	public void save(ActionEvent event) {
		User u = (User) SessionControl.getSessionAttribute(Constants.USER_LOGGED);

		customer.setAgent(u.getLogin());
		customer.setDateAgentSave(new Date());
		customer.setStatus(1);
		customer = dao.update(customer);

		if (oldCustomer != null && oldCustomer.getId() != 0) {
			oldCustomer.setStatus(0);
			dao.update(oldCustomer);
			oldCustomer = new Customer();
		}
		
		
		

		int customerId = customer.getId();
		//Integer studioId = customer.getStudio().getId();
		
		//Refresh Objects
		customer = new Customer();

		customer = dao.byId(customerId);
		//studio = daoStudio.byId(studioId);
		
		//customer.setStudio(studio);
		users = daoUser.list();

		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Customer", "Tenant saved!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public CustomerDao getDao() {
		return dao;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StudioDao getDaoStudio() {
		return daoStudio;
	}

	public void setDaoStudio(StudioDao daoStudio) {
		this.daoStudio = daoStudio;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public Customer getOldCustomer() {
		return oldCustomer;
	}

	public void setOldCustomer(Customer oldCustomer) {
		this.oldCustomer = oldCustomer;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public StreamedContent getFile() throws Exception {
		
		InputStream templateStream = this.getClass().getResourceAsStream("../rentBookTemplate.docx");
		
		HashMap<String, String> variables = Util.createRentBookAttributes(customer);

		InputStream download = Util.createRentBook(templateStream, variables);

		//file = new DefaultStreamedContent(download, "application/doc", "RentBook - "+customer.getName()+".docx");
		
		return this.file;
	}

}
