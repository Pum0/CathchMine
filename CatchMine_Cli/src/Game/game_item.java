package Game;

import java.util.Arrays;
import java.util.List;

public class game_item {
	private String[] item = { "Revival", "Shield", "Finder" }; // 부활, 1회 보호, 지뢰 파인더

	private List<String> itemList = Arrays.asList(item);

	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}

}
