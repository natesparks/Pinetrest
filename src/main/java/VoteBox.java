import java.util.ArrayList;

//VoteBox is designed to handle the votes for each of the 3 candidates for best daily image.
//VoteBox should be accessed by via ajax/servlet handling a request to add a vote to a candidate, or check vote counts. 
//The synchronization of VoteBox is important to prevent multiple ajax/servlet threads (<-these are created automatically by the 
//Servlet class) from accessing the VoteBox at the same time.
public class VoteBox {
	ArrayList<Candidate> candidateList;
	
	
	//Construct the VoteBox from three imageIDs
	public VoteBox(int imageID1, int imageID2, int imageID3) {
		super();
		candidateList.add(new Candidate(imageID1, 0));
		candidateList.add(new Candidate(imageID2, 0));
		candidateList.add(new Candidate(imageID3, 0));
	}

	//Get the votes for a given candidate (0 indexed!)
	public synchronized int getVoteCount(int candidateNum) {
		return candidateList.get(candidateNum).getNumVotes();
	}
	
	//add vote to a given candidate (0 indexed!)
	public synchronized void addVote(int candidateNum) {
		 candidateList.get(candidateNum).addOneVote();
	}
	

	
}
