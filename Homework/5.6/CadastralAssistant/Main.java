package CadastralAssistant;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double a;
        List<Deal>hunestDeals = new ArrayList<>();
        List<Deal>unhunestDeals = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            Deal deal = new Deal(20, 30, new Plot(randomazer(), randomazer(), 1000), "сделка " + i);
            if (deal.isHonestyCheck()){
                hunestDeals.add(deal);
            } else {
                unhunestDeals.add(deal);
            }
        }
        System.out.println("Честные сделки");
        hunestDeals.stream()
                .forEach(System.out::println);

        System.out.println("Нечестные сделки");
        unhunestDeals.stream()
                .forEach(System.out::println);
    }


    public static double randomazer (){
        double a = 1 + Math.random()*10;
        return a;
    }



}
