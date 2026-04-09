package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Pranav G.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("pgunhal", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s26-13", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Arya S."),"Team should contain Arya S.");
        assertTrue(t.getMembers().contains("Joaquin W."),"Team should contain Joaquin W.");
        assertTrue(t.getMembers().contains("Pranav G."),"Team should contain Pranav G.");
        assertTrue(t.getMembers().contains("Safwan R."),"Team should contain Safwan R.");
        assertTrue(t.getMembers().contains("Rohan N."),"Team should contain Rohan N.");
        assertTrue(t.getMembers().contains("Nick K."),"Team should contain Nick K.");
    }
}

