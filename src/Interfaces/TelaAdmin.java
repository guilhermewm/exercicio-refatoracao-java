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
	private JLabel valor_masculinoLabel = new JLabel("0.0%");
	private JLabel valor_femininoLabel = new JLabel("0.0%");
	
	private JLabel num_sociosLabel = new JLabel("0");
	private JLabel num_n_sociosLabel = new JLabel("0");
	
	private JLabel num_pessoasLabel = new JLabel("0");
	
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
		
		setNumeroPessoas();	
		setPorcentagemDeGeneros();
		setNumeroDeSociosENaoSocios();
		
		
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
				}else{
					System.out.println("Não há cpf no campo");
				}
			}	
		});
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		
		
		
		
		
		
		JButton btnNmeroDePessoas = new JButton("N\u00FAmero de pessoas no local");
		btnNmeroDePessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumeroPessoas();				
			}
		});
		
		JButton btnPorcentagemGnero = new JButton("Porcentagem g\u00EAnero");
		btnPorcentagemGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setPorcentagemDeGeneros();
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Todos os usu\u00E1rios s\u00F3cios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumeroDeSociosENaoSocios();
			}
		});
		
		JLabel lblMasculino = new JLabel("Masculino:");
		
		JLabel lblFeminino = new JLabel("Feminino:");
		
		JLabel lblPessoas = new JLabel("Pessoas:");
		
		JLabel lblPessoas_1 = new JLabel("Socios:");
		
		JLabel lblNoSocios = new JLabel("N\u00E3o socios:");
		
		
		
		
		
	
		
		
		
		
		
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
							.addComponent(num_sociosLabel)
							.addGap(27)
							.addComponent(lblNoSocios)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(num_n_sociosLabel))
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
					.addContainerGap(83, Short.MAX_VALUE))
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
						.addComponent(num_sociosLabel)
						.addComponent(lblNoSocios)
						.addComponent(num_n_sociosLabel))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void setNumeroPessoas(){
		num_pessoasLabel.setText(lista_usuarios.getNumeroDePessoas().toString());
	}
	
	public void setPorcentagemDeGeneros(){
		valor_femininoLabel.setText(lista_usuarios.getQuantidadeFeminino() + "%");
		valor_masculinoLabel.setText(lista_usuarios.getQuantidadeMasculino() + "%");
	}
	
	public void setNumeroDeSociosENaoSocios(){
		num_sociosLabel.setText(lista_usuarios.getSocios().toString());
		num_n_sociosLabel.setText(lista_usuarios.getNumeroNaoSocios().toString());
	}
	
}
