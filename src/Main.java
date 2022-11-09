public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Menu menu = new Menu(" Welome to this page!!", " Choose one of the option below : ", (" _______________________________________________") +
                        "\n Choose 1. (Add Line) \n " + "Choose 2. (View Lines)\n Choose 3. (Delete Lines)\n Choose 4. (Exit)\n "
                        + ("_______________________________________________"));

        menu.printMenu();
        menu.readChoice();
    }
}


