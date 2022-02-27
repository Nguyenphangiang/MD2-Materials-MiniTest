package model;

import controller.Discount;

import java.time.LocalDate;

public class Meat extends Material implements Discount {

    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        double result;
        LocalDate expiriday = getExpiryDate();
        LocalDate discout_30 = getExpiryDate().minusDays(5);
        LocalDate today = LocalDate.now();
        if (today.isBefore(expiriday)){
            if (today.isAfter(discout_30)){
                result = getAmount() - (getAmount()*30)/100;
                return result;
            } else {
                result = getAmount() - (getAmount()*10)/100;
                return result;
            }
        } else {
            System.out.println("OUT OF EXPIRY");
            return result = 0;
        }
    }

    @Override
    public double getAmount() {
        double result = getCost()* weight;
        return result;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate expiry = getManufacturingDate().plusDays(7);
        return expiry;
    }

    @Override
    public String toString() {
        return "Meat{" + super.toString()+
                " ,weight=" + weight +
                '}';
    }
}
