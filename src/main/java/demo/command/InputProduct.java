package demo.command;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.ManagerLocator;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.CommandConfig;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.EntityManager;
import org.iplass.mtp.entity.GenericEntity;
import org.iplass.mtp.web.template.TemplateUtil;

@ActionMapping(name="demoApp/product/inputProduct",
displayName="Input New Product Action",
privileged=true,
result=@Result(type=Type.REDIRECT,
    value="disInput"),
command=@CommandConfig(commandClass=InputProduct.class)
)

@CommandClass(name="demoApp/product/inputProduct", displayName="Input Product Command")


public class InputProduct implements Command {

	@Override
	public String execute(RequestContext request) {
		//khởi tạo entity manager để quản lý entity
		EntityManager em = ManagerLocator.manager(EntityManager.class);
		
		String productName = request.getParam("productName");
		String productDescription = request.getParam("productDescription");
		String productPriceStr  = request.getParam("productPrice");
		
		// Kiểm tra và chuyển đổi giá trị productPrice
        Integer productPrice = null;
        if (productPriceStr != null && !productPriceStr.trim().isEmpty()) {
            try {
                productPrice = Integer.parseInt(productPriceStr);
            } catch (NumberFormatException e) {
                // Xử lý lỗi khi chuyển đổi giá trị productPrice không thành công
                request.setAttribute("errorMessage", "Invalid price format.");
                return Constants.CMD_EXEC_FAILURE;
            }
        }
		
		 Entity newProduct = new GenericEntity();
		 newProduct.setDefinitionName("demoApp.product.Product");
		 newProduct.setName(productName);
		 newProduct.setValue("description", productDescription);
		 newProduct.setValue("price", productPrice);
         
         em.insert(newProduct);
		
         request.setAttribute("disInput", TemplateUtil.getTenantContextPath() + "/demoApp/product/displayProductList");
		 return Constants.CMD_EXEC_SUCCESS;
	}
	

}
