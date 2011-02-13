package face4j.tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public abstract class BaseTest
{
	protected final String twoFaces; 
	
	protected final String train;
	
	protected final String removeTag;
	
	protected final String saveTag;
	
	protected final String status;
	
	public BaseTest() throws IOException
	{
		twoFaces  = getJsonString("/data/photo2faces.json");
		train     = getJsonString("/data/train.json");
		saveTag   = getJsonString("/data/save.json");
		removeTag = getJsonString("/data/remove.json");
		status    = getJsonString("/data/status.json"); 
	}
	
	private String getJsonString(String file) throws IOException
	{
		URL url = BaseTest.class.getResource(file);
		return FileUtils.readFileToString(new File(url.getFile()));
	}
}