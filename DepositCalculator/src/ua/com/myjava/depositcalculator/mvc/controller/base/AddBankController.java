package ua.com.myjava.depositcalculator.mvc.controller.base;

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.mvc.form.BankData;
import ua.com.myjava.depositcalculator.service.BankService;
import ua.com.myjava.depositcalculator.service.exception.BankAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.UserNotLoggedInException;

@Controller(value = "addBankController")
@RequestMapping(value = "EDIT")
@SessionAttributes(types = BankData.class)
public class AddBankController {
	private static final String EXCEPTION_BANK_SUBMIT_FAILURE = "exception.bank.submitFailure";
	private static final String USER_LOGIN_ID = "user.login.id";
	@Autowired
	@Qualifier("bankService")
	private BankService bankService;

	@ModelAttribute("bankData")
	public BankData getCommandObject() {
		return new BankData();
	}

	@ModelAttribute("banks")
	public List<Bank> getBanks() {
		return bankService.getBanks();
	}
	
	@RenderMapping
	public String showAddBookForm(RenderRequest request, RenderResponse response) {
		return "addBank";
	}

	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "exception";
	}

	@ActionMapping(value = "addBank")
	public void addBankAction(@Valid @ModelAttribute(value = "bankData") BankData bankData, BindingResult bindingResult,
			ActionRequest request, ActionResponse response, SessionStatus sessionStatus) {
		if (!bindingResult.hasErrors()) {
			addBank(bankData, bindingResult, getUserId(request));
			sessionStatus.setComplete();
		}
		response.setRenderParameter("render", "addBankForm");
	}

	@SuppressWarnings("rawtypes")
	private String getUserId(ActionRequest request) {
		return (String) ((Map) request.getAttribute(PortletRequest.USER_INFO)).get(USER_LOGIN_ID);
	}

	private void addBank(BankData bankData, BindingResult bindingResult, String userId) {
		try {
			bankService.addBank(new Bank(bankData.getTitle(), bankData.getUrl(), bankData.getLogoURL()), userId);
		} catch (BankAlreadyExistsException e) {
			bindingResult.reject(EXCEPTION_BANK_SUBMIT_FAILURE, "Specified bank already exists");
		} catch (UserNotLoggedInException e) {
			bindingResult.reject(EXCEPTION_BANK_SUBMIT_FAILURE, "Adding the bank was not successful");
		}
	}

}
