package homework.business.concretes;

import homework.business.abstracts.AuthService;
import homework.business.abstracts.UserService;
import homework.business.validation.concretes.LoginValidation;
import homework.business.validation.concretes.RegisterValidation;
import homework.core.abstracts.BaseAccountService;
import homework.entities.concretes.User;

public class AuthManager implements AuthService{

	private UserService userService;
	private BaseAccountService baseAccountsService;

	public AuthManager(UserService userService, BaseAccountService baseAccountsService) {
		this.userService = userService;
		this.baseAccountsService = baseAccountsService;
	}

	@Override
	public void register(User user) {
		boolean checkValid = RegisterValidation.checkFormValid(user);
		if (!checkValid) {
			return;
		}

		boolean userExists = checkIfEmailExists(user.getEmail());
		if (!userExists) {
			System.out.println("Bu email sisteme kayıtlı!");
			return;
		}
		userService.add(user);
		user.setConfirmVerificationCode("RANDOMNUMBER");
		System.out.println("Kayıt başarıyla gerçekleştirildi, email adresinizi kontrol edin.");
	}

	@Override
	public void login(User user) {
		boolean checkValid = LoginValidation.checkFormValid(user);
		if (!checkValid) {
			System.out.println("Giriş formu eksik bilgiler içeriyor.");
			return;
		}

		if (!user.checkVerificationCode()) {
			System.out.println("Mail adresinize gönderilen bağlantı linki ile emailinizi doğrulayın.");
			return;
		}

		System.out.println("Ana sayfaya yönlendiriliyorsunuz.Lütfen bekleyiniz.");
	}

	public void registerGoogleService(User user) {

		boolean checkValid = RegisterValidation.checkFormValid(user);
		if (!checkValid) {
			return;
		}

		boolean userExists = checkIfEmailExists(user.getEmail());
		if (!userExists) {
			System.out.println("email adrese kayıtlı lütfen farklı bi email deneyin.");
			return;
		}

		user.setConfirmVerificationCode("RANDOM NUMBER");
		System.out.println("E-Postanýza gönderilen doðrulama linki ile hesabınızı aktifleştirin.");
		this.baseAccountsService.register(user);
	}

	public void loginGoogleService(User user) {

		boolean checkValid = LoginValidation.checkFormValid(user);
		if (!checkValid) {
			System.out.println("form eksik.");
			return;
		}

		if (!user.checkVerificationCode()) {
			System.out.println("Aktivasyon kodu geçersiz");
			return;
		}

		this.baseAccountsService.login(user);
	}

	private boolean checkIfEmailExists(String email) {
		User result = userService.getByEmail(email);
		System.out.println(result.getEmail());
		if (result.getEmail()== null) {
			return true;
		}

		return false;
	}

}
