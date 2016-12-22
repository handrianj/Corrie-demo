package org.handrianj.demo;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.handrianj.corrie.editors.util.editors.AbstractCorrieEditor;
import org.handrianj.corrie.serviceregistry.ServiceRegistry;

public class DemoEditor extends AbstractCorrieEditor<Object> {
	public DemoEditor() {
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void languageChanged() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		super.createPartControl(parent);

		Composite composite = new Composite(parent, SWT.NONE);

		Label lblText = new Label(composite, SWT.NONE);
		lblText.setText(ServiceRegistry.getLanguageManagerService().getMessage("org.handrianj.demo", "TextKey",
				RWT.getUISession()));
	}
}
