package org.face4j.examples;

import face4j.DefaultFaceClient;
import face4j.FaceClient;
import face4j.exception.FaceClientException;
import face4j.exception.FaceServerException;
import face4j.model.Face;
import face4j.model.Photo;
public class ClientExample 
{
	private static final String API_KEY = "";
	private static final String API_SEC = "";

	private static final String URL_WITH_FACES = "";

	private static final String USER_ID = "a_user_id@yournamespace";

    public static void main(String[] args) throws FaceClientException, FaceServerException
    {
    	FaceClient faceClient = new DefaultFaceClient(API_KEY, API_SEC);
    	
    	/**
    	 * First we detect some faces in a url. This URL has a single face, So we get back one
    	 * Photo object with one Face object in it.
    	 * 
    	 * You can pass more than one URL (comma delimited String) or you can pass an image file    
    	 * 
    	 * @see http://developers.face.com/docs/api/faces-detect/
    	 * @see http://developers.face.com/docs/api/faces-recognize/
    	 */
    	Photo photo = faceClient.detect(URL_WITH_FACES).get(0);
    
    	/*
    	 * Now we pull out the temporary tag and call save with the desired username and label (label can be null)
    	 * IMPORTANT: dont forget the @namespace on the userid! face.com will complain if its not there.
    	 */
    	Face f = photo.getFace();
    	faceClient.saveTags(f.getTID(), USER_ID, "a label");
    	
    	/*
    	 * Let get the training status for this user now. We should see training in progress TRUE
    	 * because we havent called train yet.
    	 */
    	faceClient.status(USER_ID);
    	
    
    	/*
    	 * IMPORTANT: Now we call train on our untrained user. This will commit our saved tag for this user to
    	 * the database so we can recognize them later with 'recognize' calls   
    	 */
    	faceClient.train(USER_ID);
    	
    	/**
    	 * Now we can call recognize. Look for any user in our index (we only have one now)
    	 * We should see a guess now
    	 */
    	photo = faceClient.recognize(URL_WITH_FACES, "all@yournamespace").get(0);
    }
}