package useradmin;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  final String FILENAME = "useradmin/users.txt";
  ArrayList<User> users = new ArrayList<>();

  public static void main(String[] args) throws FileNotFoundException {


    User user1 = new User(1, "Jens", "4444");
    System.out.println(user1);

    new Main().run();
  }

  public void run() throws FileNotFoundException {
    boolean running;
    String[] menuItemsArray = {"1. View user list", "2. Create new user", "3. Delete user", "9. Quit"};
    Menu menu = new Menu("MENU:", "Please choose option: ", menuItemsArray);

    readFile();

    running = true;
    while (running) {
      menu.printMenu();
      int result  = menu.readChoice();


      switch (result ) {
        case 1:
          System.out.println(users);

          break;
        case 2:
          createNewUser();
          break;
        case 3:
          deleteUser();
          break;
        case 9:
          running = false;
          System.out.println("Bye");
          break;
        default:
          System.out.println("Your choice was invalid, you have entered: " + result  + "\nPlease enter from the menu");
      }
    }
  }

  public void createNewUser() throws FileNotFoundException {

    try {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter id number: ");
      int id = scan.nextInt();
      scan.nextLine();
      System.out.println("Enter name: ");
      String name = scan.nextLine();
      System.out.println("Enter password: ");
      String password = scan.nextLine();
      User user = new User(id, name, password);
      users.add(user);
      saveFil();
    } catch (Exception e) {
      String yes = "y";
      System.out.println("\"Your choice was invalid," + "\nPlease enter number.\"");
    }
  }

  public void deleteUser() throws FileNotFoundException {
    Scanner scanDelete = new Scanner(System.in);
    System.out.println("Enter index: ");
    int index = scanDelete.nextInt();
    users.remove(index);
    saveFil();
  }

  public void readFile()  {
    Scanner fileReader = null;
    try {
      fileReader = new Scanner(new File("users.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("Can not find the file");
    }
    while (fileReader.hasNext()) {
      String line = fileReader.nextLine();
      String[] data = line.split("-");
      User user = new User(Integer.parseInt(data[0]), data[1], data[2]);
      users.add(user);
    }
  }

  public void saveFil() throws FileNotFoundException {
    File file = new File("users.txt");
    PrintStream printStream = new PrintStream(file);
    for (int i = 0; i < users.size(); i++) {
      User user = users.get(i);
      String print = "";
      print += user.getId() + "-";
      print += user.getName() + "-";
      print += user.getPassword();
      printStream.println(print);
    }
  }
}
