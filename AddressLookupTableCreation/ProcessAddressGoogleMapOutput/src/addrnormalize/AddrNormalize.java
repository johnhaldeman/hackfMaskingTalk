package addrnormalize;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class AddrNormalize {

	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();
		

		for(int i = 1; i <= 2000; i++){
			FileReader reader = new FileReader("addget\\" + i + ".json");
			GoogleMapAddress addr = gson.fromJson(reader, GoogleMapAddress.class);
			if(addr != null)
				addr.printCSVRows();
			reader.close();
		}
	}

}
