package quanto.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import quanto.core.Core;

/*
 * Tabbed Pane containing the RulesBar and the Toolbox.
 * Instanciated in QuantoFrame
 */
public class LeftTabbedPane extends JPanel {

	private Toolbox toolbox;
	private JTabbedPane tabbedPane;

	public LeftTabbedPane(Core core, ViewPort viewPort) {

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		tabbedPane = new JTabbedPane();
		RulesBar sidebar = new RulesBar(core.getRuleset(), viewPort);
		tabbedPane.addTab("Rules", null, sidebar,
				"Display Ruleset");

		toolbox = new Toolbox(core, viewPort);
		tabbedPane.addTab("Toolbox", null, toolbox, "Display Toolbox");

		this.add(tabbedPane);
	}

	public void setToolbox(Toolbox toolbox) {
		this.tabbedPane.remove(this.toolbox);
		this.tabbedPane.addTab("Toolbox", null, toolbox, "Display Toolbox");
	}
}
