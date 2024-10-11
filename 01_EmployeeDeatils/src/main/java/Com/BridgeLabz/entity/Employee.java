package Com.BridgeLabz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@NotBlank(message = "Username is mandatory")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person first name Invalid")
	private String name;
	@NotBlank(message = "Email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Please provide a valid email address")
	private String email;
	@NotNull(message = "Mobile number cannot be blank")
	@Min(value = 910000000000L, message = "Mobile number must be valid")
	@Max(value = 919999999999L, message = "Mobile number must be valid")
	private Long mobileNo;
}
