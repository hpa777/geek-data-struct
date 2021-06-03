package lesson5;

public class BackpackItem {

    private String name;

    private int cost;

    private int weight;

    public BackpackItem(String name, int weight, int cost) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "BackpackItem{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
