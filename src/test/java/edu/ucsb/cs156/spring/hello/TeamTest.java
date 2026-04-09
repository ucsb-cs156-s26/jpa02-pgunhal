package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_same_object_returns_true() {
        assert(team.equals(team));
    }

    @Test
    public void equals_different_type_returns_false() {
        Team t = new Team();
        assert(!t.equals("not a team"));
    }

    @Test
    public void equals_same_name_and_members_returns_true() {
        Team t1 = new Team();
        t1.setName("team");
        t1.addMember("A");

        Team t2 = new Team();
        t2.setName("team");
        t2.addMember("A");

        assert(t1.equals(t2));
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
        Team t1 = new Team();
        t1.setName("team");
        t1.addMember("A");

        Team t2 = new Team();
        t2.setName("team");
        t2.addMember("B");

        assert(!t1.equals(t2));
    }



    @Test
    public void equals_different_name_returns_false() {
        Team t1 = new Team();
        t1.setName("team1");
        t1.addMember("A");

        Team t2 = new Team();
        t2.setName("team2");
        t2.addMember("A");

        assert(!t1.equals(t2));
    }

    @Test
    public void hashCode_specific_value() {
        Team t = new Team();
        t.setName("team");
        t.addMember("A");

        int result = t.hashCode();
        int expectedResult = 3555965; //cheat method

        assertEquals(expectedResult, result);
    }






   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
