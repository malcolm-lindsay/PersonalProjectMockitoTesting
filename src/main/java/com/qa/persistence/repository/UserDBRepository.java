package com.qa.persistence.repository;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;


public class UserDBRepository implements UserRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> User = (Collection<User>) query.getResultList();
		return util.getJSONForObject(User);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String addUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"User has been successfully added\"}";
	}
	
	
	@Override
	@Transactional(REQUIRED)
	public String updateUser(Long userID, String user) {
		User newUser = util.getObjectForJSON(user, User.class);
		User oldUser = manager.find(User.class, userID);
		
		oldUser.setUserName(newUser.getUserName());
		oldUser.setDietryRequirements(newUser.getDietryRequirements());
		oldUser.setPhoneNumber(newUser.getPhoneNumber());
		oldUser.setAge(newUser.getAge());

		return "{\"message\": \"User sucessfully updated\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteUser(Long userID) {
		if (manager.find(User.class, userID) != null) {
			manager.remove(manager.find(User.class, userID));
			return "{\"message\": \"User sucessfully deleted\"}";
		} else
			return "{\"message\": \"User not found\"}";
	}	
}


