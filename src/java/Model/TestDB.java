/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TestDB {
    public static void main(String[] args){
        Files f =new Files();
        FilesDAO fdao = new FilesDAO();
        ArrayList<Files> addlist;
        addlist = (ArrayList<Files>)fdao.getFiles("123456");
        System.out.println();
        System.out.println("In the Test class:");
        
        for(int i = 0; i < addlist.size(); i++){
                    System.out.println(addlist.get(i).getFilename());

        }
    }
}
