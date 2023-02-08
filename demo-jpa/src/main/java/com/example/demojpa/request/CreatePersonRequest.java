package com.example.demojpa.request;

import com.example.demojpa.models.Person;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class CreatePersonRequest
{
    @NotBlank(message = "First name should not be empty")
    private String firstName;
    private String lastName;
    @NotBlank(message = "DOB should not be empty")
    private String dob;

    @NotBlank
    private String location;

    public Person to()
    {
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dob(dob)
               // .countryCode(getCountryCodeFromLocation())
                .build();
    } 
//    public String getCountryCodeFromLocation()
//    {
//        if(this.location.equalsIgnoreCase("india"))
//        {
//            return "+91";
//        }
//    }
}
