package in.dharamshala.booking.dao;

import java.util.List;

import in.dharamshala.booking.model.User;


/**
 * 
 * @author anshujai
 *
 */
public interface UserDao {

	User findById(int id);
	User findBySSO(String sso);
	void save(User user);
	void deleteBySSO(String sso);
	List<User> findAllUsers();

}
