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
import org.iplass.mtp.entity.DeleteOption;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.EntityManager;
import org.iplass.mtp.entity.UpdateOption;
import org.iplass.mtp.web.template.TemplateUtil;

@ActionMapping(name="demoApp/product/deleteProduct",
displayName="Delete Product Action",
privileged=true,
result=@Result(type=Type.REDIRECT,
	value="disInput"),
command=@CommandConfig(commandClass=DeleteProduct.class)
)

@CommandClass(name="demoApp/product/deleteProduct", displayName="Delete Product Command")


public class DeleteProduct implements Command{
	private final String PARAM_PRODUCT_ID = "productId";
	@Override
	public String execute(RequestContext request) {
		// TODO Auto-generated method stub
		String productId = request.getParam(PARAM_PRODUCT_ID);
		
		EntityManager em = ManagerLocator.manager(EntityManager.class);
		Entity editProduct = (Entity) em.load(productId, "demoApp.product.Product");
		DeleteOption deleteOption = new DeleteOption();
		em.delete(editProduct, deleteOption);
        request.setAttribute("disInput", TemplateUtil.getTenantContextPath() + "/demoApp/product/displayProductList");
		
		return Constants.CMD_EXEC_SUCCESS;
	}

}
