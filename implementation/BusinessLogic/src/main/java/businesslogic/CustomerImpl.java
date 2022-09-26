package businesslogic;

import businessentitiesapi.Customer;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

import java.time.LocalDate;

@TableName(value = "customer")
public class CustomerImpl implements Customer {
    @ID
    private final int id;
    private final String name, email;
    private final LocalDate birthDate;

    public CustomerImpl(int id, String name, String email, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthdate;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String toString(){
        return name;
    }
}
