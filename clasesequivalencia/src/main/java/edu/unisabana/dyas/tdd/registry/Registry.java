package edu.unisabana.dyas.tdd.registry;
public class Registry {
    public RegisterResult registerVoter(Person p) {
        // Validar la persona según las reglas de negocio
        if (p == null) {
            // Si la persona es nula, no es válida
            return RegisterResult.INVALID;
        }
        // Verificar si la persona es mayor de edad
        if (p.getAge() >= 18) {  
            return RegisterResult.VALID;
        } else {
            return RegisterResult.UNDERAGE;
        }


    }
}
