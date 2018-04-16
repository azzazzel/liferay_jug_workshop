package bg.jug.workshop.liferay.alloy.editor;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * This service contributes to AlloyEditor's menu the options to align paragraphs
 * See {@link https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/modifying-an-editors-configuration}
 * for more informaion.
 * 
 * @author Milen Dyankov
 */
@Component(
	property = {
		"editor.name=alloyeditor",
        "service.ranking:Integer=100"
		},
	service = EditorConfigContributor.class
)
public class BgJugAlloyEditorConfigContributor implements EditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
			JSONObject jsonObject, 
			Map<String, Object> inputEditorTaglibAttributes,
			ThemeDisplay themeDisplay, 
			RequestBackedPortletURLFactory requestBackedPortletURLFactory
		) {

		JSONArray selections = jsonObject.getJSONObject("toolbars").getJSONObject("styles").getJSONArray("selections");
		for (int i = 0; i < selections.length(); i++) {
			JSONObject selection = selections.getJSONObject(i);
			if ("text".equals(selection.getString("name"))){
				JSONArray buttons = selection.getJSONArray("buttons");
				buttons.put("paragraphLeft");
				buttons.put("paragraphCenter");
				buttons.put("paragraphRight");
				buttons.put("paragraphJustify");
			}
		}
		
	}
	
}