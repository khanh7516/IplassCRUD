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
import org.iplass.mtp.entity.SearchResult;
import org.iplass.mtp.entity.query.Query;

import demo.entity.Product;

@ActionMapping(name="demoApp/product/displayProductList",
displayName="Display Product Action",
privileged=true,
result=@Result(type=Type.JSP,
    value="/jsp/displayProductList.jsp",
    templateName="demoApp/product/displayProductList"),
command=@CommandConfig(commandClass=DisplayProductList.class)
)

@CommandClass(name="demoApp/product/displayProductList", displayName="Display Product List Command")


public class DisplayProductList implements Command {

	@Override
	public String execute(RequestContext request) {
		//khởi tạo đối tượng EntityManager để quản lý các entity
		EntityManager em = ManagerLocator.manager(EntityManager.class);
		
		//Tạo query gọi toàn bộ product với 2 trường name và description
//		SearchResult<Entity> productList = em.searchEntity(new Query().select("oid","name", "description","price").from("demoApp.product.Product"));
		Query query = new Query()
                .select("oid", "name", "description", "price")
                .from("demoApp.product.Product");
		SearchResult<Entity> productList = em.searchEntity(query);
		//gán giá trị productList cho attribute productList để hiển thị tại template
		request.setAttribute("productList", productList);
		
		
		return Constants.CMD_EXEC_SUCCESS;
	}
}
