public class Main {

    public static void main(String[] args) {

        Pole pole = new Pole();
        pole.setPoles();
        pole.setStatus ("Play");
        while (!pole.getStatus().equals("WIN")){
            pole.nachaloHoda();
            pole.printPole();
            pole.setTrigger(pole.setScanner());
        }
    }
}
