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


@ActionMapping(name="demoApp/product/editProduct",
displayName="Edit Product Action",
privileged=true,
result=@Result(type=Type.JSP,
	value="/jsp/editProduct.jsp",
	templateName="demoApp/product/editProduct"),
command=@CommandConfig(commandClass=EditProduct.class)
)

@CommandClass(name="demoApp/product/editProduct", displayName="Edit Product Command")

public class EditProduct implements Command {
	private final String PARAM_PRODUCT_ID = "productId";

	@Override
	public String execute(RequestContext request) {
		String productId = request.getParam(PARAM_PRODUCT_ID);
		
		EntityManager em = ManagerLocator.manager(EntityManager.class);
		Entity editProduct = (Entity) em.load(productId, "demoApp.product.Product");
		
		request.setAttribute("editProduct", editProduct);
		
		return Constants.CMD_EXEC_SUCCESS;
	}

}
