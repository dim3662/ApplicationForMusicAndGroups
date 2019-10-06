package exceptions;

public class MyExceptionForRepertoireDontHaveGroup extends Exception {
    public MyExceptionForRepertoireDontHaveGroup(){
        super("You can't do anything with repertoire without any group");
    }
}
