package com.hyperFoods.api.dto.address;

import com.hyperFoods.api.entity.Address;
import jakarta.validation.constraints.NotBlank;

public record CreateAddressDTO(
        @NotBlank(message = "Street is mandatory")
        String street,
        String number,
        @NotBlank(message = "City is mandatory")
        String city,
        @NotBlank(message = "Province is mandatory")
        String province,
        @NotBlank(message = "Zip code is mandatory")
        String zipCode,
        @NotBlank(message = "Phone number is mandatory")
        String phoneNumber

) {

        public CreateAddressDTO(Address address){
                this(address.getStreet(), address.getNumber(), address.getCity(), address.getProvince(), address.getZipCode(), address.getPhoneNumber());

        }
}
