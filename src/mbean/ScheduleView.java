package mbean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import dao.SchedulingDao;
import model.Scheduling;

@ManagedBean
@SessionScoped
public class ScheduleView implements Serializable {

	private static final long serialVersionUID = 8149012846297170335L;

	private ScheduleModel eventModel;

	private SchedulingDao sdao = new SchedulingDao();

	private Scheduling scheduling = new Scheduling();

	private ScheduleEvent event = new DefaultScheduleEvent();
	
	public ScheduleView(){
		init();
		
	}

	
	public void init() {

		List<Scheduling> listScheduling = sdao.list();

		eventModel = new DefaultScheduleModel();

		for (Scheduling scheduling : listScheduling) {

			String address = scheduling.getAddress();
			String serviceDescription = scheduling.getServiceDescription();

			ScheduleEvent eventTemp = new DefaultScheduleEvent("  " + address + " -> " + serviceDescription,
					scheduling.getDateStart(), scheduling.getDateEnd(), scheduling.getId());

			eventModel.addEvent(eventTemp);

		}

	}
	

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void deleteEvent(ActionEvent actionEvent) {

		FacesMessage message = null;

		if (null != event.getData() && !event.getData().toString().isEmpty()) {

			sdao.delete(Integer.parseInt(event.getData().toString()));

			eventModel.deleteEvent(event);

			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Event deleted!!!");
		} else {

			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: INTERNAL ERROR",
					"VALIDATION, New event can not be deleted!!!");

		}

		event = new DefaultScheduleEvent();
		scheduling = new Scheduling();

		addMessage(message);

	}

	public void addEvent(ActionEvent actionEvent) {

		FacesMessage message = null;
		DefaultScheduleEvent eventTemp = (DefaultScheduleEvent) event;
		String title = null;

		if (null == scheduling.getAddress() || null == scheduling.getServiceDescription()
				|| scheduling.getAddress().isEmpty() || scheduling.getServiceDescription().isEmpty()) {

			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ADDRESS AND SERVICE",
					"Event NOT SAVED, Address and Service CAN NOT be null!!!");
		} else {

			title = scheduling.getAddress();
			title += " -> " + scheduling.getServiceDescription();

			eventTemp.setTitle(title);

			try {

				eventTemp.setStartDate(scheduling.getDateStart());
				eventTemp.setEndDate(scheduling.getDateEnd());

				if (event.getId() == null) {

					sdao.persist(scheduling);
					eventTemp.setData(scheduling.getId());
					eventModel.addEvent(eventTemp);
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "New event saveed!!!");

				} else {

					scheduling.setId(Integer.parseInt(eventTemp.getData().toString()));
					sdao.update(scheduling);
					eventModel.updateEvent(eventTemp);

					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Event updated!!!");
				}

			} catch (Exception e) {

				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: INTERNAL ERROR",
						"Event NOT SAVED, contact the System Admin!!!");

			}
			
			
		}

		event = new DefaultScheduleEvent();
		scheduling = new Scheduling();

		addMessage(message);

	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = null;
		scheduling = new Scheduling();

		event = (ScheduleEvent) selectEvent.getObject();

		scheduling.setDateStart(event.getStartDate());
		scheduling.setDateEnd(event.getEndDate());

		String[] titleList = event.getTitle().split(" -> ");

		scheduling.setAddress(titleList[0]);
		scheduling.setServiceDescription(titleList[1]);

		scheduling.setIsfullday(event.isAllDay() ? 1 : 0);

	}

	public void onDateSelect(SelectEvent selectEvent) {

		Calendar c = Calendar.getInstance();

		c.setTime((Date) selectEvent.getObject());

		c.set(Calendar.HOUR_OF_DAY, 8);

		scheduling = new Scheduling();
		scheduling.setDateStart(c.getTime());
		scheduling.setDateEnd(c.getTime());
		event = new DefaultScheduleEvent("", c.getTime(), c.getTime());
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public SchedulingDao getSdao() {
		return sdao;
	}

	public void setSdao(SchedulingDao sdao) {
		this.sdao = sdao;
	}

	public Scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(Scheduling scheduling) {
		this.scheduling = scheduling;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
