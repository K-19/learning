package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    private User user1;
    private User user2;
    private User userNotAdd;
    private User userNotAdd1;

    @Before
    public void setup() throws Exception {
        user = new User("Евгений", 35, Sex.MALE);
        user1 = new User("Марина", 34, Sex.FEMALE);
        user2 = new User("Алина", 7, Sex.FEMALE);
        userNotAdd = new User("", 0, null);
        userNotAdd1 = new User(null, 0, null);
    }

    @Test
    public void getAllUsers() {
        List<User> expected = User.getAllUsers();
        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<User> expected = User.getAllUsers(Sex.MALE);
        List<User> actual = new ArrayList<>();
        actual.add(user);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_MALE_NO_NULL() {
        List<User> expected = User.getAllUsers(Sex.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_FEMALE() {
        List<User> expected = User.getAllUsers(Sex.FEMALE);
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        List<User> expected = User.getAllUsers(Sex.FEMALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetHowManyUsers() {
        int expected = User.getHowManyUsers();
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHowManyUsers_MALE() {
        int expected = User.getHowManyUsers(Sex.MALE);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHowManyUsers_FEMALE() {
        int expected = User.getHowManyUsers(Sex.FEMALE);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = User.getAllAgeUsers();
        int actual = 35 + 34 + 7;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_MALE() {
        int expected = User.getAllAgeUsers(Sex.MALE);
        int actual = 35;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_FEMALE() {
        int expected = User.getAllAgeUsers(Sex.FEMALE);
        int actual = 34 + 7;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageAgeOfAllUsers() {
        int expected = User.getAverageAgeOfAllUsers();
        int actual = (35 + 34 + 7) / 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageAgeOfAllUsers_MALE() {
        int expected = User.getAverageAgeOfAllUsers(Sex.MALE);
        int actual = 35;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageAgeOfAllUsers_FEMALE() {
        int expected = User.getAverageAgeOfAllUsers(Sex.FEMALE);
        int actual = (34 + 7) / 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newUser_EMPTY_NAME() {
        for (User user : User.getAllUsers()) {
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создать пользователя с пустым именем");
            }
        }
    }

    @Test
    public void newUser_AGE_ZERO() {
        for (User user : User.getAllUsers()) {
            if (user.getAge() <= 0) {
                Assert.fail("Попытка создать пользователя с с недопустимым возрастом");
            }
        }
    }

    @Test
    public void newUser_SEX_NO_NULL() {
        for (User user : User.getAllUsers()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создать пользователя с указанием пола = null");
            }
        }
    }
}