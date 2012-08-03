<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />

<portlet:actionURL var="calculateInterestsURL" name="calculateInterests" />

<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		oTable = $('#example').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers"
		});
	});
</script>
 
<form:form id="calculateInterestsForm" method="post" commandName="form"
	action="${calculateInterestsURL}">
	<table>
		<tr>
			<td><fmt:message key="label.sum" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="sum" /></td>
			<td><font style="color: #C11B17;"><form:errors path="sum" /></font></td>
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
				value="<fmt:message key="label.calc" />" /></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<br />
	<c:if test="${not empty interests}">
		<table id="example" cellpadding="0" cellspacing="0" border="0"
			class="display">
			<thead>
				<tr>
					<th><fmt:message key="label.bankName" /></th>
					<th><fmt:message key="label.depositName" /></th>
					<th><fmt:message key="label.percent" /></th>
					<th><fmt:message key="label.interest" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="interest" items="${interests}">
					<tr>
						<td valign="top"><c:out value="${interest.bankName}" /></td>
						<td valign="top"><c:out value="${interest.depositName}" /></td>
						<td valign="top"><c:out value="${interest.percent}" /></td>
						<td valign="top"><c:out value="${interest.value}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<br />
	<br />
	<br />
</form:form>
<br></br>