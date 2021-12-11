package socialNetwork;

public class Influencer extends User {
    public void printMessage(){
        System.out.println("Hello i am Influencer from Khashuri, my name is " + getName()+ " and my followers number is " + getFriendsCount());
    }
}
