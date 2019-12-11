package Game;

import java.util.Arrays;
import java.util.List;

public class game_item {
	private String[] item = { "HP_Potion", "Finder" }; // 부활, 1회 보호, 지뢰 파인더

	List<String> itemList = Arrays.asList(item);

	public List<String> getItemList() {
		return this.itemList;
	}

	public game_item() {

	}

}
