package org.handrianj.corrie.demo.editor.input;

import org.handrianj.corrie.demo.model.Dummy;
import org.handrianj.corrie.editors.util.editors.ICorrieEditorInput;
import org.handrianj.corrie.editors.util.factories.IEditorInputFactory;

public class DemoInputFactory implements IEditorInputFactory<Dummy> {

	@Override
	public ICorrieEditorInput<Dummy> createInput(Object object) {
		DemoInput graphDemoInput = new DemoInput();
		if (object instanceof Dummy) {

			graphDemoInput.setData((Dummy) object);
		} else {
			graphDemoInput.setData(new Dummy());
		}
		return graphDemoInput;
	}

}
