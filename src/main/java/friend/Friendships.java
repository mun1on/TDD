package friend;

import java.util.*;

public class Friendships {

    private final Map<String, List<String>> friendships = new HashMap<>();

    public void mainFriend(String firstPerson, String secondPerson){
        addFriend(firstPerson, secondPerson);
        addFriend(secondPerson, firstPerson);
    }

    private void addFriend(String person, String friend){
        if(!friendships.containsKey(person)){
            friendships.put(person, new ArrayList<>());
        }
        friendships.get(person).add(friend);
    }

    public List<String> getFriends(String person){
        return friendships.getOrDefault(person, Collections.emptyList()); // getOrDefault zwraca person jeśli ma przyjaciół, pustą listę jeśli nie ma
    }

    public boolean areFriends(String firstPerson, String secondPerson){
        return friendships.containsKey(firstPerson)
                && friendships.containsKey(secondPerson)
                && friendships.get(firstPerson).contains(secondPerson)
                && friendships.get(secondPerson).contains(firstPerson);
    }
}
