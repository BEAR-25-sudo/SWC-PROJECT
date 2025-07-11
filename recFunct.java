import javax.swing.*;
import java.util.*;
public class recFunct {
    public  static int recFunct(int x, int z){
        if (x == 0 || z == 0)
        return z;
        else if (x < z)
        return x + recFunct(x, z - 1);
        else
        return z + recFunct(x - 1, z);
    }
    
    public static void main(String[] args) {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Enter first Integer: "));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Enter second Integer: "));
        System.out.println("Result: " + recFunct(x, y));
    }
}