package in.dharamshala.booking.dao;

import java.util.List;

import in.dharamshala.booking.model.UserProfile;

/**
 * 
 * @author anshujai
 *
 */
public interface UserProfileDao {

	List<UserProfile> findAll();
	UserProfile findByType(String type);
	UserProfile findById(int id);
}
