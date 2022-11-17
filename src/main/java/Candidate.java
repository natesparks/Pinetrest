
//Candidate to be the daily best image
public class Candidate {
	int imageID;
	int numVotes;
	public Candidate(int imageID, int numVotes) {
		super();
		this.imageID = imageID;
		this.numVotes = numVotes;
	}
	public int getImageID() {
		return imageID;
	}
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}
	public int getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	
	public void addOneVote() {
		this.numVotes += 1;
	}
}
