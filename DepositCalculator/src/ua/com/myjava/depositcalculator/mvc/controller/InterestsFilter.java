package ua.com.myjava.depositcalculator.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

import ua.com.myjava.depositcalculator.service.dto.Interest;

public class InterestsFilter implements RenderFilter {

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain) throws IOException,
			PortletException {
		List<Interest> interests = (List<Interest>) request.getAttribute("interests");
		if (interests != null) {
			request.setAttribute("interests", filterInterestsByMinPercent(interests, getMinPercentFromPreferences(request)));
		}
		chain.doFilter(request, response);
	}

	private double getMinPercentFromPreferences(RenderRequest request) {
		return Double.parseDouble(request.getPreferences().getValue("minPercent", "0"));
	}

	private List<Interest> filterInterestsByMinPercent(List<Interest> interests, double minPercent) {
		List<Interest> filteredInterests = new ArrayList<Interest>();
		for (Interest interest : interests) {
			if (interest.getPercent() > minPercent) {
				filteredInterests.add(interest);
			}
		}
		return filteredInterests;
	}

}
