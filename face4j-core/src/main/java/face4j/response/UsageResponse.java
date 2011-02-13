package face4j.response;

import java.util.Date;

public interface UsageResponse
{

	public int getUsed ();

	public int getRemaining ();

	public int getLimit ();

	public String getRestTimeString ();

	public Date getResetDate ();

}