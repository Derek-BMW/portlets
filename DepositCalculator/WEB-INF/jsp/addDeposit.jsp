<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:actionURL name="addDeposit" var="addDepositURL" />
<c:set var="namespace" value="<portlet:namespace />" />
<form:form name="#{namespace}addDepositForm" method="post"
	action='${addDepositURL}' commandName="deposit"
	enctype="application/x-www-form-urlencoded">
	<input type="hidden" value="${bank.id}" name="bankId" />
	<table>
		<tr>
			<td><a class="anchor"
				href='
				<portlet:renderURL portletMode="edit">
					<portlet:param name="render" value="addBankForm"/>
				</portlet:renderURL>
				'><b><fmt:message
							key="label.returnToBanksPage" /></b></a></td>
		</tr>
		<tr>
			<td><font style="color: #C11B17;"> <form:errors />
			</font></td>
		</tr>
	</table>

	<table>
		<tr>
			<td><fmt:message key="label.title" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="title" /></td>
			<td><font style="color: #C11B17;"><form:errors
						path="title" /></font></td>
		</tr>
		<tr>
			<td><fmt:message key="label.percent" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="percent" /></td>
			<td><font style="color: #C11B17;"><form:errors
						path="percent" /></font></td>
		</tr>
		<tr>
			<td><fmt:message key="label.period" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="period" /></td>
			<td><font style="color: #C11B17;"><form:errors
						path="period" /></font></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit"
				value="<fmt:message key="label.save" />" /></td>
			<td>&nbsp;</td>
		</tr>
	</table>

</form:form>