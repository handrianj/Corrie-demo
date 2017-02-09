package org.handrianj.corrie.demo.editor.input;

import org.handrianj.corrie.demo.model.Dummy;
import org.handrianj.corrie.editors.util.editors.AbstractCorrieEditorInput;

public class DemoInput extends AbstractCorrieEditorInput<Dummy> {

	@Override
	public String getName() {
		return "GraphDemo";
	}

	@Override
	public String getToolTipText() {
		return "GraphDemo";
	}

}
