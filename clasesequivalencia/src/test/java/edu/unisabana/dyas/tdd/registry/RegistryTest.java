package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void testValidVoterRegistration() {
        //  persona válida mayor de edad
        Person person = new Person("Juan", 12345, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void testUnderagePersonRegistration() {
        // persona menor de edad
        Person person = new Person("María", 54321, 17, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void testDuplicatePersonRegistration() {
        // persona que ya está registrada
        Person existingPerson = new Person("Pedro", 98765, 25, Gender.MALE, true);
        registry.registerVoter(existingPerson);

        // la misma persona nuevamente
        RegisterResult result = registry.registerVoter(existingPerson);
        Assert.assertEquals(RegisterResult.DUPLICATE, result);
    }

  
}
