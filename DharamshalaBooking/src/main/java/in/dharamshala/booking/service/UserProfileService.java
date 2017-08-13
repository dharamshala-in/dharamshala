package in.dharamshala.booking.service;

import java.util.List;

import in.dharamshala.booking.model.UserProfile;

/**
 * 
 * @author anshujai
 *
 */
public interface UserProfileService {

	UserProfile findById(int id);
	UserProfile findByType(String type);
	List<UserProfile> findAll();
	
}
