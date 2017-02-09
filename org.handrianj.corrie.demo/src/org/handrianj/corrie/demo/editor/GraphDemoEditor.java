package org.handrianj.corrie.demo.editor;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.handrianj.corrie.demo.editor.input.DemoInput;
import org.handrianj.corrie.demo.model.Dummy;
import org.handrianj.corrie.editors.util.editors.AbstractCorrieEditor;
import org.handrianj.corrie.editors.util.editors.ICorrieEditorInput;
import org.handrianj.corrie.graphics.charts.IChart;
import org.handrianj.corrie.graphics.charts.IChartItem;
import org.handrianj.corrie.graphics.charts.impl.CorrieChartOptions;
import org.handrianj.corrie.graphics.generator.ChartsDrawer;

public class GraphDemoEditor extends AbstractCorrieEditor<Dummy> {

	private ChartsDrawer drawer = new ChartsDrawer();
	private Composite graphComposite;
	private IChart currentChart;

	public GraphDemoEditor() {
	}

	@Override
	public String getID() {
		return getClass().getCanonicalName();
	}

	@Override
	public void updateInput(ICorrieEditorInput<Dummy> input) {
		setInput(input);
	}

	@Override
	public void languageChanged() {
		// nothing to do

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (input instanceof DemoInput) {
			setSite(site);
			setInput(input);
		}

	}

	@Override
	public void createPartControl(Composite parent) {

		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayout(new GridLayout(1, false));

		Composite buttonsComposite = new Composite(mainComposite, SWT.NONE);
		buttonsComposite.setLayout(new GridLayout(2, false));
		buttonsComposite.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));

		ComboViewer comboViewer = new ComboViewer(buttonsComposite, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewer.setContentProvider(new ComboContentProvider());
		comboViewer.setLabelProvider(new LabelProvider());
		comboViewer.setInput(new Object());
		comboViewer.setSelection(new StructuredSelection("Bar"));

		Button btnShowLegend = new Button(buttonsComposite, SWT.CHECK);
		btnShowLegend.setSelection(false);
		btnShowLegend.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				currentChart.showLegend(btnShowLegend.getSelection());
			}
		});
		btnShowLegend.setText("Show legend");

		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IChartItem item = getInput().getData().getDoubleTab();

				int selectedIndex = comboViewer.getCombo().getSelectionIndex();
				if ((selectedIndex == 1) || (selectedIndex == 4) || (selectedIndex == 5) || (selectedIndex == 6)) {
					item = getInput().getData().getSingleTab();
				}
				for (Control control : graphComposite.getChildren()) {
					control.dispose();
				}
				currentChart = drawer.drawChart(graphComposite, item, selectedIndex);

			}
		});

		graphComposite = new Composite(mainComposite, SWT.NONE);
		graphComposite.setLayout(new GridLayout(1, false));
		graphComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		Dummy data = getInput().getData();

		CorrieChartOptions defaultOptions = new CorrieChartOptions();
		defaultOptions.setShowFill(true);
		defaultOptions.setScaleShowLabels(false);
		currentChart = drawer.drawChart(graphComposite, data.getSingleTab(), ChartsDrawer.FUNNEL_CHART, defaultOptions);
	}

	@Override
	public void setFocus() {
		graphComposite.setFocus();

	}

	private void updateChart(int key, IChartItem item) {
		Control[] children = graphComposite.getChildren();
		for (Control control : children) {
			control.setVisible(true);
		}
		drawer.drawChart(graphComposite, item, key);

	}
}
