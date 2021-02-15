package framework.Datadrivern.PropertyFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Write_Data_into_PropertyFiles {

	public static void main(String[] args) throws IOException
	{
	
		
		//Create Repository
		Properties repository=new Properties();
		repository.setProperty("Res1", "TestPass");
		repository.setProperty("Res2", "TestPass");
		repository.setProperty("Res3", "TestFail");
		repository.setProperty("Res4", "TestPass");
		
		
		//Write all runtime properties data into output file
		String filepath="src\\framework\\Datadrivern\\PropertyFiles\\Output.properties";
		FileOutputStream fo=new FileOutputStream(filepath);
		repository.store(fo, "Tc001_login_result");
		

	}

}
