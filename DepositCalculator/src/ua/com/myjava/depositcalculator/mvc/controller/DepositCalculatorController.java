package ua.com.myjava.depositcalculator.mvc.controller;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import ua.com.myjava.depositcalculator.mvc.form.InterestRequestData;
import ua.com.myjava.depositcalculator.service.InterestService;

@Controller(value = "depositCalculatorController")
@RequestMapping(value = "VIEW")
@SessionAttributes(value = "form")
public class DepositCalculatorController {
	@Autowired
	@Qualifier("interestService")
	private InterestService interestService;

	@ModelAttribute(value = "form")
	public InterestRequestData getForm() {
		return new InterestRequestData();
	}

	@ActionMapping("calculateInterests")
	public void calculateInterests(@Valid @ModelAttribute("form") InterestRequestData form,
			BindingResult bindingResult, PortletRequest request) {
		if (bindingResult.hasErrors()) {
			return;
		}
		request.setAttribute("interests",
				interestService.calcDepositInterestForPeriodInMonths(form.getSumAsDouble(), form.getPeriodAsInt()));
	}

	@RenderMapping
	public String showInterests(RenderRequest request, RenderResponse response) throws Exception {
		return "depositCalculator";
	}
}
