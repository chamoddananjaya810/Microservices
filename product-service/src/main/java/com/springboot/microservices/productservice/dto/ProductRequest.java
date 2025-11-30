package com.springboot.microservices.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
//DTO (Data Transfer Object)
//මොකක්ද මේ: Data එහා මෙහා ගෙනියන පෙට්ටියක් වගේ දෙයක්.
//
//කාර්යය: Model එකේ තියෙන හැම විස්තරයක්ම (Ex: Password, Secret Keys) User ට පෙන්නන්න හොඳ නෑ. ඒ වගේ වෙලාවට අපිට පෙන්නන්න ඕන ටික විතරක් දාලා යවන temporary object එක තමයි DTO කියන්නේ.
//
//සම්බන්ධය: Controller සහ Service අතර දත්ත හුවමාරු වෙන්නේ DTO හරහා.
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;

}
