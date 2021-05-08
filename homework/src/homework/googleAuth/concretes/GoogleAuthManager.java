package homework.googleAuth.concretes;

import homework.entities.concretes.User;
import homework.googleAuth.abstracts.GoogleAuthService;

public class GoogleAuthManager implements GoogleAuthService{

	@Override
	public void register(User user) {
		System.out.println("Google hasabýnýz ile giriþ saðlandý");
		
	}

	@Override
	public void login(User user) {
		System.out.println("Google hesabýnýz ile kayýt gerçekleþtirildi");		
	}

}
