package lesson5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class TestBackpack {

    private final int backpackWeight;

    private List<BackpackItem> setBackpackItems;

    public TestBackpack(int backpackWeight) {
        this.backpackWeight = backpackWeight;
    }

    public void addBackpackItem(BackpackItem item) {
        if (setBackpackItems == null) {
            setBackpackItems = new ArrayList<>();
        }
        setBackpackItems.add(item);
    }

    private TreeMap<Integer, List<BackpackItem>> results;

    public List<BackpackItem> findOptimalSet() {
        if (setBackpackItems == null) {
            return null;
        }
        this.results = new TreeMap<>();
        find(setBackpackItems.size());
        return this.results.lastEntry().getValue();
    }

    private void find(int length) {
        if (length == 1) {
            return;
        }
        for (int i = 0; i < length; i++) {
            find(length - 1);
            addResult();
            rotate(length);
        }
    }

    private void addResult() {
        List<BackpackItem> result = new LinkedList<>();
        int setWeight = 0;
        int setCost = 0;
        for (BackpackItem setBackpackItem : setBackpackItems) {
            setWeight+= setBackpackItem.getWeight();
            if (setWeight >= backpackWeight) {
                results.put(setCost, result);
                break;
            }
            setCost+= setBackpackItem.getCost();
            result.add(setBackpackItem);
        }
    }

    private void rotate(int length) {
        int pos = setBackpackItems.size() - length;
        BackpackItem temp = setBackpackItems.get(pos);

        for (int i = pos + 1; i < setBackpackItems.size(); i++) {
            setBackpackItems.set(i - 1, setBackpackItems.get(i));
        }
        setBackpackItems.set(setBackpackItems.size() - 1, temp);
    }

}
