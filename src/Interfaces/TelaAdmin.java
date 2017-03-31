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

public class TelaAdmin extends JFrame {

	private JPanel contentPane;
	private static ListaDeUsuarios lista_usuarios;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnTeste = new JButton("teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				double feminino = lista_usuarios.getQuantidadeFeminino();
				double masculino = lista_usuarios.getQuantidadeMasculino();
				
				System.out.println("Feminino: " + feminino + " Masculino: " + masculino);
				System.out.println("Numero de pessoas: " + lista_usuarios.getNumeroDePessoas());
				System.out.println("Socios: " + lista_usuarios.getSocios());
				System.out.println("Usuario por cpf: " + lista_usuarios.getUsuarioPorCpf("111"));
				
			}
		});
		contentPane.add(btnTeste, BorderLayout.CENTER);
	}

}
