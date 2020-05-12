import java.util.Base64;

public class TestEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password = "password";
		byte[] encryptedPassword = Base64.getEncoder().encode(password.getBytes());
		String encodedPassword = new String(encryptedPassword);
		
		System.out.println(encodedPassword);
		
		byte[] lvBytes = Base64.getDecoder().decode(encodedPassword.getBytes());
		System.out.println(new String(lvBytes));
		
		
	}

}
