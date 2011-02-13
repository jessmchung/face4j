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

package face4j;

/**
 * Holds the path to the resources on api.face.com
 * 
 * @author Marlon Hendred
 *
 */
final class Api 
{
	public static final String RECOGNIZE = "/faces/recognize.json";
	public static final String DETECT    = "/faces/detect.json";
	public static final String GROUP	 = "/faces/group.json";
	public static final String TRAIN     = "/faces/train.json";
	public static final String STATUS    = "/faces/status.json";
		
	public static final String REMOVE_TAGS = "/tags/remove.json";
	public static final String SAVE_TAGS   = "/tags/save.json";
	public static final String GET_TAGS    = "/tags/get.json";
	public static final String ADD_TAG     = "/tags/add.json";
	
	public static final String LIMITS     = "/account/limits.json";
	public static final String NAMESPACES = "/account/namespaces.json";
	public static final String USERS      = "/account/users.json";
	
	public static final String FACEBOOK    = "/facebook/get.json";
	
	private Api () {}
}