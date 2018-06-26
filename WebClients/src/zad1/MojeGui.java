package zad1;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class MojeGui<ServiceListener> extends JFrame {

	JScrollPane scrollPane;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JPanel zad4odp = new JPanel();
	private JTextField inKraj;
	private JTextField inMiasto;
	private JTextField inUSD;
	private JTextArea zad1odp;
	private JLabel zad2odp;
	private JLabel zad3odp;
	private JButton okButton;

	JFXPanel jfxPanel;

	/**
	 * Launch the application. Przepraszam za kod nie pisałem ręcznie Window Builder
	 */
	public MojeGui() {
		setType(Type.UTILITY);
		setTitle("klient_s12410");
		setAutoRequestFocus(false);

		// SwingUtilities.invokeLater(new Runnable() {
		// public void run() {

		BudujGui();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		// }
		// });

	}

	private void BudujGui() {
		JLabel lblNewLabel_2 = new JLabel("Waluta1");
		JLabel lblNewLabel_1 = new JLabel("Miasto");
		JLabel lblNewLabel = new JLabel("Kraj");

		inKraj = new JTextField();
		inKraj.setText("Poland");
		inKraj.setColumns(10);

		inMiasto = new JTextField();
		inMiasto.setText("Warsaw");
		inMiasto.setColumns(10);

		inUSD = new JTextField();
		inUSD.setText("USD");
		inUSD.setColumns(10);
		setSize(1131, 756);
		okButton = new JButton("Zaakceptuj dane wejsciowe");

		JLabel Pogoda = new JLabel("Pogoda zad1");

		JLabel lblZadkurs = new JLabel("Zad2_Kurs");

		zad2odp = new JLabel("czekam na akceptacje");

		JLabel lblNewLabel_4 = new JLabel("kursNBPzad3");

		zad3odp = new JLabel("czekam na akceptację");

		JLabel lblNewLabel_6 = new JLabel("Zad4");

		JScrollPane zad4odp = new JScrollPane();

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(okButton)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2))
									.addGap(24)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(inKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(inUSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(inMiasto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblZadkurs)
							.addGap(18)
							.addComponent(zad2odp))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(zad3odp))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(Pogoda)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(365)
							.addComponent(lblNewLabel_6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(zad4odp, GroupLayout.PREFERRED_SIZE, 828, GroupLayout.PREFERRED_SIZE)))
					.addGap(514))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(inKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(inMiasto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(inUSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(44)
									.addComponent(okButton)))
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(Pogoda)
							.addGap(31)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblZadkurs)
								.addComponent(zad2odp))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(zad3odp))
							.addGap(240))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(zad4odp, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);

		zad1odp = new JTextArea();
		scrollPane_2.setViewportView(zad1odp);

		jfxPanel = new JFXPanel();
		zad4odp.setRowHeaderView(jfxPanel);
		getContentPane().setLayout(groupLayout);

	}

	public String getInKraj() {
		return inKraj.getText();
	}

	public void setInKraj(String inKraj) {
		if (inKraj.isEmpty())
			JOptionPane.showMessageDialog(null, "Pole kraj nie może być puste");
		else
			this.inKraj.setText(inKraj);
	}

	public String getInMiasto() {
		return inMiasto.getText();
	}

	public void setInMiasto(String string) {
		if (string.isEmpty())
			JOptionPane.showMessageDialog(inMiasto, "Nie wi");
		else
			inMiasto.setText(string);
	}

	public JTextField getInUSD() {
		return inUSD;
	}

	public void setInUSD(String string) {
		if (string.isEmpty())
			JOptionPane.showMessageDialog(null, "Brak waluty którą chcesz porównać");
		else
			this.inUSD.setText(string);
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public JTextArea getZad1odp() {

		return zad1odp;
	}

	public void setZad1odp(String string) {
		this.zad1odp.setText(string);
	}

	public JLabel getZad2odp() {
		return zad2odp;
	}

	public void setZad2odp(String string) {
		this.zad2odp.setText(string);
	}

	public JLabel getZad3odp() {
		return zad3odp;
	}

	public void setZad3odp(Double double1) {
		this.zad3odp.setText(double1.toString());

	}

	public void setZad4Odp(String miasto) {
		Platform.runLater(() -> {
			WebView webWiew = new WebView();
			jfxPanel.setScene(new Scene(webWiew));
			webWiew.getEngine().load("https://pl.wikipedia.org/wiki/" + miasto);

		});

		jfxPanel.repaint();
	}

	public void inputData(ActionListener serviceLis) {
		// TODO Auto-generated method stub
		okButton.addActionListener(serviceLis);

	}
}
