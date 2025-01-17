package commun;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.User;
import util.Constants;

public class SessionControl {

	@SuppressWarnings("unchecked")
	public static void setSessionAttribute(String attributeName, Object attributeValue) {
		try {
			ExternalContext ec = getExternalContext();
			if (ec != null) {
				@SuppressWarnings("rawtypes")
				Map attrMap = ec.getSessionMap();
				if (attrMap != null) {
					attrMap.put(attributeName, attributeValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ExternalContext getExternalContext() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if (facesContext == null) {
				return null;
			} else {
				return facesContext.getExternalContext();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object getSessionAttribute(String attributeName) {
		try {
			ExternalContext ec = getExternalContext();
			if (ec != null) {
				Map attrMap = ec.getSessionMap();
				if (attrMap != null) {
					return attrMap.get(attributeName);
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getProfile() {
		User u = (User) getSessionAttribute(Constants.USER_LOGGED);
		if (u != null)
			return u.getProfile();
		return null;
	}

}
