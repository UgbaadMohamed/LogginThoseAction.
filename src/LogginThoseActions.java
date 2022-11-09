import java.io.File;
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

    public String getInputLine() {
        return inputLine;
    }

    public LogginThoseActions ()  {
        try {
            this.printStream = new PrintStream(nameOfFile);
             logFileStart();
        } catch (IOException e) {

            System.out.println("Messege: " + e);
        }
    }

    public int getInputIndex() {
        return inputIndex;
    }

    public void addLine() {
        inputLine = scanner.nextLine();
        arrayList.add(inputLine);
        logFileAdd();
    }

    public void viewLine() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(" #" + i + ": " + arrayList.get(i));
        }
    }

    public void deleteLine() {
        inputIndex = inputIndex - 1;
        System.out.println("Write the number for the line you want to delete");
        inputIndex = scanner.nextInt();
        arrayList.remove(inputIndex);

    }

    public void logFileAdd() {
        for (int i = 0; i < arrayList.size(); i++) {
            printStream.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " ")) +"Adding line:" + "'" + arrayList.get(i) + "' " + "\n");
        }

    }

    public String logFileWithMesseges(String messege) {
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss :" ))+ " " + messege;

    }

    public void logFileViewList () {
        printStream.append(logFileWithMesseges("Viewing all lines") +"\n");

    }

    public void logFileDelete () {
        printStream.append(logFileWithMesseges("Deleting line" ) +"\n");
    }

    public void logFileStart() {
        printStream.append(logFileWithMesseges("Start program") +"\n");
    }

    public void logFileSlut () {
        printStream.append(logFileWithMesseges("End program") +"\n");
        //printStream.close();
    }


    public void rememberLog () {
        try {
            File file = new File(nameOfFile);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                // todo: Hente en linje og skriv den igen med printsteam.
            }
        } catch (IOException e) {
            System.out.println("Messege: " + e);
        }
    }


}




