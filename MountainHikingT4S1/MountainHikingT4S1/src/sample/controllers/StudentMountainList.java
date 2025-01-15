/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.util.ArrayList;
import java.util.List;
import sample.models.I_List;
import sample.models.Mountain;
import sample.models.Student;
import sample.models.StudentMountain;
import sample.utils.Utils;

/**
 *
 * @author hoadoan
 */
public class StudentMountainList extends ArrayList<StudentMountain> implements I_List {

    @Override
    public boolean create() {
        boolean result = false;
        try {
            boolean checkDuplicate = true;
            Student student = new Student();
            do {
                
//            nhap id: hai ký tự đầu là mã campus, 6 ký tự sau là số
                boolean countinous = true;
                do {
                    String id = Utils.getString("Input Student ID: ");
                    if (Utils.isValidateID(id)) {
                        student.setId(id);
                        countinous = false;
                    }
                } while (countinous);
//            Nhap name từ 2 đến 20 ký tự
                countinous = true;
                do {
                    String name = Utils.getString("Input Student Name: ");
                    if (name.length() > 1 && name.length() < 21) {
                        student.setName(name);
                        countinous = false;
                    }
                } while (countinous);
//            nhap so dien thoai: 10 so
                countinous = true;
                do {
                    String phone = Utils.getString("Input Student phone: ");
                    if (Utils.isValidatePhone(phone)) {
                        student.setPhone(phone);
                        countinous = false;
                    }
                } while (countinous);
//            Nhập email
                countinous = true;
                do {
                    String email = Utils.getString("Input Student êmail: ");
                    if (Utils.isValidateEmail(email)) {
                        student.setEmail(email);
                        countinous = false;
                    }
                } while (countinous);
                if (this.indexOf(new StudentMountain(student)) == -1) {
                    checkDuplicate = false;
                } else {
                    System.out.println("Duplicate Student roi !");
                }
            } while (checkDuplicate);
//            tới đây là đã nhập xong sinh viên( sinh viên chưa đăng ký). 
//            load thông tin núi từ file 
            ArrayList<Object> listMountain = Utils.readListOjectFromFile("mountainList.bin");
            boolean countinous = true;
            String mountainCode = "";
            do {
                mountainCode = Utils.getString("Input mountain code:");
                if (listMountain.indexOf(new Mountain(mountainCode)) != -1) {
                    countinous = false;
                }
            } while (countinous);
            double fee= Utils.BASE_FEE;
            String first3Character=student.getPhone().substring(0, 3);
            if(first3Character.equals("098")|| first3Character.equals("097")
                    ||first3Character.equals("090")||first3Character.equals("091")){
                fee= Utils.BASE_FEE*Utils.DISCOUNT_FEE/100;
            }
            this.add(new StudentMountain(student, mountainCode, fee));
            result= true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public void remove(){
        
    }
    @Override
    public void display() {
        for (StudentMountain mt : this) {
            System.out.println(mt.toString());
        }
    }

    @Override
    public boolean saveToFile(String path) {
        boolean check= false;
        try {
            Utils.writeListObjectToFile(path, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  check;
    }

}
