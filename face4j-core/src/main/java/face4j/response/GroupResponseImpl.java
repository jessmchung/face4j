/*
 * Copyright (c) 2010 Marlon Hendred
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package face4j.response;

import static face4j.response.ResponseHelper.toGroupList;
import static face4j.response.ResponseHelper.toPhotoList;

import java.util.List;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import face4j.exception.FaceClientException;
import face4j.model.Group;
import face4j.model.Photo;

public final class GroupResponseImpl extends AbstractResponse implements GroupResponse
{
	private static final Logger logger = LoggerFactory.getLogger(GroupResponse.class);
	
	private final List<Group> groups;
	
	private final List<Photo> photos;
	
	public GroupResponseImpl(String json) throws FaceClientException
	{
		super(json);
		
		try
		{
			groups = toGroupList(response.getJSONArray("groups"));
			photos = toPhotoList(response.getJSONArray("photos"));
			
			if (logger.isDebugEnabled())
			{
				logger.debug(toString());
			}
		}
		
		catch (JSONException jex)
		{
			throw new FaceClientException(jex);
		}
	}

	public List<Group> getGroups ()
	{
		return groups;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.face.api.client.response.PhotoReponse#getPhotos()
	 */
	public List<Photo> getPhotos ()
	{
		return photos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.face.api.client.response.PhotoReponse#getPhoto()
	 */
	public Photo getPhoto ()
	{
		try
		{
			return photos.get(0);
		}
		
		catch (IndexOutOfBoundsException ioob)
		{
			if (logger.isInfoEnabled())
			{
				logger.info("No photos...");
			}
			
			return null;
		}
	}

	public String toString ()
	{
		return super.toString();
	}
}