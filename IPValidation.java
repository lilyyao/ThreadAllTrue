
public class IPValidation {
		
	public boolean validateIP (String IP, int octets_count ) {
		String[] octets = IP.split("\\.");
		
		if (octets.length != octets_count)
				return false;
		
		for (int i = 0; i < octets_count; i++) {
			if (!checkOctet(octets[i]))
				return false;
		}
		
		return true;
	}
	
	
	public boolean checkOctet(String octet) {
		int ip ;
		try {
			ip = Integer.parseInt(octet);
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
				
		if( (ip>255) || (ip<0))
			return false;		
		
		return true;
		
	}

	public static void main(String[] args) {
		
		IPValidation iv = new IPValidation();
		final int OCTETS_COUNT = 4;
//		String IPAddress = args[0];
//		String IPAddress = "1.2.3.4";
		String IPAddress = "1.2..4";
		boolean valid = iv.validateIP(IPAddress, OCTETS_COUNT);

		if (valid)
			System.out.println("Valid IP");
		else
			System.out.println("NOT Valid IP");
	}

	
}
