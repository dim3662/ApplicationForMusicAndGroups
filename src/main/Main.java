package main;
// Подключение графических библиотек
import design.Design;
import managerGroup.ManagerGroup;

public class Main {
    public static void main(String[] args) {
        ManagerGroup managerGroup=new ManagerGroup();
       Design design= new Design(managerGroup);
       design.show();
    }
}
