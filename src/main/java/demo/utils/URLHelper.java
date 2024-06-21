package demo.utils;

import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.web.template.TemplateUtil;
import org.iplass.mtp.entity.BinaryReference;

public class URLHelper {
	private final static String PACKAGE_URL_ROOT = "/demoApp/";
	private final static String PRODUCT_EDIT_URL_PATH = PACKAGE_URL_ROOT + "product/editProduct?productId=%s";
	private final static String PRODUCT_DELETE_URL_PATH = PACKAGE_URL_ROOT + "product/deleteProduct?productId=%s";
	private final static String BINARY_RESOUCE_URL_PATH = PACKAGE_URL_ROOT + "product/resource/bin?id=%d&type=%s";
	
	public static String getProductEditPath(String productId) {
		return TemplateUtil.getTenantContextPath() + String.format(PRODUCT_EDIT_URL_PATH, productId);
	}
	
	public static String getProductDeletePath(String productId) {
		return TemplateUtil.getTenantContextPath() + String.format(PRODUCT_DELETE_URL_PATH, productId);
	}
	
	public static String getProductImageResource(Entity product) {
		BinaryReference br = product.getValue("productImage");
		return TemplateUtil.getTenantContextPath() + getBinaryResoucePath(br.getLobId(), "productImage");
		
	}
	
	private static String getBinaryResoucePath(long lobId, String type) {
		return String.format(BINARY_RESOUCE_URL_PATH, lobId, type);
	}	

}
