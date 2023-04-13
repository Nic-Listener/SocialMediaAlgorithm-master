/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginSystem;

import java.util.ArrayList;

/**
 *
 * @author Vinicius Assis
 */
public class LoginControl {
    ArrayList<Register> users;
    
    public LoginControl(){
        users = new ArrayList<>();    
    }
    
    public void Registering(Register r){
        users.add(r);
    }
   
    public String ShowRegister(){
        
        String register = "";
        for (Register i: users){
            register += i;
        }
        return register;       
    }
    
    public boolean ChechRegister(Register r){
        boolean login = false;
        int found = 0;
        for(Register check:users){
            if(check.getUser().equals(r.getUser()) && check.getPass().equals(r.getPass())){
                System.out.println("ok");
            }
            else{
                found = found +1;               
            }
        }
        if(found == users.size()){
            System.out.println("Nao encontrado");
            login = false;
        }
        else{
            login = true;
        }
        return login;
    }
}

