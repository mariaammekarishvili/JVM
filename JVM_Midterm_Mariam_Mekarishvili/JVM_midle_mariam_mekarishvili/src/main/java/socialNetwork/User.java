package socialNetwork;

public class User {
    public int friendsCount;
    public String name;

    public String getName(){
        return this.name;
    }
    public int getFriendsCount(){
        return this.friendsCount;
    }

    public void  setInfo (String newName, Integer newFrCo){
        this.name = newName;
        this.friendsCount = newFrCo;
    }

    public User(){
        this.friendsCount = 1;
        this.name = "Gauqmebulia Gauqmebulia";
    }

    public void printMessage(){
        System.out.printf("Hello i am  %s and my friends' number is %d .",getName(),getFriendsCount());
    }
}
