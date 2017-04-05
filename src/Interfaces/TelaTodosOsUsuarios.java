package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TelaTodosOsUsuarios extends JDialog {
	private static Map list_todos_usuarios;
	private JPanel buttonPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		try {
			TelaTodosOsUsuarios dialog = new TelaTodosOsUsuarios(list_todos_usuarios);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param list_todos_usuarios 
	 */
	public TelaTodosOsUsuarios(Map list_todos_usuarios) {
		list_todos_usuarios = list_todos_usuarios;
		setBounds(100, 100, 665, 300);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaTodosOsUsuarios.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaTodosOsUsuarios.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
					
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(scrollPane))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)))
					.addGap(15))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		DefaultListModel dlm = new DefaultListModel();
		
		System.out.println(list_todos_usuarios.size());
		if(list_todos_usuarios.size() > 0){
			for(int i = 0; list_todos_usuarios.size() >= i; i++){
				dlm.addElement(list_todos_usuarios.get(i));
			}	
		}else{
			dlm.addElement("Não há pessoas no estabelecimento");
		}	
		list.setModel(dlm);
		getContentPane().setLayout(groupLayout);
	}
}
