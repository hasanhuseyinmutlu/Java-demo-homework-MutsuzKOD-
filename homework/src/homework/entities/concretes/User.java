package homework.entities.concretes;

import homework.entities.abstracts.Entity;
import java.util.regex.*;

public class User implements Entity{
	 private int id;
	 private String fisrtName;
	 private String lastName;
	 private String email;
	 private String password;
	 private String verifictionCode;
	 private String confirmVerificationCode;
	 
	 public User() {
		 
	 }

	public User(int id, String fisrtName, String lastName, String email, String password,String verifictionCode,String confirmVerificationCode) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.verifictionCode = verifictionCode;
		this.confirmVerificationCode = confirmVerificationCode;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		if (fisrtName.length() >= 2) {
			this.fisrtName = fisrtName;
		} else {
			System.out.println("lütfen geçerli bir ad giriniz");
		}
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.length() >=2) {
			this.lastName = lastName;
		} else {
			System.out.println("lütfen geçerli bir soyad giriniz ");
		}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
			this.email = email;
	
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
			this.password = password;
	}

	public String getVerifictionCode() {
		return verifictionCode;
	}

	public void setVerifictionCode(String verifictionCode) {
		this.verifictionCode = verifictionCode;
	}

	public String getConfirmVerificationCode() {
		return confirmVerificationCode;
	}

	public void setConfirmVerificationCode(String confirmVerificationCode) {
		boolean result = this.verifictionCode.equals(confirmVerificationCode);
		if(!result) {
			System.out.println("iþlem baþarýsýz.");
			return;
		} else {
			this.confirmVerificationCode = confirmVerificationCode;
			
			System.out.println("asAktivasyon baþarýyla gerçekleþtirildi.");
		}
	}
	public boolean checkVerificationCode() {
		if(!(this.verifictionCode==null)) {
			return this.verifictionCode.equals(this.confirmVerificationCode);
		}
		return false;
	}
	 
}
