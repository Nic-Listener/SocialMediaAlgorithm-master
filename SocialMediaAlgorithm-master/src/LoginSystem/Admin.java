/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LoginSystem;

/**
 *
 * @author Vinicius Assis
 */
public class Admin { 
    public static void main(String[] args) {
        Register conta1 = new Register("Vinicius", "Assis");
        Register conta2 = new Register("Nicolas","Fernandes");
        Register contateste = new Register("","Assis");
        
        LoginControl cadastrando = new LoginControl();
        cadastrando.Registering(conta1);
        cadastrando.Registering(conta2);
        
        System.out.println(cadastrando.ShowRegister());
        
        System.out.println(cadastrando.ChechRegister(contateste));
    }
    
}
