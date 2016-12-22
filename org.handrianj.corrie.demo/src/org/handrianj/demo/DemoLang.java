package org.handrianj.demo;

import java.util.Map;

import org.handrianj.corrie.languagemanager.service.AbstractLanguageDataProvider;

public class DemoLang extends AbstractLanguageDataProvider {

	@Override
	public String getPluginID() {
		// returns the ID of the plugin
		return null;
	}

	@Override
	public Map<String, String> getDefaultTextsMap() {
		// returns a map linking the text keys to the texts
		return null;
	}

	@Override
	protected Map<String, String> getTextMapForLang(int id) {
		// returns a map linking the text keys to the texts depending on the
		// language ID
		return null;
	}

}
