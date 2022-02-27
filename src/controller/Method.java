package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Method {
    ArrayList<Material> materials = new ArrayList<>();
    public static void addMaterialFlour(ArrayList<Material> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Material Flour ID: ");
        String materialId = sc.nextLine();
        System.out.println("Enter Material Flour Name: ");
        String materialName = sc.nextLine();
        System.out.println("Enter Material Flour Manufacture(year,month,day): ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println("Enter Material Flour Cost: ");
        int cost = sc.nextInt();
        System.out.println("Enter Material Flour Quantity: ");
        double quantity = sc.nextDouble();
        Material flours = new CrispyFlour(materialId,materialName, LocalDate.of(year,month,day),cost,quantity);
        list.add(flours);
    }
    public static void addMaterialMeat(ArrayList<Material> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Material Meat ID: ");
        String materialId = sc.nextLine();
        System.out.println("Enter Material Meat Name: ");
        String materialName = sc.nextLine();
        System.out.println("Enter Material Meat Manufacture(year,month,day): ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println("Enter Material Meat Cost: ");
        int cost = sc.nextInt();
        System.out.println("Enter Material Meat Weight: ");
        double weight = sc.nextDouble();
        Material meat = new Meat(materialId,materialName, LocalDate.of(year,month,day),cost,weight);
        list.add(meat);
    }
    public static void display(ArrayList<Material> list){
        for(Object m : list){
            System.out.println(m);
        }
    }
    public static void deleteMaterialById(String id, ArrayList<Material> list){
        if (checkIndexById(id,list) != -1){
            list.remove(checkIndexById(id,list));
            System.out.println("Delete Success by ID: " + id );
        } else {
            System.out.println("The ID not found!");
        }
    }
    public static void fixInfoMaterialById(String id,ArrayList<Material> list){
        if (checkIndexById(id,list) != -1){
            int index = checkIndexById(id,list);
            Scanner sc = new Scanner(System.in);
            if (list.get(index) instanceof CrispyFlour){
                System.out.println("Enter new ID :");
                String newID = sc.nextLine();
                list.get(index).setId(newID);
                System.out.println("Enter new Name:");
                String newName = sc.nextLine();
                list.get(index).setName(newName);
                System.out.println("Enter new LocalDate(year,month,day):");
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                list.get(index).setManufacturingDate(year,month,day);
                System.out.println("Enter new Cost:");
                int newCost = sc.nextInt();
                list.get(index).setCost(newCost);
                System.out.println("Enter new Quantity:");
                double newQuantity = sc.nextDouble();
                ((CrispyFlour) list.get(index)).setQuantity(newQuantity);
            } else {
                System.out.println("Enter new ID :");
                String newID = sc.nextLine();
                list.get(index).setId(newID);
                System.out.println("Enter new Name:");
                String newName = sc.nextLine();
                list.get(index).setName(newName);
                System.out.println("Enter new LocalDate(year,month,day):");
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                list.get(index).setManufacturingDate(year,month,day);
                System.out.println("Enter new Cost:");
                int newCost = sc.nextInt();
                list.get(index).setCost(newCost);
                System.out.println("Enter new Weight:");
                double newWeight = sc.nextDouble();
                ((CrispyFlour) list.get(index)).setQuantity(newWeight);
            }
        }
    }
    public static void getRealMoneyToday(ArrayList<Material> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Meat){
                System.out.println(list.get(i).getName() + ": " + ((Meat) list.get(i)).getRealMoney());
            } else {
                System.out.println(list.get(i).getName() + ": " + ((CrispyFlour)list.get(i)).getRealMoney());
            }
        }
    }
    public static void getRealMoneyById(ArrayList<Material> list,String id){
        int index = checkIndexById(id,list);
        if (checkMaterialById(id,list)){
            if (list.get(index)instanceof Meat){
                System.out.println(list.get(index).getName() + ": " + ((Meat) list.get(index)).getRealMoney());
            } else
                System.out.println(list.get(index).getName()+ ": " + ((CrispyFlour)list.get(index)).getRealMoney());
        } else {
            System.out.println("ID NOT FOUND");
        }
    }
    public static void differenceMoneyWithoutDiscount(ArrayList<Material> list){
        for (int i = 0; i < list.size(); i++) {
            double differennceMoney;
            if (list.get(i)instanceof Meat){
                differennceMoney = list.get(i).getAmount() - ((Meat) list.get(i)).getRealMoney();
                System.out.println(list.get(i).getName()+ "Amount: " + list.get(i).getAmount()
                        + ",RealMoney: " + ((Meat) list.get(i)).getRealMoney()
                        + ", Diffence: " + differennceMoney);
            } else {
                differennceMoney = list.get(i).getAmount() - ((CrispyFlour) list.get(i)).getRealMoney();
                System.out.println(list.get(i).getName()+ "Amount: " + list.get(i).getAmount()
                        + ",RealMoney: " + ((CrispyFlour) list.get(i)).getRealMoney()
                        + ", Diffence: " + differennceMoney);
            }
        }
    }
    public static void getDifferenceMoneyById(ArrayList<Material> list , String id){
        int index = checkIndexById(id,list);
        if (checkMaterialById(id,list)){
            if (list.get(index)instanceof Meat){
                double differenceMoney = list.get(index).getAmount() - ((Meat) list.get(index)).getRealMoney();
                System.out.println(list.get(index).getName()+ " Amount: "+ list.get(index).getAmount()
                + ",RealMoney: " + ((Meat) list.get(index)).getRealMoney()+",Difference: "+ differenceMoney);
            } else {
                double differenceMoney = list.get(index).getAmount() - ((CrispyFlour)list.get(index)).getRealMoney();
                System.out.println(list.get(index).getName()+ " Amount: "+ list.get(index).getAmount()
                        + ",RealMoney: " + ((CrispyFlour) list.get(index)).getRealMoney()+",Difference: "+ differenceMoney);
            }
        } else
            System.out.println("ID NOT FOUND");
    }
    public static boolean checkMaterialById(String id, ArrayList<Material> list){
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())){
                check = true;
                return check;
            }
        } return check;
    }
    public static int checkIndexById( String id,ArrayList<Material> materials){
        int index = -1;
        for (int i = 0; i < materials.size() ; i++) {
            if (id.equals(materials.get(i).getId())){
                index = i;
                break;
            }
        } return index;
    }

}
