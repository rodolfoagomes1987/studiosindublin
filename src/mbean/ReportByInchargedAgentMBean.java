package mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import commun.SessionControl;
import dao.CustomerDao;
import model.Customer;
import model.User;
import util.Constants;

@ManagedBean
@RequestScoped
public class ReportByInchargedAgentMBean {

	private CustomerDao dao = new CustomerDao();
	private DataModel<Customer> customers = new ArrayDataModel<Customer>();
	public List<Customer> listCustomer = new ArrayList<Customer>();

	public DataModel<Customer> getCustomers() {

		int count = 0;
		String lastLogin = "";
		List<Customer> listCustomer2 = getListCustomer();
		for (Customer c : listCustomer2) {
			count++;
			if (c.getUser() != null && !lastLogin.isEmpty() && c.getUser().getLogin().equals(lastLogin)) {

				c.setCountLineUser(count);

			} else {
				count = 1;
				c.setCountLineUser(count);
				lastLogin = c.getUser().getLogin();

			}
		}
		customers = new ListDataModel<Customer>(listCustomer2);
		return customers;
	}

	public void setcustomers(DataModel<Customer> dm) {
		customers = dm;
	}

	public CustomerDao getDao() {
		return dao;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	public void setCustomeres(DataModel<Customer> customers) {
		this.customers = customers;
	}

	public void setCustomers(DataModel<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getListCustomer() {
		User user = getUserLogged();
		if (user.getProfile().equals("ADMIN")) {
			listCustomer = dao.listByInchargedAgent();
		} else {
			listCustomer = dao.listByInchargedAgentByUser(user);
		}
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public User getUserLogged() {
		User userLogged = (User) SessionControl.getSessionAttribute(Constants.USER_LOGGED);
		return userLogged;
	}

}
