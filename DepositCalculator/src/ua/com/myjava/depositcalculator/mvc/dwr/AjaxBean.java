package ua.com.myjava.depositcalculator.mvc.dwr;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.mvc.util.Message;
import ua.com.myjava.depositcalculator.service.BankService;
import ua.com.myjava.depositcalculator.service.exception.BankAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.UserNotLoggedInException;

@SuppressWarnings("serial")
public class AjaxBean implements Serializable {
	private static final Object lock = new Object();
	private Future<BankService> future = null;
	private final ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	private static final String USER_LOGIN_ID = "user.login.id";

	public Message addBank(Bank bank, HttpServletRequest request) throws BankAlreadyExistsException, UserNotLoggedInException, InterruptedException, ExecutionException {
		getBankService(request).addBank(bank, getUserId(request));
		Message message = new Message();
		message.setResponseMessage("Bank successfully added");
		message.setStatusCode("0");
		return message;
	}

	private BankService getBankService(final HttpServletRequest request) throws InterruptedException,
			ExecutionException {
		synchronized (lock) {
			if (future == null) {
				future = executor.submit(new Callable<BankService>() {
					@Override
					public BankService call() throws Exception {
						ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request
								.getSession().getServletContext());
						return (BankService) context.getBean("bankService");
					}
				});
			}
		}
		return future.get();
	}

	@SuppressWarnings("rawtypes")
	private String getUserId(HttpServletRequest request) {
		return (String) ((Map) request.getAttribute(PortletRequest.USER_INFO)).get(USER_LOGIN_ID);
	}
}
