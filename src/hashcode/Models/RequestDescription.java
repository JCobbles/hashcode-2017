package hashcode.Models;

/**
 *
 * @author jacob
 */
public class RequestDescription {

    private int numberOfRequests;
    private int videoId;
    private int endpointId;

    public RequestDescription(int numberOfRequests, int videoId, int endpointId) {
        this.numberOfRequests = numberOfRequests;
        this.videoId = videoId;
        this.endpointId = endpointId;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public int getVideoId() {
        return videoId;
    }

    public int getEndpointId() {
        return endpointId;
    }

    @Override
    public String toString() {
        return "numberOfRequests: " + numberOfRequests + " videoId:" + videoId + " endpointId:" + endpointId;
    }
}
