package extend_lib;


public class ValidateEmail {
	public static boolean isEmail(String value){
		if (value.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			return true;
		} else {
			return false;
		}
	}
}
