package Game;

import java.util.Arrays;
import java.util.List;

public class game_item {
	private String[] item = { "Revival", "Shield", "Finder", "HP_Potion" }; // 부활, 1회 보호, 지뢰 파인더

	private List<String> itemList = Arrays.asList(item);

	public List<String> getItemList() {
		return this.itemList;
	}

	public game_item() {

	}

}
