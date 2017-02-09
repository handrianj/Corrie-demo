package org.handrianj.corrie.demo.editor;

import java.util.Date;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
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
import org.handrianj.corrie.hermes.datamodel.CellData;
import org.handrianj.corrie.hermes.datamodel.ExcelDocument;
import org.handrianj.corrie.hermes.datamodel.ExcelSheet;
import org.handrianj.corrie.hermes.parser.ExcelReader;
import org.handrianj.corrie.hermes.parser.ExcelWriter;
import org.handrianj.corrie.hermes.ui.tableviewer.ExcelTableColorProvider;
import org.handrianj.corrie.hermes.ui.tableviewer.ExcelTableContentManager;
import org.handrianj.corrie.serviceregistry.ServiceRegistry;
import org.handrianj.corrie.utilsui.IFileDownloadService;

public class TableDemoEditor extends AbstractCorrieEditor<Dummy> {

	private ExcelTableContentManager excelTable;
	private Composite mainCompo;
	private Browser downloader;

	public TableDemoEditor() {
	}

	@Override
	public String getID() {

		return TableDemoEditor.class.getCanonicalName();
	}

	@Override
	public void languageChanged() {
		// noting to do here

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);

	}

	@Override
	public void createPartControl(Composite parent) {

		mainCompo = new Composite(parent, SWT.NONE);
		mainCompo.setLayout(new GridLayout(1, false));

		Composite buttonCompo = new Composite(mainCompo, SWT.NONE);
		buttonCompo.setLayout(new GridLayout(3, false));
		buttonCompo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnImport = new Button(buttonCompo, SWT.NONE);
		btnImport.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnImport.setText("Import Excell");

		Button btnSaveFile = new Button(buttonCompo, SWT.NONE);
		downloader = new Browser(buttonCompo, SWT.NONE);
		GridData gd_downloader = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_downloader.heightHint = 1;
		downloader.setLayoutData(gd_downloader);
		downloader.setVisible(false);
		btnSaveFile.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				ExcelSheet input = excelTable.getInput();
				byte[] writeFile = ExcelWriter.getByteFormat(new ExcelDocument(input));

				Date currentDate = new Date();
				String fileName = currentDate.toString() + ".xlsx";

				IFileDownloadService fileRegistryService = ServiceRegistry.getFileRegistryService();
				fileRegistryService.download(downloader, fileName, writeFile);
			}
		});
		btnSaveFile.setText("Save file");

		btnImport.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);

				String filePath = dialog.open();

				if (filePath != null) {
					ExcelDocument parseFile = ExcelReader.parseFile(filePath);
					excelTable.setInput(parseFile.getFirstPage());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		Composite tabCompo = new Composite(mainCompo, SWT.NONE);
		tabCompo.setLayout(new GridLayout(1, false));
		tabCompo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		excelTable = new ExcelTableContentManager(tabCompo);
		excelTable.setBackgroundColorProvider(new ExcelTableColorProvider() {
			@Override
			public Color getColor(String columnName, Object row) {

				@SuppressWarnings("rawtypes")
				Map excelRow = (Map) row;

				CellData data = (CellData) excelRow.get(columnName);
				if (data != null) {
					String value = data.getValue();

					if (value.compareTo("PS4") == 0) {
						return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE);
					} else if (value.compareTo("Xbox one") == 0) {
						return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW);
					}
					if (value.compareTo("Wii U") == 0) {
						return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
					}

				}

				return null;
			}
		});

	}

	@Override
	public void setFocus() {
		mainCompo.setFocus();

	}

}
