import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    PrintStream printStream = new PrintStream(new FileOutputStream(nameOfFile,true));
    private ArrayList<String> arrayList = new ArrayList<>();

    public LogginThoseActions () throws IOException {
        try {
            logFileStart();
            this.printStream = new PrintStream(new PrintStream(nameOfFile, String.valueOf(true)));

        } catch (IOException e) {
            System.out.println("Messege: " + e);
        }
    }

    public void addLine() {
        try{
        System.out.print("Enter line:");
        inputLine = scanner.nextLine();
        arrayList.add(inputLine);

        for (int i = 0; i < arrayList.size(); i++) {
            printStream = new PrintStream(new FileOutputStream(nameOfFile,true));
            printStream.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " ")) +" Adding line :" + "'" + arrayList.get(i) + "' " + "\n");
          }
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong while adding lines");
        }
    }

    public void viewLine() {
        try {
            System.out.println(" Overview over all lines:");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(" #" + i + ": " + arrayList.get(i));
            }
            printStream = new PrintStream(new FileOutputStream(nameOfFile,true));
            printStream.append(logFileWithMesseges("Viewing all lines") + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong while viewing lines");
        }
    }

    public void deleteLine() {
        try {
        //inputIndex = inputIndex - 1;
        System.out.println(" Write the number for the line you want to delete");
        inputIndex = scanner.nextInt();
        arrayList.remove(inputIndex);
        printStream = new PrintStream(new PrintStream(nameOfFile, String.valueOf(true)));
        printStream.append(logFileWithMesseges("Deleting line" ) +"\n");

        System.out.println(" You have now deleted the line from the list" );
        }catch (Exception e) {
            System.out.println("Something went wrong while deleting a line");
        }
    }

    public String logFileWithMesseges(String messege) {
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss :" ))+ " " + messege;

    }
    public void logFileStart() {
        try {
            printStream = new PrintStream(new FileOutputStream(nameOfFile,true));
            printStream.append(logFileWithMesseges("Start program") +"\n");

        }catch (FileNotFoundException e) {
            System.out.println("Something went wrong while starting the program");
        }
    }

    public void logFileExit () {
        try{
            printStream = new PrintStream(new FileOutputStream(nameOfFile,true));
            printStream.append(logFileWithMesseges("Exiting Program") +"\n");
            printStream.close();
        }catch (FileNotFoundException e) {
            System.out.println("Something went wrong while exisiting");
        }
    }

    }






