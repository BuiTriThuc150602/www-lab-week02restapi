package vn.edu.iuh.fit.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;
import vn.edu.iuh.fit.enums.ProductStatus;

@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {

  @Override
  public Integer convertToDatabaseColumn(ProductStatus attribute) {
    return attribute == null ? null : attribute.getValue();
  }

  @Override
  public ProductStatus convertToEntityAttribute(Integer dbData) {
    return dbData == null ? null
        : Stream.of(ProductStatus.values()).filter(p -> p.getValue() == dbData).findFirst()
            .orElseThrow(IllegalAccessError::new);
  }
}
