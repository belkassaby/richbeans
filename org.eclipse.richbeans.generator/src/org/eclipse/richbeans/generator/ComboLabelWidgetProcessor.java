package org.eclipse.richbeans.generator;

import static org.metawidget.inspector.InspectionResultConstants.LOOKUP_LABELS;

import java.util.Map;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.metawidget.swt.SwtMetawidget;
import org.metawidget.util.ArrayUtils;
import org.metawidget.widgetprocessor.iface.WidgetProcessor;

/**
 * This processor switches the items in any SWT Combo boxes to the contents of the LOOKUP_LABELS attribute, if defined.
 *
 * TODO With the current databinding implementation, this works well for enums but will break the databinding for String
 * fields which have had lookup labels added in their metadata.
 *
 * @author Colin Palmer
 */
public class ComboLabelWidgetProcessor implements WidgetProcessor<Control, SwtMetawidget> {

	@Override
	public Control processWidget(Control widget, String elementName, Map<String, String> attributes, SwtMetawidget metawidget) {

		// Check if the widget is an SWT Combo
		if (widget instanceof Combo) {
			Combo combo = (Combo) widget;
			String lookupLabels = attributes.get( LOOKUP_LABELS );

			// If lookup labels are defined, use them instead of the existing values
			if ( lookupLabels != null && !"".equals(lookupLabels) ) {

				final String[] labels = ArrayUtils.fromString(lookupLabels);

				for (int i = 0; i < combo.getItemCount(); i++) {
					if (i < labels.length) {
						combo.setItem(i, labels[i]);
					}
				}
			}
		}
		return widget;
	}
}
