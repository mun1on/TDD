package friend;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FriendshipsTest {

    private Friendships friendships;

    @BeforeEach
//    @AfterEach
//    @BeforeAll
//    @AfterAll
    public void setUp(){
        friendships = new Friendships();
    }

//    @AfterAll
//    public static void foo(){
//        System.out.println("Mój komunikat");
//    }

    @Test
//    @RepeatedTest(1000)
    @DisplayName("Dodaj osobę 'Ala' i przyjaciela 'Jacek'")
    public void shouldReturnJacek(){
        //given
        //when
        friendships.mainFriend("Ala", "Jacek");
        //given
        List<String> friend = friendships.getFriends("Ala");
        assertTrue(friend.contains("Jacek"));
    }

    @Test
    public void shouldReturnEmptyListWithFriends(){
        //given
        //when
        List<String> friends = friendships.getFriends("Barbara");
        //then
        assertTrue(friends.isEmpty());
    }

    @Test
    @Disabled
    public void shouldReturnFriendOfPersonFriend(){
        //given
        friendships.mainFriend("Ala", "Jacek");
        //when
        boolean areFriends = friendships.areFriends("Ala", "Jacek")
                && friendships.areFriends("Jacek", "Ala");

        //then
        assertTrue(areFriends);
    }
}