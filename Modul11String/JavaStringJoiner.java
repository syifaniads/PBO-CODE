package Modul10String;
import java.util.StringJoiner;
public class JavaStringJoiner { 
    public static void main(String[] args) { 
        StringJoiner sj = new StringJoiner(",", "{", "}");
        sj.add("USA");
        sj.add("India");
        sj.add("UK");
        System.out.println(sj); 
        StringJoiner sj1 = new StringJoiner("|", "#", "#");
        sj1.add("France");
        sj1.add("Germany");
        System.out.println(sj1);
        sj.merge(sj1);
        System.out.println(sj); 
    }
}