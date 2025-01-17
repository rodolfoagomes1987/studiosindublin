package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.UserDao;
import model.User;

@FacesConverter("userConverter")
public class UserConverter implements Converter {

	UserDao dao = new UserDao();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {

			return dao.byLogin(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof User) {
			User user = (User) value;
			return String.valueOf(user.getLogin());
		}
		return "";
	}

}
