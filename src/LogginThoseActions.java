import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class LogginThoseActions  {
    private final String nameOfFile = "src/logfile.txt";
    Scanner scanner = new Scanner(System.in);
    private String inputLine;
    private int inputIndex;
    PrintStream printStream = null;
    private ArrayList<String> arrayList = new ArrayList<>();

    public LogginThoseActions ()  {
        try {
            this.printStream = new PrintStream(nameOfFile);
             logFileStart();
        } catch (IOException e) {

            System.out.println("Messege: " + e);
        }
    }

    public void addLine() {
        System.out.print(" Enter line:");
        inputLine = scanner.nextLine();
        arrayList.add(inputLine);

        for (int i = 0; i < arrayList.size(); i++) {
            printStream.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " ")) +" Adding line :" + "'" + arrayList.get(i) + "' " + "\n");
        }
    }

    public void viewLine() {
        System.out.println(" Overview over all lines:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(" #" + i + ": " + arrayList.get(i));
        }
        printStream.append(logFileWithMesseges("Viewing all lines") +"\n");

    }

    public void deleteLine() {
        inputIndex = inputIndex - 1;
        System.out.println(" Write the number for the line you want to delete");
        inputIndex = scanner.nextInt();
        arrayList.remove(inputIndex);
        printStream.append(logFileWithMesseges("Deleting line" ) +"\n");
        System.out.println(" You have now deleted the line from the list" );
    }

    public String logFileWithMesseges(String messege) {
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss :" ))+ " " + messege;

    }
    public void logFileStart() {
        printStream.append(logFileWithMesseges("Start program") +"\n");
    }

    public void logFileExit () {
        printStream.append(logFileWithMesseges("Exiting Program") +"\n");
    }

    }






