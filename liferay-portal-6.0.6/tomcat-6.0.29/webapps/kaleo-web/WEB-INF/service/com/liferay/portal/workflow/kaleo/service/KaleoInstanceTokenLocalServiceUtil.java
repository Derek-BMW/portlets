/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.workflow.kaleo.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the kaleo instance token local service. This utility wraps {@link com.liferay.portal.workflow.kaleo.service.impl.KaleoInstanceTokenLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.workflow.kaleo.service.impl.KaleoInstanceTokenLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstanceTokenLocalService
 * @see com.liferay.portal.workflow.kaleo.service.base.KaleoInstanceTokenLocalServiceBaseImpl
 * @see com.liferay.portal.workflow.kaleo.service.impl.KaleoInstanceTokenLocalServiceImpl
 * @generated
 */
public class KaleoInstanceTokenLocalServiceUtil {
	/**
	* Adds the kaleo instance token to the database. Also notifies the appropriate model listeners.
	*
	* @param kaleoInstanceToken the kaleo instance token to add
	* @return the kaleo instance token that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken addKaleoInstanceToken(
		com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken kaleoInstanceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addKaleoInstanceToken(kaleoInstanceToken);
	}

	/**
	* Creates a new kaleo instance token with the primary key. Does not add the kaleo instance token to the database.
	*
	* @param kaleoInstanceTokenId the primary key for the new kaleo instance token
	* @return the new kaleo instance token
	*/
	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken createKaleoInstanceToken(
		long kaleoInstanceTokenId) {
		return getService().createKaleoInstanceToken(kaleoInstanceTokenId);
	}

	/**
	* Deletes the kaleo instance token with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kaleoInstanceTokenId the primary key of the kaleo instance token to delete
	* @throws PortalException if a kaleo instance token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteKaleoInstanceToken(long kaleoInstanceTokenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteKaleoInstanceToken(kaleoInstanceTokenId);
	}

	/**
	* Deletes the kaleo instance token from the database. Also notifies the appropriate model listeners.
	*
	* @param kaleoInstanceToken the kaleo instance token to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteKaleoInstanceToken(
		com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken kaleoInstanceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteKaleoInstanceToken(kaleoInstanceToken);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the kaleo instance token with the primary key.
	*
	* @param kaleoInstanceTokenId the primary key of the kaleo instance token to get
	* @return the kaleo instance token
	* @throws PortalException if a kaleo instance token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken getKaleoInstanceToken(
		long kaleoInstanceTokenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getKaleoInstanceToken(kaleoInstanceTokenId);
	}

	/**
	* Gets a range of all the kaleo instance tokens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of kaleo instance tokens to return
	* @param end the upper bound of the range of kaleo instance tokens to return (not inclusive)
	* @return the range of kaleo instance tokens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken> getKaleoInstanceTokens(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKaleoInstanceTokens(start, end);
	}

	/**
	* Gets the number of kaleo instance tokens.
	*
	* @return the number of kaleo instance tokens
	* @throws SystemException if a system exception occurred
	*/
	public static int getKaleoInstanceTokensCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKaleoInstanceTokensCount();
	}

	/**
	* Updates the kaleo instance token in the database. Also notifies the appropriate model listeners.
	*
	* @param kaleoInstanceToken the kaleo instance token to update
	* @return the kaleo instance token that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken updateKaleoInstanceToken(
		com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken kaleoInstanceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKaleoInstanceToken(kaleoInstanceToken);
	}

	/**
	* Updates the kaleo instance token in the database. Also notifies the appropriate model listeners.
	*
	* @param kaleoInstanceToken the kaleo instance token to update
	* @param merge whether to merge the kaleo instance token with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the kaleo instance token that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken updateKaleoInstanceToken(
		com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken kaleoInstanceToken,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKaleoInstanceToken(kaleoInstanceToken, merge);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken addKaleoInstanceToken(
		long parentKaleoInstanceTokenId,
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addKaleoInstanceToken(parentKaleoInstanceTokenId,
			workflowContext, serviceContext);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken completeKaleoInstanceToken(
		long kaleoInstanceTokenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().completeKaleoInstanceToken(kaleoInstanceTokenId);
	}

	public static void deleteCompanyKaleoInstanceTokens(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCompanyKaleoInstanceTokens(companyId);
	}

	public static void deleteKaleoDefinitionKaleoInstanceTokens(
		long kaleoDefinitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteKaleoDefinitionKaleoInstanceTokens(kaleoDefinitionId);
	}

	public static void deleteKaleoInstanceKaleoInstanceTokens(
		long kaleoInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteKaleoInstanceKaleoInstanceTokens(kaleoInstanceId);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken> getKaleoInstanceTokens(
		long parentKaleoInstanceTokenId, java.util.Date completionDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getKaleoInstanceTokens(parentKaleoInstanceTokenId,
			completionDate, serviceContext);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken> getKaleoInstanceTokens(
		long parentKaleoInstanceTokenId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getKaleoInstanceTokens(parentKaleoInstanceTokenId,
			serviceContext);
	}

	public static int getKaleoInstanceTokensCount(
		long parentKaleoInstanceTokenId, java.util.Date completionDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getKaleoInstanceTokensCount(parentKaleoInstanceTokenId,
			completionDate, serviceContext);
	}

	public static int getKaleoInstanceTokensCount(
		long parentKaleoInstanceTokenId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getKaleoInstanceTokensCount(parentKaleoInstanceTokenId,
			serviceContext);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken getRootKaleoInstanceToken(
		long kaleoInstanceId,
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRootKaleoInstanceToken(kaleoInstanceId, workflowContext,
			serviceContext);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken updateKaleoInstanceToken(
		long kaleoInstanceTokenId, long currentKaleoNodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateKaleoInstanceToken(kaleoInstanceTokenId,
			currentKaleoNodeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static KaleoInstanceTokenLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					KaleoInstanceTokenLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new KaleoInstanceTokenLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(KaleoInstanceTokenLocalService service) {
		_service = service;
	}

	private static KaleoInstanceTokenLocalService _service;
}