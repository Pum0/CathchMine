package Game;

import java.util.Arrays;
import java.util.List;

public class game_item {
	private String[] item = { "HP_Potion", "Finder" }; // ��Ȱ, 1ȸ ��ȣ, ���� ���δ�

	List<String> itemList = Arrays.asList(item);

	public List<String> getItemList() {
		return this.itemList;
	}

	public game_item() {

	}

}
