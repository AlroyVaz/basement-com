/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author User
 */
public class First {
    static Map<String, List<String>> prod;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);;
        String str="",s[];
        List<String> nt, t;
        int prods;
        prod = new HashMap();
        System.out.println("Enter the numer of productions:");
        prods = sc.nextInt();
        for(int i = 0; i < prods; i++){
            str = sc.next();
            prod.put((str.substring(0,str.indexOf(':'))), Arrays.asList(str.substring(str.indexOf(':')+1).split("\\|")));
            
        }
        for(String key: prod.keySet()){
        System.out.println(key + ":" + first(prod.get(key)));
    }
    }
    
    public static List<Character> first(List<String> s){
        List<Character> first = new ArrayList(), temp;
        int e = 0;
        for(String i:s){
            for(Character j:i.toCharArray()){
                if(prod.containsKey(j)){
                    temp = first(prod.get(j));
                    if(temp.remove(new Character('e'))){
                        first.addAll(temp);
                        e++;
                    }
                    else{
                        first.addAll(temp);
                        break;
                    }
                }
                else{
                    first.add(j);
                    break;
                }
            }
            if(e == i.length()){
                first.add('e');
                e = 0;
            }
        }
        return first;
    }
}
