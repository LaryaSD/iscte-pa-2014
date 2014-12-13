package pa.iscde.commands.trvms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import pa.iscde.commands.models.CommandWarehouse;
import pa.iscde.filtersearch.providers.SearchProvider;
import pt.iscte.pidesco.extensibility.PidescoServices;

public class CommandsSearch implements SearchProvider {

	public CommandsSearch() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Object> getResults(String text) {
		return new LinkedList<Object>(Arrays.asList(CommandWarehouse.getInstance().getAllCommandDefinitions().toArray()));
	}

	@Override
	public Image setImage(Object object) {
		BundleContext context = FrameworkUtil.getBundle(CommandWarehouse.class).getBundleContext();
		ServiceReference<PidescoServices> serviceReference_pidesco = context.getServiceReference(PidescoServices.class);
		PidescoServices pidescoServices = context.getService(serviceReference_pidesco);
		
		return pidescoServices.getImageFromPlugin("pa.iscde.commands", "keygroups_obj.gif");
	}

	@Override
	public void doubleClickAction(TreeViewer tree, Object object) {
		System.out.println("Cliquei: " + object);

	}

}