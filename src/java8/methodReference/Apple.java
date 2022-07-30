package java8.methodReference;

public class Apple {

    private Color color;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
