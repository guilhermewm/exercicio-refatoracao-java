package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.ListaDeUsuarios;
import Classes.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class TelaAdmin extends JFrame {

	private JPanel contentPane;
	private static ListaDeUsuarios lista_usuarios;
	private JTextField cpfTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmin frame = new TelaAdmin(lista_usuarios);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAdmin(ListaDeUsuarios lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnTodosOsUsurios = new JButton("Todos os usu\u00E1rios");
		btnTodosOsUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTodosOsUsuarios tela_usuarios = new TelaTodosOsUsuarios(lista_usuarios.getTodosUsuarios());
				tela_usuarios.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Usu\u00E1rio por CPF");
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				TelaUsuarioPorCpf tela_usuario_cpf;
				if(!cpfTextField.getText().isEmpty()){	
					tela_usuario_cpf = new TelaUsuarioPorCpf(lista_usuarios.getUsuarioPorCpf(cpfTextField.getText()));					
					tela_usuario_cpf.setVisible(true);
				}				
			}			
			
			
		
			
			
		});
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		
		JButton btnNmeroDePessoas = new JButton("N\u00FAmero de pessoas no local");
		
		JButton btnPorcentagemGnero = new JButton("Porcentagem g\u00EAnero");
		
		JButton btnNewButton_1 = new JButton("Todos os usu\u00E1rios s\u00F3cios");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTodosOsUsurios)
						.addComponent(btnNewButton_1)
						.addComponent(btnPorcentagemGnero)
						.addComponent(btnNmeroDePessoas)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnTodosOsUsurios)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(btnNmeroDePessoas)
					.addGap(18)
					.addComponent(btnPorcentagemGnero)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
