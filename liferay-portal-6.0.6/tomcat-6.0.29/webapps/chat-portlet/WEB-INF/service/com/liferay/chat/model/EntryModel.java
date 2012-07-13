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

package com.liferay.chat.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Entry service. Represents a row in the &quot;Chat_Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.chat.model.impl.EntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.chat.model.impl.EntryImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a entry model instance should use the {@link Entry} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Entry
 * @see com.liferay.chat.model.impl.EntryImpl
 * @see com.liferay.chat.model.impl.EntryModelImpl
 * @generated
 */
public interface EntryModel extends BaseModel<Entry> {
	/**
	 * Gets the primary key of this entry.
	 *
	 * @return the primary key of this entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this entry
	 *
	 * @param pk the primary key of this entry
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the entry id of this entry.
	 *
	 * @return the entry id of this entry
	 */
	public long getEntryId();

	/**
	 * Sets the entry id of this entry.
	 *
	 * @param entryId the entry id of this entry
	 */
	public void setEntryId(long entryId);

	/**
	 * Gets the create date of this entry.
	 *
	 * @return the create date of this entry
	 */
	public long getCreateDate();

	/**
	 * Sets the create date of this entry.
	 *
	 * @param createDate the create date of this entry
	 */
	public void setCreateDate(long createDate);

	/**
	 * Gets the from user id of this entry.
	 *
	 * @return the from user id of this entry
	 */
	public long getFromUserId();

	/**
	 * Sets the from user id of this entry.
	 *
	 * @param fromUserId the from user id of this entry
	 */
	public void setFromUserId(long fromUserId);

	/**
	 * Gets the from user uuid of this entry.
	 *
	 * @return the from user uuid of this entry
	 * @throws SystemException if a system exception occurred
	 */
	public String getFromUserUuid() throws SystemException;

	/**
	 * Sets the from user uuid of this entry.
	 *
	 * @param fromUserUuid the from user uuid of this entry
	 */
	public void setFromUserUuid(String fromUserUuid);

	/**
	 * Gets the to user id of this entry.
	 *
	 * @return the to user id of this entry
	 */
	public long getToUserId();

	/**
	 * Sets the to user id of this entry.
	 *
	 * @param toUserId the to user id of this entry
	 */
	public void setToUserId(long toUserId);

	/**
	 * Gets the to user uuid of this entry.
	 *
	 * @return the to user uuid of this entry
	 * @throws SystemException if a system exception occurred
	 */
	public String getToUserUuid() throws SystemException;

	/**
	 * Sets the to user uuid of this entry.
	 *
	 * @param toUserUuid the to user uuid of this entry
	 */
	public void setToUserUuid(String toUserUuid);

	/**
	 * Gets the content of this entry.
	 *
	 * @return the content of this entry
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this entry.
	 *
	 * @param content the content of this entry
	 */
	public void setContent(String content);

	/**
	 * Gets a copy of this entry as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Entry toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Entry entry);

	public int hashCode();

	public String toString();

	public String toXmlString();
}