/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

/**
 *
 * @author jacob
 */
public class RequestDescription {

    public int numberOfRequests, videoId, endpointId;

    public RequestDescription(int numberOfRequests, int videoId, int endpointId) {
        this.numberOfRequests = numberOfRequests;
        this.videoId = videoId;
        this.endpointId = endpointId;
    }
}
