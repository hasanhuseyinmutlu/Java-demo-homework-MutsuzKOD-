package homework.googleAuth.concretes;

import homework.entities.concretes.User;
import homework.googleAuth.abstracts.GoogleAuthService;

public class GoogleAuthManager implements GoogleAuthService{

	@Override
	public void register(User user) {
		System.out.println("Google hasab�n�z ile giri� sa�land�");
		
	}

	@Override
	public void login(User user) {
		System.out.println("Google hesab�n�z ile kay�t ger�ekle�tirildi");		
	}

}
