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
import org.iplass.mtp.entity.UpdateOption;
import org.iplass.mtp.web.template.TemplateUtil;


@ActionMapping(name="demoApp/product/editProductSuccessful",
displayName="Edit Product Successful Action",
privileged=true,
result=@Result(type=Type.REDIRECT,
	value="disInput"),
command=@CommandConfig(commandClass=EditProductSuccessful.class)
)

@CommandClass(name="demoApp/product/editProductSuccessful", displayName="Edit Product Command")


public class EditProductSuccessful implements Command {

	@Override
	public String execute(RequestContext request) {
		
		String productId = request.getParam("productId");
		String productName = request.getParam("productName");
		String productDescription = request.getParam("productDescription");
		EntityManager em = ManagerLocator.manager(EntityManager.class);
		Entity editProduct = (Entity) em.load(productId, "demoApp.product.Product");
		editProduct.setName(productName);
		editProduct.setValue("description", productDescription );
		/* UpdateOption updateOption = new UpdateOption(); */
		em.update(editProduct, UpdateOption.allPropertyUpdateOption("demoApp.product.Product", false));
		/* em.update(editProduct, null); */

		/* request.setAttribute("editProduct", editProduct); */
        request.setAttribute("disInput", TemplateUtil.getTenantContextPath() + "/demoApp/product/displayProductList");
		
		return Constants.CMD_EXEC_SUCCESS;
	}

}
