package org.handrianj.demo;

import org.handrianj.corrie.editors.util.editors.ICorrieEditorInput;
import org.handrianj.corrie.editors.util.factories.IEditorInputFactory;

public class DemoEditorInputFactory implements IEditorInputFactory<Object> {

	@Override
	public ICorrieEditorInput<Object> createInput(Object object) {
		DemoEditorInput input = new DemoEditorInput();

		// TODO Write the logic get the part of the Object parameter to setup in
		// the input by calling
		// input.setData(element);
		return input;
	}

}
