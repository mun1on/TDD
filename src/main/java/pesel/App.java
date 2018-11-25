package pesel;

public class App {

    public static void main(String[] args) {

        Pesel pesel = new Pesel("93051503219");
        System.out.println("Pesel: "+pesel.getPesel()+" gender: "+pesel.getGenderByPesel()+" Birthday: "+pesel.getDateOfBirth());
        Pesel pesel2 = new Pesel("93240326913");
        System.out.println("Pesel: "+pesel2.getPesel()+" gender: "+pesel2.getGenderByPesel()+" Birthday: "+pesel2.getDateOfBirth());
        Pesel pesel3 = new Pesel("54900325903");
        System.out.println("Pesel: "+pesel3.getPesel()+" gender: "+pesel3.getGenderByPesel()+" Birthday: "+pesel3.getDateOfBirth());
    }
}
