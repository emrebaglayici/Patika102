package PatikaStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Brands brands=new Brands();
        Notebook notebook=new Notebook();
        MobilePhone mobilePhone=new MobilePhone();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to Patika Store");
        System.out.println("0- Exit");
        System.out.println("1- Notebook Operations");
        System.out.println("2- Mobile Phone Operations");
        System.out.println("3- List brands");
        System.out.print("Your selection : ");
        int selection=scanner.nextInt();

        switch (selection){
            case 0:
                break;
            case 1:
                System.out.println("0- Exit");
                System.out.println("1- List All Notebooks");
                System.out.println("2- Add a notebook");
                System.out.println("3- Remove a notebook with id");
                System.out.println("4- Filter product id");
                System.out.println("5- Filter product brand");
                selection= scanner.nextInt();
                if(selection==0)
                    break;
                else if (selection==1) {
                    notebook.printAllNotebooks();
                    break;
                } else if (selection==2) {
//                    notebook.notebooks();
                    System.out.print("Id : ");
                    int id=scanner.nextInt();
                    System.out.print("Product Name : ");
                    String name=scanner.next();
                    System.out.print("Product Price : ");
                    double price= scanner.nextDouble();
                    System.out.print("Product Brand : ");
                    String brand=scanner.next();
                    System.out.print("Product Storage : ");
                    int storage=scanner.nextInt();
                    System.out.print("Product Inch : ");
                    float inch= scanner.nextFloat();
                    System.out.print("Product Ram : ");
                    int ram=scanner.nextInt();
                    notebook.addNotebook(new Notebook(id,name,price,new Brands(brand),storage,
                            inch,ram));

                    notebook.printAllNotebooks();
                    break;
                } else if (selection==3) {
                    notebook.printAllNotebooks();
                    System.out.println("Enter an id which you want to remove");
                    selection= scanner.nextInt();
                    notebook.removeNotebook(selection);
                    notebook.printAllNotebooks();
                    break;
                } else if (selection==4) {
                    System.out.print("Enter the Id : ");
                    selection=scanner.nextInt();
                    notebook.filterById(selection);
                    break;
                } else if (selection==5) {
                    System.out.print("Enter a brand : ");
                    String selectionBrand=scanner.next();
                    notebook.filterByBrand(selectionBrand);
                    break;
                }


            case 2:
                mobilePhone.printAllMobilePhones();
                break;
            case 3:
                brands.printAllBrand();
                break;
        }


    }
}
