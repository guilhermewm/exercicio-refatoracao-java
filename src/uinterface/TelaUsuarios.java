package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Genero;
import business.ListaDeUsuarios;
import business.Socio;
import business.Usuario;
import persistence.CriacaoDeArquivo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.naming.directory.InvalidAttributesException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TelaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JTextField idadeTextField;
	private JLabel lblGenero;
	private JTextField numeroSocioTextField;
	private static ListaDeUsuarios lista_usuarios;
	private static CriacaoDeArquivo cria_arquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuarios frame = new TelaUsuarios(lista_usuarios, cria_arquivo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lista_usuarios 
	 */
	public TelaUsuarios(ListaDeUsuarios lista_usuarios, CriacaoDeArquivo cria_arquivo) {
		this.lista_usuarios = lista_usuarios;
		this.cria_arquivo = cria_arquivo;
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		
		idadeTextField = new JTextField();
		idadeTextField.setColumns(10);
		
		lblGenero = new JLabel("Genero:");
		
		JComboBox generoComboBox = new JComboBox();
		generoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		
		JLabel lblNewLabel = new JLabel("S\u00F3cio");
		
		JRadioButton socioNaoRadioButton = new JRadioButton("N\u00E3o\r\n");
		socioNaoRadioButton.setSelected(true);
		
		JRadioButton socioSimRadioButton = new JRadioButton("Sim");
		
		
		JLabel lblNmeroDoScio = new JLabel("N\u00FAmero do s\u00F3cio");
		lblNmeroDoScio.setEnabled(false);
		
		numeroSocioTextField = new JTextField();		
		numeroSocioTextField.setColumns(10);
		numeroSocioTextField.setEnabled(false);
		
		
		socioNaoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				socioSimRadioButton.setSelected(false);
				lblNmeroDoScio.setEnabled(false);
				numeroSocioTextField.setEnabled(false);
			}
		});
		
		socioSimRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				socioNaoRadioButton.setSelected(false);
				lblNmeroDoScio.setEnabled(true);
				numeroSocioTextField.setEnabled(true);
			}
		});
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario;				
				String nome = nomeTextField.getText();
				String cpf = cpfTextField.getText();
				String idade = idadeTextField.getText();				
				String genero = generoComboBox.getSelectedItem().toString();	
				
				if(nome.trim().isEmpty() == false && cpf.trim().isEmpty() == false && idade.trim().isEmpty() == false){
					if(socioSimRadioButton.isSelected()){
						if(!numeroSocioTextField.getText().trim().isEmpty()){	
							if(genero == "Masculino"){
								usuario = new Usuario(nome, cpf, Integer.valueOf(idade), Genero.MASCULINO, Socio.SIM, Integer.valueOf(numeroSocioTextField.getText()));
							}else{
								usuario = new Usuario(nome, cpf, Integer.valueOf(idade), Genero.FEMININO, Socio.SIM, Integer.valueOf(numeroSocioTextField.getText()));
							}
							lista_usuarios.addUsuario(usuario);
							cria_arquivo.addUsuario(usuario);
						}else{
							System.out.println("Falta preencher alguns campos");
						}
					}else{
						if(genero == "Masculino"){
							usuario = new Usuario(nome, cpf, Integer.valueOf(idade), Genero.MASCULINO, Socio.NAO, null);
						}else{
							usuario = new Usuario(nome, cpf, Integer.valueOf(idade), Genero.FEMININO, Socio.NAO, null);
						}
						lista_usuarios.addUsuario(usuario);
						cria_arquivo.addUsuario(usuario);
					}
				}else{
					System.out.println("Falta preencher alguns campos");
				}
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nomeTextField, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblIdade)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(idadeTextField, 0, 0, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblGenero)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(generoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(socioNaoRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(socioSimRadioButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNmeroDoScio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numeroSocioTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(179, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(179, Short.MAX_VALUE)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(166))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nomeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(idadeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenero)
						.addComponent(generoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(socioNaoRadioButton)
						.addComponent(socioSimRadioButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroDoScio)
						.addComponent(numeroSocioTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
