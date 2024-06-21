package demo.command;

import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;

@ActionMapping(name="demoApp/product/displayCreateProductPage",
displayName="Display Create New Product Page Action",
privileged=true,
result=@Result(type=Type.JSP,
    value="/jsp/displayCreateProductPage.jsp",
    templateName="demoApp/product/displayCreateProductPage")
)

//@CommandClass(name="demoApp/product/displayCreateProductPage", displayName="Display Create New Product Page Command")



public class DisplayCreateProductPage  {}