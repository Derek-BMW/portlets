<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:actionURL name="savePreferences" var="savePreferencesURL" />
<c:set var="namespace" value="<portlet:namespace />" />
<form:form name="#{namespace}savePreferencesForm" method="post"
	action='${savePreferencesURL}' commandName="preferencesData"
	enctype="application/x-www-form-urlencoded">
	<table>
		<tr>
			<td><a class="anchor" href='#{addBankURL}'> <b><fmt:message
							key="label.returnToBanksPage" /></b>
			</a></td>
		</tr>
		<tr>
			<td><font style="color: #C11B17;"> <form:errors />
			</font></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><fmt:message key="label.minPercent" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="minPercent" /></td>
			<td><font style="color: #C11B17;"><form:errors
						path="minPercent" /></font></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit"
				value="<fmt:message key="label.save" />" /></td>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
