import javax.swing.JFrame; 
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextPane;

import org.jfree.ui.RefineryUtilities;

public class DoctorGUI {

	private Patient currentPatient;
	public JFrame frame;
	private JList<String> patientList;
	private JPanel doctorMain;
	private int day, month, year;
	private JComboBox<String> dayComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> yearComboBox;
	private MouseListener mouseListener;
	private JPanel editAccount;
	private JList<String> visitList;
	private Doctor tempDoctor;
	private JTextField fieldPrescription;
	private JTextField fieldTemperature;
	private JTextField fieldWeight;
	private JTextField fieldDiastolic;
	private JTextField fieldBloodSugar;
	private JTextField fieldHeight;
	private JTextField fieldSystolic;
	private JLabel lblDate;
	private JTextPane fieldSymptoms, fieldNotes;
	private JPanel medicalHistoryPanel;
	private JTabbedPane tabbedPane;

	public DoctorGUI() {
		initialize();
	}

	// sets the Medical Record fields
	// used by getSelected and getMostRecent buttons
	public void setInformationFields(Visit selectedVisit) {
		String[] visitArray = selectedVisit.visitToArray();

		fieldTemperature.setText(visitArray[0]);
		fieldWeight.setText(visitArray[1]);
		fieldHeight.setText(visitArray[2]);
		fieldSystolic.setText(visitArray[3]);
		fieldDiastolic.setText(visitArray[4]);
		fieldBloodSugar.setText(visitArray[5]);
		fieldPrescription.setText(visitArray[6]);
		fieldNotes.setText(visitArray[7]);
		fieldSymptoms.setText(visitArray[8]);
		lblDate.setText(selectedVisit.getDate());

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(700, 350, 876, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);

		JMenuItem menuSave = new JMenuItem("Save ");
		mnNewMenu.add(menuSave);
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Globals.fileHandler.saveDatabase();
				} catch (IOException e1) {
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null,
							"There was a problem with saving to the file",
							"Error", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					e1.printStackTrace();
				}
			}
		});

		JMenuItem menuLogout = new JMenuItem("Logout");
		mnNewMenu.add(menuLogout);
		menuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
			}
		});
		JMenuItem menuEditAccount = new JMenuItem("Edit Account");
		mnNewMenu.add(menuEditAccount);
		menuEditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(editAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});

		tempDoctor = (Doctor) Globals.userDatabase.getCurrentUser();

		mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList<String> patientList = (JList<String>) mouseEvent
						.getSource();
				if (mouseEvent.getClickCount() == 1) {
					patientList.removeAll();
					int index = patientList.getSelectedIndex();
					if (index >= 0) {
						Patient tempPatient = tempDoctor.getPatient(index);
						visitList.setListData(tempPatient.getMedicalRecord()
								.toArray());
						currentPatient = tempPatient;
					}

				}
			}
		};

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_9667629789687");
		tabbedPane.setBorder(UIManager.getBorder("CheckBox.border"));

		doctorMain = new JPanel();
		doctorMain.setBackground(Color.WHITE);
		tabbedPane.addTab("My Account", null, doctorMain, null);
		doctorMain.setLayout(null);

		JLabel lblNurse = new JLabel("Doctor");
		lblNurse.setForeground(SystemColor.textHighlight);
		lblNurse.setFont(new Font("Consolas", Font.BOLD, 17));
		lblNurse.setBounds(739, 11, 77, 27);
		doctorMain.add(lblNurse);

		JLabel lblWelcome = new JLabel("Welcome " + Globals.userDatabase.getCurrentUser().getUserName());
		lblWelcome.setForeground(SystemColor.textHighlight);
		lblWelcome.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblWelcome.setBounds(206, 60, 316, 27);
		doctorMain.add(lblWelcome);
	

		medicalHistoryPanel = new JPanel();
		medicalHistoryPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Patient Records", null, medicalHistoryPanel, null);
		medicalHistoryPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(324, 57, 181, 130);
		medicalHistoryPanel.add(scrollPane);
		visitList = new JList<String>();
		scrollPane.setViewportView(visitList);
		visitList.setFont(new Font("Monospaced", Font.BOLD, 13));
		visitList.setBorder(UIManager
				.getBorder("List.focusCellHighlightBorder"));

		JButton btnSearchVisit = new JButton("Search");
		btnSearchVisit.setBounds(326, 306, 179, 42);
		medicalHistoryPanel.add(btnSearchVisit);
		btnSearchVisit.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(
				192, 192, 192), null, null, null));
		btnSearchVisit.setForeground(SystemColor.textHighlight);
		btnSearchVisit.setBackground(Color.WHITE);
		btnSearchVisit.setFont(new Font("Consolas", Font.PLAIN, 11));

		JButton btnGetSelected = new JButton("Get Selected");
		btnGetSelected.setBounds(324, 198, 179, 42);
		medicalHistoryPanel.add(btnGetSelected);
		btnGetSelected.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(
				192, 192, 192), null, null, null));
		btnGetSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = visitList.getSelectedIndex();
				if (index >= 0) {

					Visit tempVisit = tempDoctor
							.getPatient(patientList.getSelectedIndex())
							.getMedicalRecord().getVisit(index);
					if (tempVisit != null) {
						setInformationFields(tempVisit);
					}
				}
			}
		});

		btnGetSelected.setForeground(Color.BLACK);
		btnGetSelected.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGetSelected.setBackground(Color.WHITE);

		JLabel lblMedicalRecord = new JLabel("Medical Record");
		lblMedicalRecord.setBounds(691, 19, 170, 27);
		medicalHistoryPanel.add(lblMedicalRecord);
		lblMedicalRecord.setForeground(Color.BLACK);
		lblMedicalRecord.setFont(new Font("Consolas", Font.BOLD, 17));
		yearComboBox = new JComboBox<String>();
		yearComboBox.setBounds(447, 281, 58, 20);
		medicalHistoryPanel.add(yearComboBox);

		yearComboBox.setBackground(Color.WHITE);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");

		JButton btnGetMostRecent = new JButton("Get Most Recent ");
		btnGetMostRecent.setBounds(324, 416, 181, 42);
		medicalHistoryPanel.add(btnGetMostRecent);
		btnGetMostRecent.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnGetMostRecent.setForeground(Color.BLACK);
		btnGetMostRecent.setBackground(Color.WHITE);
		btnGetMostRecent.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox = new JComboBox<String>();
		monthComboBox.setBounds(324, 281, 58, 20);
		medicalHistoryPanel.add(monthComboBox);

		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(Color.WHITE);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox = new JComboBox<String>();
		dayComboBox.setBounds(385, 281, 60, 20);
		medicalHistoryPanel.add(dayComboBox);

		dayComboBox.setBackground(Color.WHITE);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(336, 267, 46, 14);
		medicalHistoryPanel.add(lblMonth);
		lblMonth.setFont(new Font("Consolas", Font.PLAIN, 10));
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(457, 267, 46, 14);
		medicalHistoryPanel.add(lblYear);
		lblYear.setFont(new Font("Consolas", Font.PLAIN, 10));
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(401, 267, 44, 14);
		medicalHistoryPanel.add(lblDay);
		lblDay.setFont(new Font("Consolas", Font.PLAIN, 10));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 57, 181, 401);
		medicalHistoryPanel.add(scrollPane_1);

		patientList = new JList(tempDoctor.getPatientNames());
		scrollPane_1.setViewportView(patientList);

		JSeparator separator = new JSeparator();
		separator.setBounds(258, -12, 15, 566);
		medicalHistoryPanel.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);

		JLabel lblPatientRecords = new JLabel("Patient Records");
		lblPatientRecords.setBounds(477, -2, 190, 27);
		medicalHistoryPanel.add(lblPatientRecords);
		lblPatientRecords.setForeground(SystemColor.textHighlight);
		lblPatientRecords.setFont(new Font("Consolas", Font.BOLD, 17));

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[] doubleInputs = { fieldSystolic.getText(),
						fieldDiastolic.getText(), fieldBloodSugar.getText(),
						fieldWeight.getText(), fieldHeight.getText(),
						fieldTemperature.getText() };

				Double[] doubleArray = Globals.inputHandler
						.checkDoubleInputs(doubleInputs);

				if (doubleArray != null) {
					String symptoms, notes, prescription;

					if (Globals.inputHandler.checkInputSize(doubleArray) == 0) {

						symptoms = fieldSymptoms.getText();
						notes = fieldNotes.getText();
						prescription = fieldPrescription.getText();

						Visit editedVisit = null;
						if (patientList.getSelectedIndex() >= 0) {
							if (visitList.getSelectedIndex() >= 0) {
								Doctor currentDoctor = (Doctor) Globals.userDatabase
										.getCurrentUser();
								editedVisit = currentDoctor
										.getPatient(
												patientList.getSelectedIndex())
										.getMedicalRecord()
										.getVisit(visitList.getSelectedIndex());
							}
						}

						if (editedVisit != null) {

							editedVisit.setBloodPressureTop(doubleArray[0]);
							editedVisit.setBloodPressureBot(doubleArray[1]);
							editedVisit.setSugar(doubleArray[2]);
							editedVisit.setWeight(doubleArray[3]);
							editedVisit.setHeight(doubleArray[4]);
							editedVisit.setTemperature(doubleArray[5]);
							editedVisit.setPrescription(prescription);
							editedVisit.setNotes(notes);
							editedVisit.setSymptoms(symptoms);

							Object[] options = { "OK" };
							JOptionPane.showOptionDialog(null,
									"Patient Form for was updated.",
									"Entry Updated",
									JOptionPane.DEFAULT_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									options, options[0]);
							
							try {
								Globals.fileHandler.saveDatabase();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							frame.getContentPane().removeAll();
							frame.getContentPane().invalidate();
							frame.getContentPane().add(tabbedPane);
							tabbedPane.setSelectedIndex(1);
							frame.getContentPane().revalidate();
							frame.repaint();
						}

						else {
							Object[] options = { "OK" };
							JOptionPane.showOptionDialog(null,
									"Please select a entry from the list",
									"No Patient Selected",
									JOptionPane.DEFAULT_OPTION,
									JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);
						}
					} else {
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null,
								"Please check inputs for errors",
								"Input out of Bounds",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
					}

				} else {
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null,
							"Please check inputs for errors",
							"Wrong input type", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
				}

			}

		});

		btnUpdate.setBounds(677, 415, 160, 42);
		medicalHistoryPanel.add(btnUpdate);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Consolas", Font.PLAIN, 14));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(SystemColor.textHighlight);

		JLabel lblPatientSelection = new JLabel("Patient Selection");
		lblPatientSelection.setBounds(44, -2, 170, 27);
		medicalHistoryPanel.add(lblPatientSelection);
		lblPatientSelection.setForeground(SystemColor.textHighlight);
		lblPatientSelection.setFont(new Font("Consolas", Font.BOLD, 17));

		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodPressure.setFont(new Font("Consolas", Font.BOLD, 13));
		lblBloodPressure.setBounds(541, 173, 126, 14);
		medicalHistoryPanel.add(lblBloodPressure);

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeight.setFont(new Font("Consolas", Font.BOLD, 13));
		lblWeight.setBounds(621, 284, 46, 14);
		medicalHistoryPanel.add(lblWeight);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeight.setFont(new Font("Consolas", Font.BOLD, 13));
		lblHeight.setBounds(621, 320, 46, 14);
		medicalHistoryPanel.add(lblHeight);

		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemperature.setFont(new Font("Consolas", Font.BOLD, 13));
		lblTemperature.setBounds(581, 253, 86, 14);
		medicalHistoryPanel.add(lblTemperature);

		JLabel lblNewLabel_1 = new JLabel("Blood Sugar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_1.setBounds(581, 212, 86, 14);
		medicalHistoryPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_2.setBounds(596, 57, 71, 14);
		medicalHistoryPanel.add(lblNewLabel_2);

		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSymptoms.setFont(new Font("Consolas", Font.BOLD, 13));
		lblSymptoms.setBounds(596, 82, 71, 14);
		medicalHistoryPanel.add(lblSymptoms);

		JLabel lblNotes_1 = new JLabel("Notes");
		lblNotes_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotes_1.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNotes_1.setBounds(609, 120, 58, 14);
		medicalHistoryPanel.add(lblNotes_1);

		JLabel lblPrescriptions = new JLabel("Prescription & Dosage");
		lblPrescriptions.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrescriptions.setFont(new Font("Consolas", Font.BOLD, 11));
		lblPrescriptions.setBounds(504, 376, 163, 14);
		medicalHistoryPanel.add(lblPrescriptions);

		fieldPrescription = new JTextField();
		fieldPrescription.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldPrescription.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldPrescription.setBounds(677, 367, 160, 31);
		medicalHistoryPanel.add(fieldPrescription);
		fieldPrescription.setColumns(10);

		fieldTemperature = new JTextField();
		fieldTemperature.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldTemperature.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldTemperature.setColumns(10);
		fieldTemperature.setBounds(677, 249, 46, 20);
		medicalHistoryPanel.add(fieldTemperature);

		fieldWeight = new JTextField();
		fieldWeight.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldWeight.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldWeight.setColumns(10);
		fieldWeight.setBounds(677, 280, 46, 20);
		medicalHistoryPanel.add(fieldWeight);

		fieldDiastolic = new JTextField();
		fieldDiastolic.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldDiastolic.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldDiastolic.setColumns(10);
		fieldDiastolic.setBounds(746, 167, 46, 20);
		medicalHistoryPanel.add(fieldDiastolic);

		fieldBloodSugar = new JTextField();
		fieldBloodSugar.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldBloodSugar.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldBloodSugar.setColumns(10);
		fieldBloodSugar.setBounds(677, 208, 46, 20);
		medicalHistoryPanel.add(fieldBloodSugar);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(677, 82, 160, 27);
		medicalHistoryPanel.add(scrollPane_2);

		fieldSymptoms = new JTextPane();
		fieldSymptoms.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldSymptoms.setBorder(null);
		scrollPane_2.setViewportView(fieldSymptoms);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(677, 120, 160, 42);
		medicalHistoryPanel.add(scrollPane_3);

		fieldNotes = new JTextPane();
		fieldNotes.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldNotes.setBorder(null);
		scrollPane_3.setViewportView(fieldNotes);

		fieldHeight = new JTextField();
		fieldHeight.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldHeight.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldHeight.setColumns(10);
		fieldHeight.setBounds(677, 316, 46, 20);
		medicalHistoryPanel.add(fieldHeight);

		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(731, 171, 15, 14);
		medicalHistoryPanel.add(lblNewLabel_3);

		lblDate = new JLabel("");
		lblDate.setFont(new Font("Consolas", Font.BOLD, 13));
		lblDate.setBounds(677, 57, 91, 14);
		medicalHistoryPanel.add(lblDate);

		fieldSystolic = new JTextField();
		fieldSystolic.setFont(new Font("Monospaced", Font.PLAIN, 11));
		fieldSystolic.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		fieldSystolic.setColumns(10);
		fieldSystolic.setBounds(677, 167, 46, 20);
		medicalHistoryPanel.add(fieldSystolic);
		
		JPanel viewProgress = new JPanel();
		viewProgress.setBackground(Color.WHITE);
		tabbedPane.addTab("Charts and Analysis", null, viewProgress, null);
		viewProgress.setLayout(null);

		JButton btnBloodPressure = new JButton("Blood Pressure");
		btnBloodPressure.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnBloodPressure.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnBloodPressure.setBackground(Color.WHITE);
		btnBloodPressure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentPatient != null)
				{
				Chart bloodPressureChart = new Chart(Globals.BLOODPRESSURE,
						Globals.BARCHART3D, currentPatient);
				bloodPressureChart.pack();
				RefineryUtilities.centerFrameOnScreen(bloodPressureChart);
				bloodPressureChart.setVisible(true);
				}
			}
		});
		btnBloodPressure.setBounds(53, 178, 157, 48);
		viewProgress.add(btnBloodPressure);

		JButton btnHeightWeightChart = new JButton("Weight vs Height");
		btnHeightWeightChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				new Color(192, 192, 192), null, null, null));
		btnHeightWeightChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnHeightWeightChart.setBackground(Color.WHITE);
		btnHeightWeightChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart heightWeightChart = new Chart(Globals.HEIGHTWEIGHT,
						Globals.BARCHART3D, currentPatient);
				heightWeightChart.pack();
				RefineryUtilities.centerFrameOnScreen(heightWeightChart);
				heightWeightChart.setVisible(true);
			}}
		});
		btnHeightWeightChart.setBounds(53, 115, 157, 48);
		viewProgress.add(btnHeightWeightChart);

		JButton btnWeightLineChart = new JButton("Weight");
		btnWeightLineChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnWeightLineChart.setBackground(Color.WHITE);
		btnWeightLineChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnWeightLineChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart weightLineChart = new Chart(Globals.WEIGHT,
						Globals.LINECHART, currentPatient);
				weightLineChart.pack();
				RefineryUtilities.centerFrameOnScreen(weightLineChart);
				weightLineChart.setVisible(true);
				}
			}
		});
		btnWeightLineChart.setBounds(343, 178, 157, 48);
		viewProgress.add(btnWeightLineChart);

		JButton btnHeightLineChart = new JButton("Height");
		btnHeightLineChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnHeightLineChart.setBackground(Color.WHITE);
		btnHeightLineChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnHeightLineChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart heightLineChart = new Chart(Globals.HEIGHT,
						Globals.LINECHART, currentPatient);
				heightLineChart.pack();
				RefineryUtilities.centerFrameOnScreen(heightLineChart);
				heightLineChart.setVisible(true);
				}
			}
		});
		btnHeightLineChart.setBounds(343, 237, 157, 48);
		viewProgress.add(btnHeightLineChart);

		JButton btnSugarLineChart = new JButton("Blood Sugar");
		btnSugarLineChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnSugarLineChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnSugarLineChart.setBackground(Color.WHITE);
		btnSugarLineChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart sugarLineChart = new Chart(Globals.BLOODSUGAR,
						Globals.LINECHART, currentPatient);
				sugarLineChart.pack();
				RefineryUtilities.centerFrameOnScreen(sugarLineChart);
				sugarLineChart.setVisible(true);
				}
			}
		});
		btnSugarLineChart.setBounds(343, 115, 157, 48);
		viewProgress.add(btnSugarLineChart);

		JButton btnWeightBarChart = new JButton("Weight");
		btnWeightBarChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnWeightBarChart.setBackground(Color.WHITE);
		btnWeightBarChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnWeightBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart weightBarChart = new Chart(Globals.WEIGHT,
						Globals.BARCHART, currentPatient);
				weightBarChart.pack();
				RefineryUtilities.centerFrameOnScreen(weightBarChart);
				weightBarChart.setVisible(true);
				}
			}
		});
		btnWeightBarChart.setBounds(638, 178, 157, 48);
		viewProgress.add(btnWeightBarChart);

		JButton btnHeightBarChart = new JButton("Height");
		btnHeightBarChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnHeightBarChart.setBackground(Color.WHITE);
		btnHeightBarChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnHeightBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart heightBarChart = new Chart(Globals.HEIGHT,
						Globals.BARCHART, currentPatient);
				heightBarChart.pack();
				RefineryUtilities.centerFrameOnScreen(heightBarChart);
				heightBarChart.setVisible(true);
				}

			}
		});
		btnHeightBarChart.setBounds(638, 237, 157, 48);
		viewProgress.add(btnHeightBarChart);

		JButton btnSugarBarChart = new JButton("Blood Sugar");
		btnSugarBarChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnSugarBarChart.setBackground(Color.WHITE);
		btnSugarBarChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnSugarBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart sugarBarChart = new Chart(Globals.BLOODSUGAR,
						Globals.BARCHART, currentPatient);
				sugarBarChart.pack();
				RefineryUtilities.centerFrameOnScreen(sugarBarChart);
				sugarBarChart.setVisible(true);
				}
			}
		});
		btnSugarBarChart.setBounds(638, 115, 157, 48);
		viewProgress.add(btnSugarBarChart);

		JLabel lblBarCharts = new JLabel("Bar Charts");
		lblBarCharts.setFont(new Font("Consolas", Font.BOLD, 17));
		lblBarCharts.setForeground(SystemColor.textHighlight);
		lblBarCharts.setBackground(Color.WHITE);
		lblBarCharts.setBounds(645, 46, 140, 29);
		viewProgress.add(lblBarCharts);

		JLabel lblLineCharts = new JLabel("Line Charts");
		lblLineCharts.setForeground(SystemColor.textHighlight);
		lblLineCharts.setFont(new Font("Consolas", Font.BOLD, 17));
		lblLineCharts.setBackground(Color.WHITE);
		lblLineCharts.setBounds(374, 43, 126, 35);
		viewProgress.add(lblLineCharts);

		JLabel lbldBarCharts = new JLabel("3D Bar Charts");
		lbldBarCharts.setForeground(SystemColor.textHighlight);
		lbldBarCharts.setFont(new Font("Consolas", Font.BOLD, 17));
		lbldBarCharts.setBackground(Color.WHITE);
		lbldBarCharts.setBounds(64, 43, 146, 35);
		viewProgress.add(lbldBarCharts);

		JSeparator separator2 = new JSeparator();
		separator2.setBackground(Color.BLACK);
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(270, 0, 21, 483);
		viewProgress.add(separator2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(565, 0, 35, 483);
		viewProgress.add(separator_2);

		JButton btnheightWeightLineChart = new JButton("Weight vs Height");
		btnheightWeightLineChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentPatient != null)
				{
				Chart heightWeightChart2 = new Chart(Globals.HEIGHTWEIGHT,
						Globals.LINECHART, currentPatient);
				heightWeightChart2.pack();
				RefineryUtilities.centerFrameOnScreen(heightWeightChart2);
				heightWeightChart2.setVisible(true);
				}
			}
		});
		btnheightWeightLineChart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnheightWeightLineChart.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnheightWeightLineChart.setBackground(Color.WHITE);
		btnheightWeightLineChart.setBounds(343, 296, 157, 48);
		viewProgress.add(btnheightWeightLineChart);

		JButton btnBloodPressure2 = new JButton("Blood Pressure");
		btnBloodPressure2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPatient != null)
				{
				Chart bloodPressureChart2 = new Chart(Globals.BLOODPRESSURE,
						Globals.LINECHART, currentPatient);
				bloodPressureChart2.pack();
				RefineryUtilities.centerFrameOnScreen(bloodPressureChart2);
				bloodPressureChart2.setVisible(true);
				}
			}
		});
		btnBloodPressure2.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnBloodPressure2.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnBloodPressure2.setBackground(Color.WHITE);
		btnBloodPressure2.setBounds(343, 355, 157, 48);
		viewProgress.add(btnBloodPressure2);

		tabbedPane.addTab("View Patient Progress", null, viewProgress, null);
		btnGetMostRecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visit tempVisit = tempDoctor
						.getPatient(patientList.getSelectedIndex())
						.getMedicalRecord().getLastVisit();
				if (tempVisit != null) {
					setInformationFields(tempVisit);
				}

			}
		});
		btnSearchVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				day = Integer
						.parseInt(dayComboBox.getSelectedItem().toString());
				month = Integer.parseInt(monthComboBox.getSelectedItem()
						.toString());
				year = Integer.parseInt(yearComboBox.getSelectedItem()
						.toString());

				Visit tempVisit = tempDoctor
						.getPatient(patientList.getSelectedIndex())
						.getMedicalRecord().getVisit(month, day, year);
				if (tempVisit != null) {
					setInformationFields(tempVisit);
				}
				if (tempVisit == null) {
					// information box
				}
			}
		});
		patientList.addMouseListener(mouseListener);

		editAccount = new JPanel();
		frame.getContentPane().add(editAccount, "name_46184208883226");
		editAccount.setBackground(Color.WHITE);
		editAccount.setLayout(null);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBorder(new BevelBorder(BevelBorder.RAISED,
				new Color(128, 128, 128), null, null, null));
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnChangePassword.setBackground(Color.WHITE);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				window.setToPassword();
			}
		});
		btnChangePassword.setBounds(341, 286, 211, 67);
		editAccount.add(btnChangePassword);

		JButton btnBack = new JButton("BACK");
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(160,
				160, 160), null, null, null));
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(tabbedPane);
				tabbedPane.setSelectedIndex(0);
				frame.getContentPane().revalidate();
				frame.repaint();

			}
		});
		btnBack.setBounds(10, 11, 114, 23);
		editAccount.add(btnBack);

		JButton btnSetUpSecurity = new JButton("Add Security Features");
		btnSetUpSecurity.setBorder(new BevelBorder(BevelBorder.RAISED,
				new Color(128, 128, 128), null, null, null));
		btnSetUpSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				window.setToAnswerQuestions();
			}
		});
		btnSetUpSecurity.setForeground(Color.BLACK);
		btnSetUpSecurity.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnSetUpSecurity.setBackground(Color.WHITE);
		btnSetUpSecurity.setBounds(341, 117, 211, 64);
		editAccount.add(btnSetUpSecurity);

	}
}
