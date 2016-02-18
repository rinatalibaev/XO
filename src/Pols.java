import java.util.Scanner;
import java.lang.Integer;

public class Pols {
    private static final int FIELD_SIZE = 9;
    private String trigger = "X";
    private String poles [] = new String [FIELD_SIZE];
    private String printPoles [] = new String [FIELD_SIZE];
    private String status;
    private int newPole = 0;

    public void setPoles() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            poles[i] = Integer.toString(i + 1);
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
        if (pole <= 9 && pole > 0) {
            newPole = pole;
        } else {
            System.out.println("Type correct number from 1 to 9");
            setScanner();
        }
        return newPole;
    }

    public void printPole() {
        String razdel = " _ _ _ _ _ _ _ _ _";
        String vertical = "|     |     |     |";
        for (int i = 0; i < FIELD_SIZE; i++) {
            if ((poles[i].equals("X")) || poles[i].equals("O")) {
                printPoles [i] = poles [i];
            } else printPoles [i] = " ";
        }
        String firstLine = "|  " + printPoles [0] + "  |  " + printPoles [1] + "  |  " + printPoles [2] + "  |";
        String secondLine = "|  " + printPoles [3] + "  |  " + printPoles [4] + "  |  " + printPoles [5] + "  |";
        String thirdLine = "|  " + printPoles [6] + "  |  " + printPoles [7] + "  |  " + printPoles [8] + "  |";
        System.out.println(razdel);
        System.out.println(vertical);
        System.out.println(firstLine);
        System.out.println(vertical);
        System.out.println(razdel);
        System.out.println(vertical);
        System.out.println(secondLine);
        System.out.println(vertical);
        System.out.println(razdel);
        System.out.println(vertical);
        System.out.println(thirdLine);
        System.out.println(vertical);
        System.out.println(razdel);
    }

    public void setTrigger(int newZnak) {

        for (int i = 0; i < FIELD_SIZE; i++) {
            if (newZnak == i + 1) {
                poles[i] = trigger;
            }
        }

        printPole();

        if ((poles[0].equals(poles[4]) && poles[4].equals(poles[8]) ||
                poles[0].equals(poles[3]) && poles[3].equals(poles[6]) ||
                poles[0].equals(poles[1]) && poles[1].equals(poles[2]) ||
                poles[2].equals(poles[4]) && poles[4].equals(poles[6]) ||
                poles[2].equals(poles[5]) && poles[5].equals(poles[8]) ||
                poles[6].equals(poles[7]) && poles[7].equals(poles[8]) ||
                poles[1].equals(poles[4]) && poles[4].equals(poles[7]) ||
                poles[3].equals(poles[4]) && poles[4].equals(poles[5]))) {
                setStatus("WIN");
                System.out.println("Player " + trigger + " win!");
            } else {
                if (trigger.equals("X")) {
                    trigger = "O";
                } else {
                    trigger = "X";
                }
            }
        }
    }


