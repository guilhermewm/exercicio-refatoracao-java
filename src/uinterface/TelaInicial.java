package uinterface;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Calendario;
import business.ListaDeUsuarios;
import business.Usuario;
import persistence.CriacaoDeArquivo;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private ListaDeUsuarios lista_usuarios;
	private JTextField cpfTextField;
	private Calendario calendario;
	private JLabel diaAtualLabel;
	private CriacaoDeArquivo cria_arquivo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista_usuarios = new ListaDeUsuarios();
		calendario = new Calendario();
		diaAtualLabel = new JLabel("");
		cria_arquivo = new CriacaoDeArquivo();
		
//		Usuario user1 = new Usuario("Pedro", "111", 20, "Masculino", 0);
//		Usuario user2 = new Usuario("Jo�o", "222", 22, "Masculino", 1);
//		Usuario user3 = new Usuario("Maria", "333", 15, "Feminino", 2);
//		
//		lista_usuarios.addUsuario(user1);
//		lista_usuarios.addUsuario(user2);
//		lista_usuarios.addUsuario(user3);
		
		
		setTitle("Exerc\u00EDcio de Refatora\u00E7\u00E3o\r\n");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdmin admin = new TelaAdmin(lista_usuarios);
				admin.setVisible(true);
			}
		});
		
		JButton btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuarios usuarios = new TelaUsuarios(lista_usuarios, cria_arquivo);
				usuarios.setVisible(true);
			}
		});
		
		JLabel lblCpf = new JLabel("CPF:");
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		
		JButton btnSairDoRestaurante = new JButton("Sair do restaurante");
		btnSairDoRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cpfTextField.getText().isEmpty()){
					System.out.println("Campo n�o preenchido");
				}else{
					lista_usuarios.saiUsuario(cpfTextField.getText());
				}				
			}
		});
		
		JLabel lblDiaAtual = new JLabel("Dia atual:");	
		alteraDiaAtual();
		
		
		JButton btnPrximoDia = new JButton("Pr\u00F3ximo dia");
		btnPrximoDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cria_arquivo.criaArquivo();
				} catch (IOException e) {					
					e.printStackTrace();
				}
				lista_usuarios.saiTodosOsUsuarios();
				calendario.proximoDia();
				alteraDiaAtual();		
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDiaAtual)
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(diaAtualLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpf)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSairDoRestaurante))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(84)
									.addComponent(btnUsuarios, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnPrximoDia))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUsuarios, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSairDoRestaurante))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiaAtual)
						.addComponent(diaAtualLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnPrximoDia))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void alteraDiaAtual(){
		diaAtualLabel.setText(calendario.getCalendario());
	}
}
