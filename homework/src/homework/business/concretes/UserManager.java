package homework.business.concretes;

import homework.business.abstracts.UserService;
import homework.dataAccess.abstracts.UserDao;
import homework.entities.concretes.User;

public class UserManager implements UserService{


	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		this.userDao.add(user);
		
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Override
	public User getByEmail(String email) {
		for (User user : this.userDao.getAll()) {
			if(user.getEmail()==email) {
				return user;
			}
		}
		return null;
	}
}

	


