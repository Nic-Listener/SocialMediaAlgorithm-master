/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
public class SistemaImagens {
    private Random random;
    private ArrayList<Image> lista;
    
    public SistemaImagens(){
        Set<Integer> numeros = new HashSet<Integer>();
        
        while (numeros.size() < 5) {
            numeros.add(random.nextInt(7));
        }
        
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>(numeros);
        System.out.println(listaNumeros);
        
        ImageIcon imgg = new ImageIcon(getClass().getResource("/Images/esportes/basquete.jpg"));
        Image img = imgg.getImage().getScaledInstance(100, 149, Image.SCALE_DEFAULT);
        
        this.lista.add(img);
        
    }
    
    
    
}
