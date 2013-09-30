/***************************************************************
Filename: UserDao.java
Author: Christian Heckendorf
Created Date: 9/21/13
Purpose: Helper methods to access the User database table
Features: Probably all features
***************************************************************/
package edu.cs673.plm;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.cs673.plm.model.User;
import edu.cs673.plm.model.StatusMessage;

public class UserDao {
	/***************************************************************
	Function name: nameValid
	Author: Christian Heckendorf
	Created Date: 9/21/13
	Purpose: Checks if the name has been used or not
	***************************************************************/
	private static boolean nameValid(EntityManager em, User user){
		if(((Long) em.createQuery("select count(*) from User user").getSingleResult()).intValue()>0)
			return false;
		return true;
	}

	/***************************************************************
	Function name: createUser
	Author: Christian Heckendorf
	Created Date: 9/21/13
	Purpose: Creates an entry in the User table
	***************************************************************/
	public static StatusMessage createUser(Dba dba, User user) {
		EntityManager em = dba.getActiveEm();
		if(nameValid(em,user)){
			em.persist(user);
			return new StatusMessage(0,"Success");
		}
		return new StatusMessage(1,"Invalid Name");
	}

	/***************************************************************
	Function name: getUserId
	Author: Christian Heckendorf
	Created Date: 9/28/13
	Purpose: Finds the User ID for the requested user
	***************************************************************/
	public static long getUserId(Dba dba, User user){
		EntityManager em = dba.getActiveEm();
		Query q = em.createQuery("select user.id from User user where user.name = :name and user.password = :pass")
					.setParameter("name",user.getName())
					.setParameter("pass",user.getPassword());
		try{
			long uid = ((Long)q.getSingleResult()).longValue();
			return uid;
		} catch(Exception e){
			return 0;
		}
	}
}
