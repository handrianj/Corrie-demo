package org.handrianj.corrie.demo.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.handrianj.corrie.demo.model.Dummy;
import org.handrianj.corrie.editors.util.editors.AbstractCorrieEditor;
import org.handrianj.corrie.graphics.charts.IChart;
import org.handrianj.corrie.graphics.charts.impl.CorrieChartOptions;
import org.handrianj.corrie.graphics.charts.items.impl.MultipleValueChartItem;
import org.handrianj.corrie.graphics.generator.ChartsDrawer;
import org.handrianj.corrie.hermes.datamodel.CellData;
import org.handrianj.corrie.hermes.datamodel.ExcelDocument;
import org.handrianj.corrie.hermes.datamodel.ExcelSheet;
import org.handrianj.corrie.hermes.parser.ExcelReader;
import org.handrianj.corrie.hermes.ui.tableviewer.ExcelTableContentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Editor used to show interactions between different components
 *
 * @author Heri Andrianjafy
 *
 */
public class CompositeEditor extends AbstractCorrieEditor<Dummy> {

	private IChart drawChart;
	private Composite composite;
	private ExcelTableContentManager excelTable;
	private Logger logger;

	public CompositeEditor() {
		logger = LoggerFactory.getLogger(CompositeEditor.class);
	}

	@Override
	public String getID() {
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

		logger.info("MIAOU");

		if (logger.isDebugEnabled()) {
			logger.debug("DEBUG");
		} else {
			logger.info("Logger not in debug");
		}

		// Use a composite to regroupe the two components
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		// Begining of the import component
		Composite table = new Composite(composite, SWT.NONE);
		table.setLayout(new GridLayout(1, false));
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite btnComposite = new Composite(table, SWT.NONE);
		btnComposite.setLayout(new GridLayout(1, false));
		btnComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));

		Button btnNewButton = new Button(btnComposite, SWT.NONE);
		btnNewButton.setBounds(0, 0, 75, 25);
		btnNewButton.setText("Import Excell");

		// Selection listener for the import file
		btnNewButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.APPLICATION_MODAL);

				String filePath = dialog.open();

				if (filePath != null) {

					// Import the excell file
					ExcelDocument parseFile = ExcelReader.parseFile(filePath);
					ExcelSheet firstPage = parseFile.getFirstPage();
					excelTable.setInput(firstPage);

					// Convert the data into a multiple chart value item
					List<String> titles = new ArrayList<>(firstPage.getTitles());

					// Data for the chart
					MultipleValueChartItem<Float> allValues = new MultipleValueChartItem<>();

					int i = 0;
					List<LinkedHashMap<String, CellData>> allRows = firstPage.getRows();

					// Get the values for each row
					for (LinkedHashMap<String, CellData> linkedHashMap : allRows) {
						Collection<CellData> values = linkedHashMap.values();
						ArrayList<Float> floatValues = new ArrayList<>();
						for (CellData data : values) {
							try {
								floatValues.add(Float.parseFloat(data.getValue()));
							} catch (NumberFormatException ne) {

							}
						}

						// Set the value into the data chart
						allValues.setValues("Row " + i++, floatValues.toArray(new Float[floatValues.size()]));

					}

					// Add all the titles
					for (String currentTitle : titles) {
						allValues.addAttributeTitle(currentTitle);
					}

					// Sets the data to the chart
					drawChart.setData(allValues);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		// Create the composite for the table
		Composite excellTab = new Composite(table, SWT.NONE);
		excellTab.setLayout(new GridLayout(1, false));
		excellTab.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		excelTable = new ExcelTableContentManager(excellTab);

		// Create the composite for the graph
		Composite graph = new Composite(composite, SWT.NONE);
		graph.setLayout(new GridLayout(1, false));
		graph.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// Draws the chart
		ChartsDrawer drawer = new ChartsDrawer();
		MultipleValueChartItem<Float> multipleValueChartItem = new MultipleValueChartItem<>();
		multipleValueChartItem.addAttributeTitle("TEST");
		multipleValueChartItem.setValues("Test", 2f);
		CorrieChartOptions options = new CorrieChartOptions();
		options.setShowFill(false);
		options.setBezierCurve(false);
		options.setShowLegend(true);
		drawChart = drawer.drawChart(graph, multipleValueChartItem, ChartsDrawer.LINE_CHART, options);

	}

	@Override
	public void setFocus() {
		composite.setFocus();

	}

}
