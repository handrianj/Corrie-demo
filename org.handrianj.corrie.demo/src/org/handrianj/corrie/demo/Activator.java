package org.handrianj.corrie.demo;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.handrianj.corrie.dblink.services.IConstantService;
import org.handrianj.corrie.dblink.services.IDBSessionService;
import org.handrianj.corrie.demo.services.ConstantServiceDemo;
import org.handrianj.corrie.demo.services.DBSessionServiceDemo;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.handrianj.corrie.demo"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// Declaring IDBSessionService
		context.registerService(IDBSessionService.class, new DBSessionServiceDemo(), null);

		// Declaring IConstantService
		context.registerService(IConstantService.class, new ConstantServiceDemo(), null);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
