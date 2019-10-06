package exceptions;

public class MyExeptionForStructureDontHaveGroup extends Exception {
    public MyExeptionForStructureDontHaveGroup(){
        super("You can't do something with person because you don't have any group");
    }
}
