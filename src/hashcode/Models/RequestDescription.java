/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.Models;

/**
 *
 * @author jacob
 */
public class RequestDescription {

    public int getNumberOfRequests()
    {
        return numberOfRequests;
    }

    private int numberOfRequests;

    public int getVideoId()
    {
        return videoId;
    }

    private int videoId;

    public int getEndpointId()
    {
        return endpointId;
    }

    private int endpointId;

    public RequestDescription(int numberOfRequests, int videoId, int endpointId) {
        this.numberOfRequests = numberOfRequests;
        this.videoId = videoId;
        this.endpointId = endpointId;
    }

    @Override
    public String toString()
    {
        return "numberOfRequests: " + numberOfRequests + " videoId:" + videoId + " endpointId:" + endpointId;
    }
}
