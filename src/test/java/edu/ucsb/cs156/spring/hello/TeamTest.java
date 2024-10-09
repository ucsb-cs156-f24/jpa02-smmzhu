package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList; 

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
    public void toString_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    
    @Test
    // same object should be equal
    public void testEquals_case1(){
        
        Team a = new Team("test-team");
        assertEquals(a.equals(a), true); 
    }

    @Test
    // class doesnt match
    public void testEquals_case2(){
        Team a = new Team("test-team");
        int b = 5;
        assertEquals(a.equals(b), false); 
    }

    @Test
    public void testEquals_case3(){
        ArrayList<String> members = new ArrayList<>();
        members.add("John Doe");
        members.add("Jane Doe");
        members.add("Bob Smith");
        members.add("Alice Johnson");
        members.add("Michael Davis");

        ArrayList<String> members2 = new ArrayList<>();
        members2.add("foo");
        members2.add("bar");
        members2.add("baz");
        members2.add("stop");
        members2.add("reading this");

        Team a = new Team("test-name"); // name1, members1
        Team b = new Team("test-name"); // name1, members1
        Team c = new Team("diff-name"); // name2, members1
        Team d = new Team("test-name"); // name1, members2
        Team e = new Team("diff-name"); // name2, members2
 
        a.setMembers(members);
        b.setMembers(members);
        c.setMembers(members);
        d.setMembers(members2);
 
        assertEquals(a.equals(b), true); // same name, same members
        assertEquals(a.equals(c), false); // different name
        assertEquals(a.equals(d), false); // different members
        assertEquals(a.equals(e), false); // different name and members
    }

    @Test
    public void testHashCode(){
        ArrayList<String> members = new ArrayList<>();
        members.add("John Doe");
        members.add("Jane Doe");
        members.add("Bob Smith");
        members.add("Alice Johnson");
        members.add("Michael Davis");

        ArrayList<String> members2 = new ArrayList<>();
        members2.add("foo");
        members2.add("bar");
        members2.add("baz");
        members2.add("stop");
        members2.add("reading this");

        Team a = new Team("test-name"); // name1, members1
        Team b = new Team("test-name"); // name1, members1
        Team c = new Team("diff-name"); // name2, members1
        Team d = new Team("test-name"); // name1, members2
        Team e = new Team("diff-name"); // name2, members2
 
        a.setMembers(members);
        b.setMembers(members);
        c.setMembers(members);
        d.setMembers(members2);
 
        assertEquals(a.hashCode() == b.hashCode(), true); // same name, same members (different object, so same hash code)  (a == b.hashCode()); // same name, same members
        assertEquals(a.hashCode() == c.hashCode(), false); // different name
        assertEquals(a.hashCode() == d.hashCode(), false); // different members
        assertEquals(a.hashCode() == e.hashCode(), false); // different name and members
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
