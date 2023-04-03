package triangulo;


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class AppTriangulo {

	private JFrame frmEjercicioTriangulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppTriangulo window = new AppTriangulo();
					window.frmEjercicioTriangulo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppTriangulo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEjercicioTriangulo = new JFrame();
		frmEjercicioTriangulo.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frmEjercicioTriangulo.setFont(new Font("SansSerif", Font.BOLD, 16));
		frmEjercicioTriangulo.setTitle("Ejercicio Triangulo");
		frmEjercicioTriangulo.setBounds(100, 100, 440, 266);
		frmEjercicioTriangulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEjercicioTriangulo.getContentPane().setLayout(null);
		
		//Para que solo se ingresen números
		KeyAdapter onlyDigits = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        e.consume();
			      }
			}
		};
		
		JLabel lblNewLabel = new JLabel("Lado 1");
		lblNewLabel.setBounds(31, 9, 228, 14);
		frmEjercicioTriangulo.getContentPane().add(lblNewLabel);
		
		JLabel lblLado = new JLabel("Lado 2");
		lblLado.setBounds(156, 9, 228, 14);
		frmEjercicioTriangulo.getContentPane().add(lblLado);
		
		JLabel lblLado_1 = new JLabel("Lado 3");
		lblLado_1.setBounds(281, 9, 228, 14);
		frmEjercicioTriangulo.getContentPane().add(lblLado_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Respuesta");
		lblNewLabel_1.setBounds(31, 107, 89, 14);
		frmEjercicioTriangulo.getContentPane().add(lblNewLabel_1);
		
		JTextField txtField_Lado1 = new JTextField();
		txtField_Lado1.setDocument(new JTextFieldLimit(9));
		txtField_Lado1.setBorder((Border) new LineBorder(Color.LIGHT_GRAY , 2) );
		txtField_Lado1.addKeyListener(onlyDigits);
		txtField_Lado1.setBounds(31, 29, 115, 22);
		frmEjercicioTriangulo.getContentPane().add(txtField_Lado1);
		
		JTextField txtField_Lado2 = new JTextField();
		txtField_Lado2.setDocument(new JTextFieldLimit(9));
		txtField_Lado2.setBorder((Border) new LineBorder(Color.LIGHT_GRAY , 2) );
		txtField_Lado2.addKeyListener(onlyDigits);
		txtField_Lado2.setBounds(156, 29, 115, 22);
		frmEjercicioTriangulo.getContentPane().add(txtField_Lado2);
		
		JTextField txtField_Lado3 = new JTextField();
		txtField_Lado3.setDocument(new JTextFieldLimit(9));
		txtField_Lado3.setBorder((Border) new LineBorder(Color.LIGHT_GRAY , 2) );
		txtField_Lado3.addKeyListener(onlyDigits);
		txtField_Lado3.setBounds(281, 29, 115, 22);
		txtField_Lado3.setColumns(5);
		frmEjercicioTriangulo.getContentPane().add(txtField_Lado3);
		
		JTextField txtField_Resultado = new JTextField();
		txtField_Lado3.setDocument(new JTextFieldLimit(9));
		txtField_Lado3.setBorder((Border) new LineBorder(Color.LIGHT_GRAY , 2) );
		txtField_Resultado.setEditable(false);
		txtField_Resultado.setBounds(31, 127, 365, 64);
		frmEjercicioTriangulo.getContentPane().add(txtField_Resultado);
		
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtField_Lado1.getText().length() > 0 && txtField_Lado1.getText() != "" && txtField_Lado2.getText().length() > 0 && txtField_Lado2.getText() != "" && txtField_Lado3.getText().length() > 0 && txtField_Lado3.getText() != "") {
					Triangulo triangulo = new Triangulo(Integer.parseInt(txtField_Lado1.getText()), Integer.parseInt(txtField_Lado2.getText()), Integer.parseInt(txtField_Lado3.getText()));
					if(triangulo.esTriangulo())
					{
						txtField_Resultado.setText("Es triangulo " + triangulo.getTipo());
					}else {
						txtField_Resultado.setText("No es triangulo");
					}
				
				}else {
					txtField_Resultado.setText("Falta ingresar Datos");
				}
			}
		});
		btnNewButton.setBounds(106, 74, 214, 22);
		frmEjercicioTriangulo.getContentPane().add(btnNewButton);
	}
}

class JTextFieldLimit extends PlainDocument {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}
