package sample.views;

import sample.controllers.Menu;
import sample.controllers.StudentMountainList;
import sample.models.I_List;
import sample.models.I_Menu;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class MountainHikingManagement {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1. Add new product");
        menu.addItem("2. Display");
        menu.addItem("3. Save file");
        menu.addItem("4. Delete a product");
//        menu.addItem("4. Sort list");
//        menu.addItem("5. abc");
//        menu.addItem("6. def");
        menu.addItem("4: Quit");
        int choice;
        boolean cont = true;
        I_List list = new StudentMountainList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    
                    list.create();
//                    list.output();
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.saveToFile("studentMountainList.bin");
                    break;
//                case 4:
//                    list.sort();
//                    list.output();
//                    break;
                
                    
                case 4:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    if (cont == true) {
                        cont = false;
                    }
                    break;
            }
        } while (choice >= 0 && choice <= 7 && cont);
    }
}
