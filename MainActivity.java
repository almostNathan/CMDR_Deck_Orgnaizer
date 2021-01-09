import java.util.*;
import java.io.*;

public class MainActivity{

	protected static HashMap<Integer, String> deckHashMap;
	protected static CardList cardList;
	private static Integer currentCommanderKey;

	public MainActivity(){

		deckHashMap = new HashMap<Integer, String>();

		cardList = new CardList();



	}

	public void run(){

		addDeck("testdeck.txt");
		addDeck("testdeck2.txt");
		

		for (Card card : cardList){
			System.out.printf("%-30s", card.getName() );
			ArrayList<Integer> commanderList = card.getCommander();
			for (Integer commander : commanderList){
			System.out.printf(" " + deckHashMap.get(commander) + " ");
			}
			System.out.println("");
		}
	}

	public Integer addNewCommander(String commanderName){

		if (deckHashMap.containsValue(commanderName)){
			return deckHashMap.keySet().stream().filter(
							key -> commanderName.equals(deckHashMap.get(key))).findFirst().get();
	
		}else{
			for (int i = 0; i < 16; i++){
				if (!deckHashMap.containsKey(i)){
					deckHashMap.put(i, commanderName);
					return i;
									}
			}

		}
		return -1;

	}

	public void addCard(String newCard, Integer commanderKey){

		//search list to see if the card already exists in my cardPool
		
		for (Card card : cardList){
			if (card.getName().equals(newCard)){
				cardList.get(cardList.indexOf(card)).addCommander(commanderKey);
				return;
			}
		}

		cardList.add(new Card(newCard, commanderKey));



	}


	public void addDeck(String fileName){

		
		try{
			File deckFile = new File(fileName);
			Scanner myScanner = new Scanner(deckFile);

			while (myScanner.hasNextLine()){
				String line = myScanner.nextLine();
				if (line.contains("CMDR*")){
					String commanderName = line.substring(line.indexOf("*") + 2);
					currentCommanderKey = addNewCommander(commanderName);
				}else if(line.contains("1x")){
					String cardName = line.substring(line.indexOf("x") + 2);
					addCard(cardName, currentCommanderKey);
				}else{
					addBasicLands(line, currentCommanderKey);
				}

			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}




	}

	public void addBasicLands(String line, Integer commanderKey){
		Integer cardQuantity = Integer.parseInt(line.substring(0, line.indexOf("x")));
		String cardName = line.substring(line.indexOf("x") + 2);
		cardList.add(new BasicLand(cardName, cardQuantity, commanderKey));

	}


}