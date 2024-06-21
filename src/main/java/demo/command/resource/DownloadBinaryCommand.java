package demo.command.resource;

import java.util.HashMap;
import java.util.Map;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.ManagerLocator;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.EntityManager;

import demo.entity.Product;


@ActionMapping(
		name = "demoApp/product/resource/bin", 
		displayName = "バイナリデータダウロード",
		privilaged = true,
		result = @Result(
				type = Type.STREAM, 
				value = DownloadBinaryCommand.RESULT_STREAM))
@CommandClass(
		name = "demoApp/product/resource/DownloadBinaryCommand", 
		displayName = "Dowload Binary Command")
public class DownloadBinaryCommand implements Command {

	private static final EntityManager em = ManagerLocator.getInstance().getManager(EntityManager.class);
	private final String PARAM_ID = "id";
	private final String PARAM_TYPE = "type";
	public static final String RESULT_STREAM = "resultStream";
	@SuppressWarnings("serial")
	private final Map<String, DefinitionPropName> defPropNameMap = new HashMap<String, DefinitionPropName>() {
		{
			// ショップ情報と店舗画像
/*			put(Consts.BIN_TYPE_SHOP_IMG, new DefinitionPropName(Shop.DEFINITION_NAME, Shop.SHOP_IMG));*/
			// 商品と商品画像
			put("productImage", new DefinitionPropName(Product.DEFINITION_NAME, Product.PRODUCT_IMAGE));
		}
	};

	@Override
	public String execute(RequestContext request) {
		Long lobId = request.getParamAsLong(PARAM_ID);
		String type = request.getParam(PARAM_TYPE);

		DefinitionPropName defPropName = defPropNameMap.get(type);
		if (defPropName == null) {
			return Constants.CMD_EXEC_SUCCESS;
		}
		String defName = defPropName.getDefinitionName();
		String propName = defPropName.getPropertyName();
		BinaryReference br = DownloadBinaryCommand.loadBinaryReference(lobId);
		if (br != null && defName.equals(br.getDefinitionName()) && propName.equals(br.getPropertyName())) {
			request.setAttribute(RESULT_STREAM, br);
		} else {
			request.setAttribute(RESULT_STREAM, request.getSession().loadFromTemporary(lobId));
		}

		return Constants.CMD_EXEC_SUCCESS;
	}
	
	private class DefinitionPropName {
		private String definitionName;
		private String PropertyName;

		public DefinitionPropName(String definitionName, String propertyName) {
			this.definitionName = definitionName;
			this.PropertyName = propertyName;
		}

		public String getDefinitionName() {
			return definitionName;
		}

		public String getPropertyName() {
			return PropertyName;
		}
	}
	
	public static BinaryReference loadBinaryReference(long lobId) {
		return em.loadBinaryReference(lobId);
	}
}