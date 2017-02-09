package org.handrianj.corrie.demo.editor;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.handrianj.corrie.graphics.charts.IMultipleValueItem;

public class ComboContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {
		// nothing to do

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// nothing to do

	}

	/**
	 * Draws a line chart, uses a {@link IMultipleValueItem} for rendering
	 */
	public static final int LINE_CHART = 0;

	@Override
	public Object[] getElements(Object inputElement) {

		return new Object[] { "Line", "Pie", "Bar", "Radar", "Polar", "Doughnut", "Funnel" };
	}

}
