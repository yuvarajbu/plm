package edu.cs673.plm;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.cs673.plm.model.User;
import edu.cs673.plm.model.StatusMessage;

public class RoleDao {
	public static final long ROLE_STAKEHOLDER = 1;
	public static final long ROLE_PROJECT_LEADER = 2;
}
