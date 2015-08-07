package org.eclipse.richbeans.generator;

import org.eclipse.richbeans.api.generator.IGuiGeneratorService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.metawidget.inspectionresultprocessor.commons.jexl.JexlInspectionResultProcessor;
import org.metawidget.inspectionresultprocessor.iface.InspectionResultProcessor;
import org.metawidget.swt.SwtMetawidget;
import org.metawidget.swt.widgetprocessor.binding.databinding.DataBindingProcessor;

public class GuiGeneratorService implements IGuiGeneratorService {

	@Override
	public Composite generateGui(Object bean, Composite parent) {

		SwtMetawidget metawidget = new SwtMetawidget(parent, SWT.NONE);

		// TODO data binding!

		InspectionResultProcessor<SwtMetawidget> jexlProcessor = new JexlInspectionResultProcessor<SwtMetawidget>();
		metawidget.addInspectionResultProcessor(jexlProcessor);

		metawidget.setToInspect(bean);

		return metawidget;
	}

}
