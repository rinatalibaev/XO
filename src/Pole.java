import java.util.Scanner;
import java.lang.Integer;

public class Pole {
    private static final int FIELD_SIZE = 3;
    private String trigger = "X";
    private String poles [][] = new String [FIELD_SIZE][FIELD_SIZE];
    private String printPoles [][] = new String [FIELD_SIZE][FIELD_SIZE];
    private String status;
    private int newPole = 0;

    public void setPoles() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            setLine(i);
        }
    }
     public void setLine(int i) {
         for (int j = 0; j < FIELD_SIZE; j++) {
             poles[i][j] = Integer.toString(i*FIELD_SIZE + j);
             System.out.println(poles[i][j]);
         }
     }
    public void nachaloHoda() {
        System.out.println("Player " + trigger + " step");
    }
    public void setStatus(String newStatus) {
        status = newStatus;
    }
    public String getStatus() {
        return status;
    }
    public int setScanner() {
        System.out.println("Type field number");
        Scanner scanner = new Scanner(System.in);
        int pole = scanner.nextInt();
        if (pole <= FIELD_SIZE*FIELD_SIZE && pole > 0) {
            newPole = pole;
        } else {
            System.out.println("Type correct number from 1 to 9");
            setScanner();
        }
        return newPole;
    }

    public void printPole() {
        String razdelVerh = " _ _ _ _ _ _ _ _ _";
        String razdelNiz = " - - - - - - - - -";
        String vertical = "|     |     |     |";
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if ((poles[i][j].equals("X")) || poles[i][j].equals("O")) {
                    printPoles[i][j] = poles[i][j];
                } else {
                    printPoles[i][j] = " ";
                }
            }
        }
        String firstLine = "|  " + printPoles [0][0] + "  |  " + printPoles [0][1] + "  |  " + printPoles [0][2] + "  |";
        String secondLine = "|  " + printPoles [1][0] + "  |  " + printPoles [1][1] + "  |  " + printPoles [1][2] + "  |";
        String thirdLine = "|  " + printPoles [2][0] + "  |  " + printPoles [2][1] + "  |  " + printPoles [2][2] + "  |";
        System.out.println(razdelVerh);
        System.out.println(vertical);
        System.out.println(firstLine);
        System.out.println(vertical);
        System.out.println(razdelNiz);
        System.out.println(vertical);
        System.out.println(secondLine);
        System.out.println(vertical);
        System.out.println(razdelNiz);
        System.out.println(vertical);
        System.out.println(thirdLine);
        System.out.println(vertical);
        System.out.println(razdelNiz);
    }

    public void setUserPoles (int i, int newZnak) {
        for (int j = 0; j < FIELD_SIZE; j++) {
            if (newZnak == i*3 + j + 1) {
                poles[i][j] = trigger;
            }
        }
    }

    public void setTrigger(int newZnak) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            setUserPoles(i, newZnak);
        }

        printPole();

        if (horLinesEqual() ||
            vertLinesEqual() ||
            (poles[0][0].equals(poles[1][1]) && poles[1][1].equals(poles[2][2]) ||
            (poles[2][0].equals(poles[1][1]) && poles[0][2].equals(poles[1][1]))))
        {
            setStatus("WIN");
            System.out.println("Player " + trigger + " win!");
        } else {
            System.out.println(horLinesEqual());
            System.out.println(vertLinesEqual());
            if (trigger.equals("X")) {
                trigger = "O";
            } else {
                trigger = "X";
            }
        }
    }
    public boolean vertLinesEqual() {
        boolean secondUslovie = false;
        for (int i = 0; i < FIELD_SIZE; i++) {
            secondUslovie = secondUslovie || vertLineEqual(i);
        }
        return secondUslovie;
    }

    public boolean vertLineEqual(int i) {
        boolean secondUslovie = true;
        boolean etapSecondUslovie;
        for (int j = 0; j < FIELD_SIZE - 1; j++) {
            if (poles[i][j].equals(poles[i][j+1])) {
                etapSecondUslovie = true;
            } else {etapSecondUslovie = false;
            }
            secondUslovie = secondUslovie && etapSecondUslovie;
        }
        return secondUslovie;
    }

    public boolean horLinesEqual() {
        boolean firstUslovie = false;
        for (int j = 0; j < FIELD_SIZE; j++) {
            firstUslovie = firstUslovie || horLineEqual(j);
        }
        return firstUslovie;
    }

    public boolean horLineEqual(int j) {
        boolean firstUslovie = true;
        boolean etapFirstUslovie;
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            if (poles[i][j].equals(poles[i+1][j])) {
                etapFirstUslovie = true;
            } else {etapFirstUslovie = false;
            }
                firstUslovie = firstUslovie && etapFirstUslovie;
            }
        return firstUslovie;
    }
}
