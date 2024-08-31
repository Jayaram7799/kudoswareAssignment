package in.btm.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "First Name is Mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is Mandatory")
    private String lastName;

    @NotBlank(message = "Gender is Mandatory")
    private String gender;

    @NotBlank(message = "Email is Mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone Number is Mandatory")
    private Long phoneNumber;

    @NotBlank(message = "Qualification is Mandatory")
    private String qualification;

    @NotBlank(message = "Address is Mandatory")
    private String address;

    @NotBlank(message = "Job Role is Mandatory")
    private String jobRole;

    @Transient // Exclude this field from validation and persistence
    private byte[] resume; // Store file content as byte array
}

