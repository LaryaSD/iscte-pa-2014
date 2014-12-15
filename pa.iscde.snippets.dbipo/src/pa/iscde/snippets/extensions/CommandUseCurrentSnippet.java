package pa.iscde.snippets.extensions;

import pa.iscde.commands.internal.services.Command;
import pa.iscde.snippets.gui.SnippetsView;

public class CommandUseCurrentSnippet implements Command {

	@Override
	public void action() {
		SnippetsView.getInstance().useCommandSnippet();
	}

}
