/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.Year;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Paul
 */
@Converter(autoApply = true)
public class YearAttributeConverter
        implements AttributeConverter<Year, Short> {
 
    @Override
    public Short convertToDatabaseColumn(
            Year attribute) {
        return (short) attribute.getValue();
    }
 
    @Override
    public Year convertToEntityAttribute(
            Short dbData) {
        return Year.of(dbData);
    }
}
