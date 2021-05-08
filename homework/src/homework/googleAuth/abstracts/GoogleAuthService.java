package homework.googleAuth.abstracts;

import homework.entities.concretes.User;

public interface GoogleAuthService {
	void register(User user);
	void login(User user);
}
