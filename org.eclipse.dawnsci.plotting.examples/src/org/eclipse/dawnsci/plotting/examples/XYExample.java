package org.eclipse.dawnsci.plotting.examples;

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.dawnsci.analysis.api.io.IDataHolder;
import org.eclipse.dawnsci.analysis.api.monitor.IMonitor;
import org.eclipse.dawnsci.plotting.api.PlotType;
import org.eclipse.dawnsci.plotting.examples.util.BundleUtils;
import org.eclipse.swt.widgets.Composite;

/**
 * A basic view which plots xy (1D) data.
 * 
 * This view uses the services available from plotting.api and 
 * analysis.io
 * 
 * @author fcp94556
 *
 */
public class XYExample extends PlotExample {
	
	
	public void createPartControl(Composite parent) {
		try {
			// We create a basic plot
			system.createPlotPart(parent, "XY Example", getViewSite().getActionBars(), PlotType.XY, this);

			// We read an image
			final File        loc     = new File(BundleUtils.getBundleLocation(Activator.PLUGIN_ID), getFileName());
			final IDataHolder allData = service.getData(loc.getAbsolutePath(), new IMonitor.Stub());
			// NOTE IMonitor is an alternative to IProgressMonitor which cannot be seen in the data layer.
			
			// We plot the data
			system.createPlot1D(null, Arrays.asList(allData.getDataset(0), allData.getDataset(1), allData.getDataset(2)), new NullProgressMonitor());
			system.setXFirst(false);
			system.setTitle("XY Example");
			
		} catch (Throwable ne) {
			ne.printStackTrace(); // Or your favourite logging.
		}
    }
	
	protected String getFileName() {
		return "metalmix.mca";
	}


}
