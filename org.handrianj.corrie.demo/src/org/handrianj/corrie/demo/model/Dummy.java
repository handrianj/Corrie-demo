package org.handrianj.corrie.demo.model;

import org.handrianj.corrie.graphics.charts.items.impl.MultipleValueChartItem;
import org.handrianj.corrie.graphics.charts.items.impl.SingleValueChartItem;

public class Dummy {

	public SingleValueChartItem<Float> getSingleTab() {

		SingleValueChartItem<Float> values = new SingleValueChartItem<>();

		values.setValue("Javascript", 323938f);
		values.setValue("Java", 222852f);
		values.setValue("Python", 164852f);
		values.setValue("PHP", 138771f);

		return values;

	}

	public MultipleValueChartItem<Float> getDoubleTab() {

		MultipleValueChartItem<Float> doubleTab = new MultipleValueChartItem<>();

		doubleTab.setValues("PS4", 4430139f, 14560282f, 17365675f, 3358578f);
		doubleTab.setValues("XOne", 3075770f, 7908581f, 8596179f, 1132784f);
		doubleTab.setValues("WiiU", 3113285f, 3644476f, 3555391f, 517719f);
		doubleTab.addAttributeTitle("2013");
		doubleTab.addAttributeTitle("2014");
		doubleTab.addAttributeTitle("2015");
		doubleTab.addAttributeTitle("2016");

		return doubleTab;

	}

}
