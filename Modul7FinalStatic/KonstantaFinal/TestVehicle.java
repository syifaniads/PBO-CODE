package Modul7FinalStatic.KonstantaFinal;

public class TestVehicle {
    public static void main(String[] args) {
        System.out.println("Creating a vehicle with a 10,000 kg maximumload.");

        // Vehicle1 vehicle = new Vehicle1();
        Vehicle1 vehicle2 = new Vehicle1(1000);

        System.out.println("Add box #1 (500kg) : " + vehicle2.addBox(500));

        System.out.println("Add box #2 (250kg) : " + vehicle2.addBox(250));

        System.out.println("Add box #3 (5000kg) : " + vehicle2.addBox(5000));

        System.out.println("Add box #4 (4000kg) : " + vehicle2.addBox(4000));

        System.out.println("Add box #5 (300kg) : " + vehicle2.addBox(300));

        System.out.println("Vehicle load is " + vehicle2.getLoad() + "kg");
    }
}
