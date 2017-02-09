package org.handrianj.corrie.demo.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.handrianj.corrie.demo.model.Dummy;
import org.handrianj.corrie.editors.util.editors.AbstractCorrieEditor;
import org.handrianj.corrie.serviceregistry.ServiceRegistry;

public class ContentDemoEditor extends AbstractCorrieEditor<Dummy> {
	private Text text;

	public ContentDemoEditor() {
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
	public void createPartControl(Composite parent) {

		ServiceRegistry.getPictureRegistryService();

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Group group = new Group(composite, SWT.NONE);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group.setText("Demo");

		Label lblLabel = new Label(group, SWT.NONE);
		lblLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLabel.setText("Label");

		text = new Text(group, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblCombo = new Label(group, SWT.NONE);
		lblCombo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCombo.setText("Combo");

		Combo combo = new Combo(group, SWT.CHECK);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.add("A");
		combo.add("B");
		combo.add("C");
		combo.add("D");
		combo.add("E");

		List list = new List(group, SWT.BORDER);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List E");

		Tree tree = new Tree(group, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		TreeItem trtmItemA = new TreeItem(tree, SWT.NONE);
		trtmItemA.setText("Item A");

		TreeItem trtmSubitemA = new TreeItem(trtmItemA, SWT.NONE);
		trtmSubitemA.setText("SubItem A");
		trtmSubitemA.setExpanded(true);

		TreeItem trtmSubitemB = new TreeItem(trtmItemA, SWT.NONE);
		trtmSubitemB.setText("SubItem B");

		TreeItem trtmSubitemC = new TreeItem(trtmItemA, SWT.NONE);
		trtmSubitemC.setText("SubItem C");
		trtmItemA.setExpanded(true);

		TreeItem trtmItemB = new TreeItem(tree, SWT.NONE);
		trtmItemB.setText("Item B");

		TreeItem trtmSubitemD = new TreeItem(trtmItemB, SWT.NONE);
		trtmSubitemD.setText("SubItem D");
		trtmItemB.setExpanded(true);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
