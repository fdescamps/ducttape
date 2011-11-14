package ducttape.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Entity
public class Customer {
    @Id @GeneratedValue long id;

    @NotEmpty
    private String name;

    @NotEmpty @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
