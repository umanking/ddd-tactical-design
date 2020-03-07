package kitchenpos.products.tobe.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author Geonguk Han
 * @since 2020-03-07
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product create(final Product product) {
        product.validatePrice();
        return productRepository.save(product);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }
}