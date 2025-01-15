/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Map;

/**
 *
 * @author ADD
 */
public class StudentManager {
    public Map<String,Student>StudentList;

    public StudentManager() {
    }

    public StudentManager(Map<String, Student> StudentList) {
        this.StudentList = StudentList;
    }
    
    
    
}
