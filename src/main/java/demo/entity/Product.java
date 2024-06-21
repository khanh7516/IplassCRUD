package demo.entity;


import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.GenericEntity;

/**
 * Product Entity。
 */
public class Product extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "demoApp.product.Product";

	/** Price */
	public static final String PRICE = "price";
	/** ProductImage */
	public static final String PRODUCT_IMAGE = "productImage";

	public Product() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Priceを返します。
	 * 
	 * @return Price
	 */
	public Long getPrice() {
		return getValue(PRICE);
	}

	/**
	 * Priceを設定します。
	 * 
	 * @param price Price
	 */
	public void setPrice(Long price) {
		setValue(PRICE, price);
	}

	/**
	 * ProductImageを返します。
	 * 
	 * @return ProductImage
	 */
	public BinaryReference getProductImage() {
		return getValue(PRODUCT_IMAGE);
	}

	/**
	 * ProductImageを設定します。
	 * 
	 * @param productImage ProductImage
	 */
	public void setProductImage(BinaryReference productImage) {
		setValue(PRODUCT_IMAGE, productImage);
	}

}