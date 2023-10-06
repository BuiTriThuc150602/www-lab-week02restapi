package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {

  @Override
  public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
    return attribute == null ? null : attribute.getValue();
  }

  @Override
  public EmployeeStatus convertToEntityAttribute(Integer dbData) {
    return dbData == null ? null : Stream.of(EmployeeStatus.values())
        .filter(c -> c.getValue() == dbData)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
