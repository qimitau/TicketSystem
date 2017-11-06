package org.webapp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.core.ServiceUnitService;
import org.core.TicketService;
import org.jpa.domain.Benutzer;
import org.jpa.domain.ServiceUnit;
import org.jpa.domain.Ticket;

public class NewServiceUnitPage extends BaseAdminPage {

	private static final long serialVersionUID = 1L;
	private String details;
	private Ticket ticket;
	private Benutzer benutzer;
	IModel<String> selected;

	@Inject
	ServiceUnitService serviceUnitService;
	@Inject
	TicketService ticketService;

	public NewServiceUnitPage(Ticket ticket, Benutzer benutzer) {
		super();
		this.ticket = ticket;
		this.benutzer = benutzer;
		List<ServiceUnit> serviceUnits = new ArrayList<>();
		List<ServiceUnit> temp = serviceUnitService.findAll();
		if (temp != null) {
			try {
				for (ServiceUnit serviceUnit : temp) {
					if (serviceUnit.getTicket().getId() == ticket.getId()) {
						serviceUnits.add(serviceUnit);
					}
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("unchecked")
		DataView serviceUnitList = new DataView("serviceUnitList", new ListDataProvider(serviceUnits)) {
			@Override
			protected void populateItem(Item item) {
				item.add(new Label("serviceUnitId", ((ServiceUnit) item.getModelObject()).getId()));
				item.add(new Label("serviceUnitText", ((ServiceUnit) item.getModelObject()).getText()));
				// item.add(new Label("ServiceUnitTime", ((ServiceUnit)
				// item.getModelObject()).getTimestampField().toString()));
			}
		};
		add(serviceUnitList);

		Form<Void> newSUForm = new Form<Void>("newSUForm");
		add(newSUForm);
		newSUForm.add(new Label("label1", "for Ticket Nr " + ticket.getId()));
		newSUForm.add(new Label("label2", ticket.getText()));

		TextArea<String> detailsField = new TextArea<String>("details", new PropertyModel<String>(this, "details"));
		newSUForm.add(detailsField);

		Button assignButton = new Button("assignButton") {
			@Override
			public void onSubmit() {
				assignTicket();
			}
		};
		newSUForm.add(assignButton);

		Button saveButton = new Button("saveButton") {
			@Override
			public void onSubmit() {
				saveServiceUnit();
			}
		};
		newSUForm.add(saveButton);

		Button cancelButton = new Button("cancelButton") {
			@Override
			public void onSubmit() {
				setResponsePage(new UebersichtPage(benutzer));
			}
		};
		newSUForm.add(cancelButton);

		selected = new Model<String>();
		RadioGroup group = new RadioGroup("group", selected);
		newSUForm.add(group);
		group.add(new Radio("open", new Model<String>("Open")));
		group.add(new Radio("inProgress", new Model<String>("In progress")));
		group.add(new Radio("done", new Model<String>("Done")));
	}

	private void assignTicket() {
		ticket.setAdmin(benutzer);
		ticketService.update(ticket);
	}

	private void saveServiceUnit() {
		ServiceUnit serviceUnit = new ServiceUnit();
		serviceUnit.setText(details);
		serviceUnit.setTicket(ticket);
		serviceUnitService.insert(serviceUnit);
		ticket.setStatus(selected.getObject());
		ticketService.update(ticket);
		setResponsePage(new NewServiceUnitPage(ticket, benutzer));
	}
}
