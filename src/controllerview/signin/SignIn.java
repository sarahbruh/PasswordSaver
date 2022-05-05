package controllerview.signin;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SignIn {
    public static ArrayList<SignInData> dataList = new ArrayList<>();

    public static void setUser(){
        try(BufferedReader br = new BufferedReader(new FileReader("Users.csv")))
        {
            String u = br.readLine();
            if(u.equals("User SaveFile 1.0"))
            {
                while ((u = br.readLine()) != null)
                {
                    String[] split = u.split(";");
                    dataList.add(new SignInData(split[0], split[1]));
                }
            }
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    public static void addUser(String username, String password)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Users.csv", true)))
        {
            bw.write(username+";"+password+"\n");
            dataList.add(new SignInData(username, password));
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    public static int getSize(){
        return dataList.size();
    }

    public static String getNameOfUser(int index){
        return dataList.get(index).getUsername();
    }

    public static String getPasswordOfUser(int index){
        return dataList.get(index).getPassword();
    }

    public static SignInData getUser(int index)
    {
        return dataList.get(index);
    }

    public static void writeUsers()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Users.csv")))
        {
            bw.write("User SaveFile 1.0\n");
            for (SignInData user:dataList)
            {
                bw.write(user.username+";"+user.getPassword()+";"+"\n");
            }
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }
}
