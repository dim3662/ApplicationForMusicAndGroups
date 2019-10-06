package exceptions;

public class MyExceptionForGroups extends Exception {
    public MyExceptionForGroups(){
        super("You can't delete a group because you don't have any group");
    }
}
