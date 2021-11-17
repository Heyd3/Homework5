package CadastralAssistant;

public class Deal {
    final double MaxPriceSquareMeter;
    final double MinPriceSquareMeter;
    Plot plot;
    String name;

    public Deal(double maxPriceSquareMeter, double minPriceSquareMeter, Plot plot, String name) {
        MaxPriceSquareMeter = maxPriceSquareMeter;
        MinPriceSquareMeter = minPriceSquareMeter;
        this.plot = plot;
        this.name = name;
    }

    public boolean isHonestyCheck() {
        return
                plot.getPriceSquareMeter() >= MinPriceSquareMeter ||
                        plot.getPriceSquareMeter() <= MaxPriceSquareMeter;
    }

    @Override
    public String toString() {
        return name;
    }
}
