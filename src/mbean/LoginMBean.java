
package mbean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import commun.SessionControl;
import dao.UserDao;
import model.User;
import util.Constants;

@ManagedBean
@SessionScoped
public class LoginMBean {

	UserDao dao = new UserDao();

	private String dsLogin;
	private String dsSenha;
	private User userLogged;

	public LoginMBean() {

	}

	private void addMensagem(Severity tipo, String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "", msg));
	}

	public String editAction() {

		return "/login.xhtml";
	}

	public String validateLogin() {

		userLogged = dao.byLoginAndPAssword(dsLogin, dsSenha);
		String retorno = "start";

		if (userLogged == null) {

			retorno = "login";
			this.addMensagem(FacesMessage.SEVERITY_ERROR, "Access Danied, User or Password invalid!!!");

		} else {
			SessionControl.setSessionAttribute(Constants.USER_LOGGED, userLogged);
			retorno = "start";
		}

		return retorno;
	}

	public void retornar() {
		this.addMensagem(FacesMessage.SEVERITY_INFO, "Operaçaoo realizada com sucesso");

	}

	public String sair() {

		SessionControl.setSessionAttribute(Constants.USER_LOGGED, null);

		/*
		 * FacesContext facesContext = FacesContext.getCurrentInstance(); HttpSession
		 * session = (HttpSession) facesContext.getExternalContext().getSession(true);
		 * session.invalidate();
		 */

		return "sair";
	}

	// action listener event
	public void attrListener(ActionEvent event) {

		String x = (String) event.getComponent().getAttributes().get("actionDsLogin");
		dsLogin = x;
	}

	public String getDsLogin() {
		return dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public User getUserLogged() {
		userLogged = (User) SessionControl.getSessionAttribute(Constants.USER_LOGGED);
		return userLogged;
	}

}