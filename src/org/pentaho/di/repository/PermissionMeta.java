 /* Copyright (c) 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the GNU Lesser General Public License, Version 2.1. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.gnu.org/licenses/lgpl-2.1.txt. The Original Code is Pentaho 
 * Data Integration.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the GNU Lesser Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.*/
 
package org.pentaho.di.repository;

import org.pentaho.di.i18n.BaseMessages;


/**
 * This class handles the different kinds of permissions that can be set on a profile.
 * 
 * @author Matt
 * @since 7-apr-2004
 *
 */
public class PermissionMeta 
{
	private static Class<?> PKG = PermissionMeta.class; // for i18n purposes, needed by Translator2!!   $NON-NLS-1$

	private ObjectId id;
	private int  type;
	
	public static final int TYPE_PERMISSION_NONE             = 0;
	public static final int TYPE_PERMISSION_READ_ONLY        = 1;
	public static final int TYPE_PERMISSION_ADMIN            = 2;
	public static final int TYPE_PERMISSION_TRANSFORMATION   = 3;
	public static final int TYPE_PERMISSION_JOB              = 4;
	public static final int TYPE_PERMISSION_SCHEMA           = 5;
	public static final int TYPE_PERMISSION_DATABASE         = 6;
	public static final int TYPE_PERMISSION_EXPLORE_DATABASE = 7;
	
	public static final String permissionTypeCode[] =
		{
			"-",
			"READONLY",
			"ADMIN",
			"TRANS",
			"JOB",
			"SCHEMA",
			"DB",
			"EXPLORE_DB",
		};

	public static final String permissionTypeDesc[] =
	{
		 "-",
		 BaseMessages.getString(PKG, "PermissionMeta.Permission.ReadOnly"),
		 BaseMessages.getString(PKG, "PermissionMeta.Permission.Administrator"),
		 BaseMessages.getString(PKG, "PermissionMeta.Permission.UseTransformations"),
		 BaseMessages.getString(PKG, "PermissionMeta.Permission.UseJobs"),
		 BaseMessages.getString(PKG, "PermissionMeta.Permission.UseSchemas")
	};
	
	public PermissionMeta() {
		this(TYPE_PERMISSION_NONE);
	}
	
	public PermissionMeta(int type)
	{
		this.type = type;
	}

	public PermissionMeta(String stype)
	{
		this.type = getType(stype);
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
	
	public String getTypeDesc()
	{
		return getTypeDesc(type);
	}
	
	public static final String getTypeDesc(int i)
	{
		if (i<0 || i>=permissionTypeCode.length) return null;
		return permissionTypeCode[i];
	}
	
	public static final int getType(String str)
	{
		for (int i=0;i<permissionTypeCode.length;i++)
		{
			if (permissionTypeCode[i].equalsIgnoreCase(str)) return i;
		}
		
		for (int i=0;i<permissionTypeDesc.length;i++)
		{
			if (permissionTypeDesc[i].equalsIgnoreCase(str)) return i;
		}
		
		return TYPE_PERMISSION_NONE;
	}
	
	public ObjectId getObjectId()
	{
		return id;
	}
	
	public void setObjectId(ObjectId id)
	{
		this.id = id;
	}
	
	public boolean isReadonly()
	{
		return type == TYPE_PERMISSION_READ_ONLY;
	}

	public boolean isAdministrator()
	{
		return type == TYPE_PERMISSION_ADMIN;
	}

	public boolean useTransformations()
	{
		return type == TYPE_PERMISSION_TRANSFORMATION;
	}

	public boolean useJobs()
	{
		return type == TYPE_PERMISSION_JOB;
	}

	public boolean useSchemas()
	{
		return type == TYPE_PERMISSION_SCHEMA;
	}

	public boolean useDatabases() 
	{
		return type == TYPE_PERMISSION_DATABASE;
	}

	public boolean exploreDatabases() 
	{
		return type == TYPE_PERMISSION_EXPLORE_DATABASE;
	}
	
	public String toString()
	{
		return getTypeDesc();
	}
}
