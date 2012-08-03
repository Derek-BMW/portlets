<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:actionURL name="addBank" var="addBankURL" />
<c:set var="namespace" value="<portlet:namespace />" />
<portlet:renderURL portletMode="edit" var="preferencesURL">
	<portlet:param name="render" value="preferencesForm" />
</portlet:renderURL>
<form:form name="#{namespace}addBankForm" method="post"
	action='${addBankURL}' commandName="bankData"
	enctype="application/x-www-form-urlencoded">
	<table>
		<tr>
			<td><a class="anchor"
				href='<portlet:renderURL portletMode="view"/>'><b><fmt:message
							key="label.returnToMainPage" /></b></a></td>
		</tr>
		<tr>
			<td><a href="${preferencesURL}"><b><fmt:message
							key="label.preferences" /></b></a></td>
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
			<td><form:input path="title" id="${namespace}titleId"/></td>
			<td><font style="color: #C11B17;"><form:errors
						path="title" /></font></td>
		</tr>
		<tr>
			<td><fmt:message key="label.url" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="url" id="${namespace}urlId"/></td>
			<td><font style="color: #C11B17;"><form:errors path="url" /></font></td>
		</tr>
		<tr>
			<td><fmt:message key="label.logoUrl" />:<font
				style="color: #C11B17;">*</font></td>
			<td><form:input path="logoURL" id="${namespace}logoURLId"/></td>
			<td><font style="color: #C11B17;"><form:errors
						path="logoURL" /></font></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit"
				value="<fmt:message key="label.save" />" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2"><a href="#"
				onclick="<portlet:namespace/>addBank('<portlet:namespace/>titleId', '<portlet:namespace/>urlId', 
			'<portlet:namespace/>logoURLId');"><b>Save</b></a>
				<img id="<portlet:namespace/>imageId"
				src="<%=request.getContextPath()%>/images/loading.gif"
				style="visibility: hidden" /></td>
		</tr>
	</table>

</form:form>

<c:if test="${not empty banks}">
	<table id="example" cellpadding="0" cellspacing="0" border="0"
		class="display">
		<thead>
			<tr>
				<th><fmt:message key="label.bankName" /></th>
				<th><fmt:message key="label.url" /></th>
				<th><fmt:message key="label.action" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bank" items="${banks}">
				<tr>
					<td valign="top"><img src="${bank.logoURL}"
						style="float: left; width: 100px;" /> <c:out
							value="${bank.title}" /></td>
					<td valign="top"><a href='<c:out value="${bank.url}" />'>${bank.url}</a></td>
					<td valign="top"><a
						href="
						<portlet:renderURL>
							<portlet:param name="render" value="addDepositForm" />
							<portlet:param name="bankId" value="${bank.id}" />
						</portlet:renderURL>					
					"><b><fmt:message
									key="label.addDeposit" /></b></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<script lang="text/javascript">
function <portlet:namespace/>addBank(titleFieldId,urlFieldId, logoURLFieldId) {
	document.getElementById("<portlet:namespace/>imageId").setAttribute("style", "visibility : visible");
	var bank = {
		title : dwr.util.getValue(titleFieldId),
		url : dwr.util.getValue(urlFieldId),
		logoURL : dwr.util.getValue(logoURLFieldId)
	};
	
	MyAjaxBean.addBank(bank, function(message) {
		document.getElementById("<portlet:namespace/>msg").
		innerHTML = message.responseMessage;
		if(message.statusCode == "1") {
		
		}
		document.getElementById("<portlet:namespace/>imageId").setAttribute("style", "visibility : hidden");
		if(message.statusCode == "0") {
			alert("ok!");
		}
	});
}
</script>
