package controll;

import java.io.IOException;

public interface ISteamController {

	public void escreveArquivo(String ano, String mes, String path, String arquivo) throws IOException;
	public void leArquivo(String ano, String mes, double mediaUser, String path, String arquivo) throws IOException;
	
	
	
}
