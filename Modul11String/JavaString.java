package Modul10String;
public class JavaString { 
    public static void main(String[] args) {
    String s1 = new String ("Hello");
    String s2 = new String ("Hello");
    String s3 = "Hi";
    String s4 = "Hi"; 
    System.out.println((s1 == s2));
    System.out.println((s3 == s4)); 
    s3 = s3.intern();
    System.out.println((s3 == s4));
    System.out.println(s1.concat(s4));
    System.out.println(s1.repeat(3));
    System.out.println(s1.replace('e', 'o'));
    System.out.println(s1.substring(3));
    System.out.println(s1.toLowerCase());
    System.out.println(s1.toUpperCase());
    System.out.println(s1.charAt(1));
    System.out.println(s1.indexOf('l'));
    System.out.println(s1.equals(s2));
    System.out.println(s1.compareTo(s2));
    System.out.println(s1.startsWith("He"));
    System.out.println(s1.endsWith("lo")); 
}
}
