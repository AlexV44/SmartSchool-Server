package com.smartschool.springserver.mapper;

import com.smartschool.springserver.dto.SchoolProductDTO;
import com.smartschool.springserver.model.SchoolProduct;

public class SchoolProductMapper {
    public static SchoolProductDTO mapSchoolProduct(SchoolProduct schoolProduct) {
        SchoolProductDTO schoolProductDTO = new SchoolProductDTO();
        schoolProductDTO.setProductId(schoolProduct.getPk().getProduct().getId());
        schoolProductDTO.setSchoolId(schoolProduct.getPk().getSchool().getId());
        schoolProductDTO.setQuantity(schoolProduct.getQuantity());
        return schoolProductDTO;
    }
}
