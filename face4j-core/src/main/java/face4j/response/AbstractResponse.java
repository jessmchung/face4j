package face4j.response;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import face4j.exception.FaceClientException;

abstract class AbstractResponse
{
	protected static final Logger logger = LoggerFactory.getLogger(AbstractResponse.class);;
	
	protected final JSONObject response;
	
	protected AbstractResponse(final String json) throws FaceClientException
	{
		
		
		try 
		{
			response = new JSONObject(json);
			
			if (logger.isDebugEnabled())
			{
				logger.debug("JSON response...");
				logger.debug(response.toString(2));
			}
		}
		
		catch (JSONException jex)
		{
			logger.debug("Caught exception: ", jex.getMessage(), jex);
			throw new FaceClientException(jex);
		}
	}
	
	public String toString ()
	{
		try
		{
			return response.toString(2);
		}
		
		catch (JSONException e)
		{
			return null;
		}
	}
}
