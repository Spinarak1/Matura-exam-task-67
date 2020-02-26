import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] argc)throws Exception{
        zad671();
        zad673(40);
        fraktalSize(40);
        new Main();
    }
    public static void zad671(){
        System.out.println(fibr(10));
        System.out.println(fibr(20));
        System.out.println(fibr(30));
        System.out.println(fibr(40));
        System.out.println(fibi(10));
        System.out.println(fibi(20));
        System.out.println(fibi(30));
        System.out.println(fibi(40));
    }
    public static long fibr(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        else
            return fibr(n-1) + fibr(n-2);
    }
    public static long fibi(int n){
        long suma = 0;
        long f1 = 0;
        long f2 = 1;
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
            for (int i = 2; i <= n; i++) {
                suma = f1 + f2;
                f1 = f2;
                f2 = suma;
            }
            return suma;
    }
    public static long[] tabGenerate(int n){
        long[] tab = new long[n + 1];
        tab[0] = 0;
        if(n > 0) {
            tab[1] = 1;
            for (int i = 2; i <= n; i++) {
                tab[i] = tab[i - 2] + tab[i - 1];
            }
        }
        return tab;
    }
    public static boolean czyPierwsza(long a){
        if(a <= 1)
            return false;
        double pierwiastek = Math.sqrt(a);
        for(int i = 2; i<=pierwiastek; i++){
            if(a % i == 0)
                return false;
        }
        return true;
    }
    public static ArrayList<Long> zad672(int n){
        ArrayList<Long> list = new ArrayList<Long>();
        long[] tab = tabGenerate(40);
        for(int i = 0; i<=n; i++){
            if(czyPierwsza(tab[i]) == true)
                list.add(tab[i]);
        }
        return list;
    }
    public static String longToBinary(long a, int minBits){
        int reszta = 0;
        String binarna = "";
        int roznica = 0;
        while(a != 0) {
            reszta = (int)(a % 2);
            a = a / 2;
            binarna += reszta;
        }
        //minBits = minBits + binarna.length();
        if(binarna.length() < minBits)
            roznica = minBits - binarna.length();
            while(roznica != 0){
                binarna += "0";
                roznica--;
            }
        return new StringBuilder(binarna).reverse().toString();
    }
    public static void zad673(int n)throws Exception{
        int[] size = fraktalSize(n);
        //System.out.println(tab[n]);
        BufferedImage bufferedImage = new BufferedImage(size[0], size[1] - 1, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        long tab[] = tabGenerate(n);
        int dlugosc = longToBinary(tab[n], 0).length();
        String[] binaryTab = new String[size[1]];
        for(int i=1; i<=n; i++){
            binaryTab[i] = longToBinary(tab[i], dlugosc);
            System.out.println(binaryTab[i]);
        }
        for(int i = 1; i<binaryTab.length; i++){
            for(int j = 0; j<binaryTab[i].length(); j++){
                if(binaryTab[i].charAt(j) == '0'){
                    g.setColor(Color.white);
                    g.fillRect(j, i - 1, 1, 1);
                }
                else{
                    g.setColor(Color.black);
                    g.fillRect(j, i - 1, 1, 1);
                }
            }
        }
        ImageIO.write(bufferedImage, "png", new File("C:\\Users\\Spinarak\\Desktop\\new1.png"));
    }
    public static int[] fraktalSize(int n){
        int tab[] = new int[2];
        long tab1[] = tabGenerate(n);
        tab[0] = longToBinary(tab1[n], 0).length();
        tab[1] = tab1.length;
        System.out.println(tab[0]+"\n"+tab[1]);
        return tab;
    }
    public static void createImage()throws Exception{
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.blue);
        g.fillRect(0 , 0, 100, 100);
        g.setColor(Color.black);
        g.fillRect(0, 0, 50, 50);
        ImageIO.write(bufferedImage, "png", new File("C:\\Users\\Spinarak\\Desktop\\new.png"));
    }

}
//utworzyc obrazek w postaci pliku graficznego, utworzyc fraktal, obliczyc wymiar obrazka, Canvas
//sprawdzic blad