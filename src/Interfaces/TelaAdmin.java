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
import javax.swing.JLabel;

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
				if(!cpfTextField.getText().isEmpty()){	
					lista_usuarios.getUsuarioPorCpf(cpfTextField.getText());
				}					
			}
		});
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		
		
		JLabel num_pessoasLabel = new JLabel("0");
		
		JButton btnNmeroDePessoas = new JButton("N\u00FAmero de pessoas no local");
		btnNmeroDePessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num_pessoasLabel.setText(lista_usuarios.getNumeroDePessoas().toString());				
			}
		});
		
		JLabel valor_masculinoLabel = new JLabel("0.0%");
		
		JLabel valor_femininoLabel = new JLabel("0.0%");
		
		JButton btnPorcentagemGnero = new JButton("Porcentagem g\u00EAnero");
		btnPorcentagemGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valor_femininoLabel.setText(lista_usuarios.getQuantidadeFeminino() + "%");
				valor_masculinoLabel.setText(lista_usuarios.getQuantidadeMasculino() + "%");
			}
		});
		
		JLabel num_sociosLabel = new JLabel("0");
		
		JButton btnNewButton_1 = new JButton("Todos os usu\u00E1rios s\u00F3cios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num_sociosLabel.setText(lista_usuarios.getSocios().toString());
			}
		});
		
		JLabel lblMasculino = new JLabel("Masculino:");
		
		JLabel lblFeminino = new JLabel("Feminino:");
		
		JLabel lblPessoas = new JLabel("Pessoas:");
		
		JLabel lblPessoas_1 = new JLabel("Socios:");
		
		
		
	
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTodosOsUsurios)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPessoas_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(num_sociosLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNmeroDePessoas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPessoas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(num_pessoasLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPorcentagemGnero)
							.addGap(18)
							.addComponent(lblMasculino)
							.addGap(4)
							.addComponent(valor_masculinoLabel)
							.addGap(18)
							.addComponent(lblFeminino)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(valor_femininoLabel)))
					.addContainerGap(85, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNmeroDePessoas)
						.addComponent(lblPessoas)
						.addComponent(num_pessoasLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPorcentagemGnero)
						.addComponent(lblMasculino)
						.addComponent(lblFeminino)
						.addComponent(valor_masculinoLabel)
						.addComponent(valor_femininoLabel))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(lblPessoas_1)
						.addComponent(num_sociosLabel))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
