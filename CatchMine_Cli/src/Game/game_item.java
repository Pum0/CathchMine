package Game;

import java.util.Arrays;
import java.util.List;

public class game_item {
	private String[] item = { "Revival", "Shield", "Finder", "HP_Potion" }; // ��Ȱ, 1ȸ ��ȣ, ���� ���δ�

	private List<String> itemList = Arrays.asList(item);

	public List<String> getItemList() {
		return this.itemList;
	}

	public game_item() {

	}

}
