package de.kaimon.schoolproject.kai;

public class SchoolProjectKai {
    public static void main(String[] args){
        if(args.length > 0){
            if(args[0].equals("cmd")) new SetupCmd();
            new SetupCmd(args);
        } else {
            new Setup();
        }
    }
}
