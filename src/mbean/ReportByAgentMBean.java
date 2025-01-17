package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.CustomerDao;
import model.Customer;

@ManagedBean
@RequestScoped
public class ReportByAgentMBean {

	private DataModel<Customer> customers = new ArrayDataModel<Customer>();

	private CustomerDao dao = new CustomerDao();

	public DataModel<Customer> getCustomers() {
		List<Customer> listCustomer = dao.listByAgent();
		customers = new ListDataModel<Customer>(listCustomer);
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

}
