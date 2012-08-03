package ua.com.myjava.depositcalculator.mvc.controller;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.model.Deposit;
import ua.com.myjava.depositcalculator.mvc.form.DepositData;
import ua.com.myjava.depositcalculator.service.BankService;
import ua.com.myjava.depositcalculator.service.exception.DepositAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.UserNotLoggedInException;

@Controller(value = "addDepositController")
@RequestMapping(value = "EDIT")
@SessionAttributes(types = { DepositData.class, Bank.class })
public class AddDepositController {
	private static final String USER_LOGIN_ID = "user.login.id";
	@Autowired
	@Qualifier("bankService")
	private BankService bankService;

	@ModelAttribute("deposit")
	public DepositData getCommandObject() {
		return new DepositData();
	}

	@ModelAttribute("bank")
	public Bank getBank(@RequestParam long bankId) {
		return bankService.findBankById(bankId);
	}

	@RenderMapping(params = "render=addDepositForm")
	public String showAddDepositForm(RenderResponse response) {
		return "addDeposit";
	}

	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "exception";
	}

	@ActionMapping(value = "addDeposit")
	public void addDepositAction(@Valid @ModelAttribute(value = "deposit") DepositData depositData,
			@ModelAttribute(value = "bank") Bank bank, BindingResult bindingResult, ActionRequest request,
			ActionResponse response, SessionStatus sessionStatus) throws DepositAlreadyExistsException,
			UserNotLoggedInException {
		if (!bindingResult.hasErrors()) {
			bankService.addBankDeposit(
					new Deposit.DepositBuilder().forBank(bank).withTitle(depositData.getTitle())
							.forPeriod(Integer.parseInt(depositData.getPeriod()))
							.withPercent(Double.parseDouble(depositData.getPercent())).create(), getUserId(request));
			response.setRenderParameter("bankId", bank.getId().toString());
			sessionStatus.setComplete();
		} else {
			response.setRenderParameter("bankId", bank.getId().toString());
			response.setRenderParameter("render", "addDepositForm");
		}
	}

	@SuppressWarnings("rawtypes")
	private String getUserId(ActionRequest request) {
		return (String) ((Map) request.getAttribute(PortletRequest.USER_INFO)).get(USER_LOGIN_ID);
	}
}
