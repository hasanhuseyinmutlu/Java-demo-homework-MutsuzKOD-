package homework.core.abstracts;

import homework.entities.concretes.User;

public interface BaseAccountService {
	void login(User user);
	void register(User user);
}
