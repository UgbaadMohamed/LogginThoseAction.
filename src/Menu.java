import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private String menuHeader;
    private String leadText;
    private String menuItem;
    private int input;
    private boolean keeplaying = true;
    LogginThoseActions logginThoseActions = new LogginThoseActions();

    public Menu(String menuHeader, String leadText, String menuItem) throws IOException {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItem = menuItem;
    }

    public void printMenu() {
        System.out.println(menuHeader);
        System.out.println(leadText);
        System.out.println(menuItem);
    }

    public void readChoice() {
        try{
        while (keeplaying) {
            printMenu();
            input = sc.nextInt();
            switch (input) {
                case 1:
                    input = 1;
                    logginThoseActions.addLine();

                    break;

                case 2:
                    input = 2;
                    System.out.println("");
                    logginThoseActions.viewLine();
                    System.out.println("");
                    break;

                case 3:
                    input = 3;
                    logginThoseActions.deleteLine();
                    break;

                case 4:
                    input = 4;
                    keeplaying = false;
                    logginThoseActions.logFileExit();
                    System.out.println("                  End of session");
                    System.out.println("");

                    break;
                default:
                    System.out.println("You typed something the system could not understand!");
            }
        }
        System.out.println("__________________________________________________");
        } catch (InputMismatchException e) {
            System.err.println("Warning you wrote something our systemmenu does not contain");
        }

    }
}
