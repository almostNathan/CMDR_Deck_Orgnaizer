import java.util.ArrayList;


public class Card{
	
	protected String name;
	protected ArrayList<Integer> decks = new ArrayList<Integer>();


	public Card(){
		
	}

	public Card(String cardName, Integer commanderValue){
		this.name = cardName;
		this.decks.add(commanderValue);
	}

	public String getName(){
		return this.name;

	}
	public void setName(String cardName){
		this.name = cardName;
	}

	public ArrayList<Integer> getDecks(){
		return this.decks;
	}

	public ArrayList<Integer> getCommander(){
		return decks;
	}

	public void addCommander(Integer commanderValue){
		this.decks.add(commanderValue);
	}

	public void removeCommander(Integer commanderValue){
		decks.remove(commanderValue);
	}		

}