package mybootapp.web;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mybootapp.model.Product;

@Service
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
            "product.name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
            "product.description");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type",
            "product.type");

        if (!(product.getPrice() > 0.0)) {
            errors.rejectValue("price", "product.price.too.low");
        }
    }

}
