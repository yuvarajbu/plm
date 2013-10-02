/***************************************************************
Filename: RoleDao.java
Author: Christian Heckendorf
Created Date: 9/29/13
Purpose: Accesses the Role entity
Features: None yet
***************************************************************/
package edu.cs673.plm;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.cs673.plm.model.User;
import edu.cs673.plm.model.StatusMessage;

public class RoleDao {
	public static final long ROLE_STAKEHOLDER = 1;
	public static final long ROLE_PROJECT_LEADER = 2;
}
