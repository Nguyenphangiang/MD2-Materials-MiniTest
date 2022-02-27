package model;

import controller.Discount;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getRealMoney() {
        double realMoney;
        LocalDate expiriday = getExpiryDate();
        LocalDate discountDay_40 = getExpiryDate().minusMonths(2);
        LocalDate discountDay_20 = getExpiryDate().minusMonths(4);
        LocalDate today = LocalDate.now();
        if(today.isBefore(expiriday)){
            if (today.isAfter(discountDay_20)) {
                if (today.isAfter(discountDay_40)) {
                    realMoney = getAmount() - (getAmount() * 40)/100;
                    return realMoney;
                } else {
                    realMoney = getAmount() - (getAmount() * 20)/100;
                    return realMoney;
                }
            } else {
                realMoney = getAmount() - (getAmount() * 5)/100;
                return realMoney;
            }
        } else {
            System.out.println("OUT OF EXPIRY");
            return realMoney = 0;
        }
    }
    public double getAmount(){
        double result = quantity * getCost();
        return result;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate expiry = getManufacturingDate().plusYears(1);
        return expiry;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +super.toString() +
                " ,quantity=" + quantity +
                '}';
    }
}
