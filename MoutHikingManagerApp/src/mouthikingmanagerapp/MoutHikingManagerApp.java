/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouthikingmanagerapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author ADD
 */
public class MoutHikingManagerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File dir = new File("Mount");
        dir.mkdir();
        File file =  new File("Mount/code.txt");
        FileReader fileReader= new FileReader(file);
    }
    
}
