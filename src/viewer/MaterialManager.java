package viewer;

import controller.Discount;
import controller.Method;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager  {

    public static void main(String[] args) {

        CrispyFlour flour1 = new CrispyFlour("f1","UsaFlour",LocalDate.of(2021,8,1),100,50);
        CrispyFlour flour2 = new CrispyFlour("f2","VnFlour",LocalDate.of(2021,12,24),80,100);
        CrispyFlour flour3 = new CrispyFlour("f3","ChinaFlour",LocalDate.of(2021,12,3),50,80);
        CrispyFlour flour4 = new CrispyFlour("f4","UkFlour",LocalDate.of(2022,1,30),120,50);
        CrispyFlour flour5 = new CrispyFlour("f5","LaosFlour",LocalDate.of(2022,1,31),45,60);

        Meat meat1 = new Meat("m1","WagyuBeef",LocalDate.of(2022,2,24),200,10);
        Meat meat2 = new Meat("m2","KobeBeef",LocalDate.of(2022,2,23),500,3);
        Meat meat3 = new Meat("m3","KuromoBeef",LocalDate.of(2022,2,22),250,8);
        Meat meat4 = new Meat("m4","AusBeef",LocalDate.of(2022,2,25),210,15);
        Meat meat5 = new Meat("m5","VnBeef",LocalDate.of(2022,2,18),150,20);

        ArrayList<Material> materials = new ArrayList<>();
        materials.add(flour1);materials.add(flour2);materials.add(flour3);
        materials.add(flour4);materials.add(flour5);materials.add(meat1);
        materials.add(meat2);materials.add(meat3);materials.add(meat4);
        materials.add(meat5);
        int choice;
        Scanner sc = new Scanner(System.in);
        do {System.out.println("""
                1.Creat new material flour.
                2.Creat new material meat.
                3.Fix information of material.
                4.Delete material.
                5.Get All Real Money of material today.
                6.Get Real Money by ID.
                7.Get Difference Money without Discount of all material today.
                8.Get Difference Money by ID.
                0.Exit!.
                Choose option:""");
             choice = sc.nextInt();
            switch (choice){
                case 1 :
                    Method.addMaterialFlour(materials);
                    System.out.println("Add Flour Success");
                    break;
                case 2 :
                    Method.addMaterialMeat(materials);
                    System.out.println("Add Meat Success");
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter ID to change information of material: ");
                    String id = sc.nextLine();
                    Method.fixInfoMaterialById(id,materials);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter ID to delete material: ");
                    String inputId = sc.nextLine();
                    Method.deleteMaterialById(inputId,materials);
                    break;
                case 5 :
                    Method.getRealMoneyToday(materials);
                    break;
                case 6 :
                    sc.nextLine();
                    System.out.println("Enter ID to display RealMoney of Material to day: ");
                    String materialId = sc.nextLine();
                    Method.getRealMoneyById(materials,materialId);
                    break;
                case 7 :
                    Method.differenceMoneyWithoutDiscount(materials);
                    break;
                case 8 :
                    sc.nextLine();
                    System.out.println("Enter ID to display Difference Money: ");
                    String diffenceId = sc.nextLine();
                    Method.getDifferenceMoneyById(materials,diffenceId);
            }
        }while (choice != 0);
        Method.display(materials);
    }
}
