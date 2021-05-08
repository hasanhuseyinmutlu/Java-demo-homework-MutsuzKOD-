package homework;

import homework.business.concretes.AuthManager;
import homework.business.concretes.UserManager;
import homework.core.concretes.GoogleAuthManagerAdapter;
import homework.dataAccess.concretes.HibernateUserDao;
import homework.entities.concretes.User;
import homework.googleAuth.concretes.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
User user = new User(1, "Admin", "Manager", "hasan@gmail.com", "123456", "214", "21324");
		
		UserManager userManager = new UserManager(new HibernateUserDao());
		
		System.out.println("**********************");
		
		AuthManager authManager = new AuthManager(new UserManager(new HibernateUserDao()),new GoogleAuthManagerAdapter());
		authManager.registerGoogleService(user);
		//user.setConfirmVerificationCode("RANDOM NUMBER");
		//authManager.loginGoogleService(user);
	
	}

}
