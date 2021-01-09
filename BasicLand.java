public class BasicLand extends Card{


	protected Integer cardQuantity;

	public BasicLand(){
	}


	public BasicLand(String name, Integer quantity, Integer commanderKey){

		this.name = name;
		this.cardQuantity = quantity;
		this.decks.add(commanderKey);


	}

}