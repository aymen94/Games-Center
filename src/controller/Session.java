package controller;


public class Session implements Runnable {
    private int id;
    private static User usr=null;
    protected Session(int id){
        this.id=id;
    }

    public static User getUser(){
            return usr;
    }

    @Override
    public void run() {
        usr=new User(this.id);
    }
}
