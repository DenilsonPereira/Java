package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSellingItem {

	public void method(ArrayList<Sale> lista) {

		HashMap<Sale, Integer> score = new HashMap<>();
		for (Sale item : lista) {
			if (score.containsKey(item)) {
				score.put(item, score.get(item) + item.getAmount());
			} else {
				score.put(item, item.getAmount());
			}
		}

		Sale bestSellingItem = null;
		int maxCount = 0;
		for (HashMap.Entry<Sale, Integer> entry : score.entrySet()) {
			if (entry.getValue() > maxCount) {
				bestSellingItem = entry.getKey();
				maxCount = entry.getValue();
			}
		}

		System.out.println("The best-selling item is: " + bestSellingItem);
	}
}
