package ua.com.myjava.depositcalculator.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.mvc.form.PreferencesData;
import ua.com.myjava.depositcalculator.service.BankService;

@Controller(value = "addPreferencesController")
@RequestMapping(value = "EDIT")
@SessionAttributes(types = { PreferencesData.class, Bank.class })
public class AddPreferencesController {
	@Autowired
	@Qualifier("bankService")
	private BankService bankService;

	@RenderMapping(params = "render=preferencesForm")
	public String showPrefs(RenderRequest request, RenderResponse response) {
		return "preferences";
	}

	@ModelAttribute("banks")
	public List<Bank> getBanks() {
		return bankService.getBanks();
	}

	@ModelAttribute("preferencesData")
	public PreferencesData getPreferences(PortletRequest request) {
		PreferencesData preferencesData = new PreferencesData();
		preferencesData.setMinPercent(Double.parseDouble(request.getPreferences().getValue("minPercent", "0")));
		return preferencesData;
	}

	@ActionMapping(value = "savePreferences")
	public void savePreferences(ActionRequest request, ActionResponse response,
			@ModelAttribute(value = "preferencesData") PreferencesData preferencesData, SessionStatus sessionStatus)
			throws PortletException, IOException {
		PortletPreferences prefs = request.getPreferences();
		if (preferencesData.getMinPercent() != null) {
			prefs.setValue("minPercent", String.valueOf(preferencesData.getMinPercent()));
		}
		prefs.store();
		sessionStatus.setComplete();
		response.setRenderParameter("render", "addBank");
	}

}
