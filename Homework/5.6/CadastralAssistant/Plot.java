package CadastralAssistant;

public class Plot {
    final double width;
    final double length;
    final int price;

    public Plot(double width, double length, int price) {
        this.width = width;
        this.length = length;
        this.price = price;
    }

    public double getPriceSquareMeter() {
        return price / (width * length);
    }


}
