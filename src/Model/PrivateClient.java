package Model;

public class PrivateClient extends Client {

    private String name;
    private String surname;
    public String GetName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }
    public String GetSurname(){
        return surname;
    }
    public void SetSurname(String surname){
        this.surname=surname;
    }
    public PrivateClient(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }
}
