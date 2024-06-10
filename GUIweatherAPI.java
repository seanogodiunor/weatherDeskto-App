package weatherAPI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Panel;

public class GUIweatherAPI extends JFrame {

	private JPanel contentPane;
	private static JTextField cityText;
	
	BufferedImage gi;
	
	JLabel imageLabel;
	JLabel cityDisplay;
	JLabel tempDisplay;
	
	
	static weatherAPI backend = new weatherAPI();
	
	String cityName;
	
	BufferedImage inputImage;
	BufferedImage outputImage;
	
	BufferedImage wallpaperImage;
	BufferedImage wallpaperoutput;

	
	private JLabel celsiusSymbolLable;
	private JLabel lblWindSpeed;
	private JLabel lblHumidity;
	private JLabel windspeedLabel;
	private JLabel humidityLabel;
	private JLabel nrwLabel;
	
	
	JButton searchButton;
	
	JPanel displayPanel;
	JPanel secoundPanel;
	JPanel firstPanel;
	Panel dividerPanel;
	private JLabel countryLabel;
	
	
	static GUIweatherAPI frame = new GUIweatherAPI();	
	JPanel wallpapperPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					frame.setVisible(true);
					frame.firstPanel.setVisible(false);
					frame.secoundPanel.setVisible(false);
					frame.imageLabel.setVisible(false);
					frame.dividerPanel.setVisible(false);
					frame.wallpapperPanel.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIweatherAPI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 431);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstPanel = new JPanel();
		firstPanel.setBackground(SystemColor.activeCaption);
		firstPanel.setBounds(6, 0, 397, 219);
		contentPane.add(firstPanel);
		firstPanel.setLayout(null);
		
		secoundPanel = new JPanel();
		secoundPanel.setBounds(6, 223, 397, 95);
		contentPane.add(secoundPanel);
		secoundPanel.setLayout(null);
		
		displayPanel = new JPanel();
		displayPanel.setBackground(SystemColor.activeCaption);
		displayPanel.setBounds(6, 0, 387, 215);
		firstPanel.add(displayPanel);
		displayPanel.setLayout(null);
		
		dividerPanel = new Panel();
		dividerPanel.setBackground(SystemColor.window);
		dividerPanel.setBounds(151, 10, 15, 195);
		displayPanel.add(dividerPanel);
		
		
		
		imageLabel = new JLabel() {
              BufferedImage g = printImage();
              protected void paintComponent(Graphics g) {
            	  int on = 2;
            	  if (on == 2) {
            		  super.paintComponent(g);
                      g.drawImage(outputImage, 0, 0, null);
				}
              }
          };
        imageLabel.setBounds(0, 6, 156, 200);
		displayPanel.add(imageLabel);
		
		tempDisplay = new JLabel("");
		tempDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 53));
		tempDisplay.setBounds(168, 113, 175, 96);
		displayPanel.add(tempDisplay);
		
		cityDisplay = new JLabel("");
		//infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		cityDisplay.setBounds(167, 30, 224, 66);
		displayPanel.add(cityDisplay);
		
		celsiusSymbolLable = new JLabel("°C");
		celsiusSymbolLable.setFont(new Font("Lucida Grande", Font.BOLD, 53));
		celsiusSymbolLable.setBounds(307, 113, 74, 96);
		displayPanel.add(celsiusSymbolLable);
		
		nrwLabel = new JLabel("New label");
		nrwLabel.setBounds(167, 6, 224, 31);
		displayPanel.add(nrwLabel);
		
		countryLabel = new JLabel("New label");
		countryLabel.setBounds(167, 84, 224, 31);
		displayPanel.add(countryLabel);
		
		
		
		lblWindSpeed = new JLabel("Wind Speed");
		lblWindSpeed.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWindSpeed.setBounds(6, 6, 129, 31);
		secoundPanel.add(lblWindSpeed);
		
		lblHumidity = new JLabel("Humidity");
		lblHumidity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHumidity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblHumidity.setBounds(276, 6, 115, 31);
		secoundPanel.add(lblHumidity);
		
		windspeedLabel = new JLabel("");
		windspeedLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		windspeedLabel.setBounds(6, 36, 129, 46);
		secoundPanel.add(windspeedLabel);
		
		humidityLabel = new JLabel("");
		humidityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		humidityLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		humidityLabel.setBounds(272, 39, 119, 43);
		secoundPanel.add(humidityLabel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(SystemColor.activeCaption);
		searchPanel.setBounds(0, 318, 411, 87);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		
		
		cityText = new JTextField();
		cityText.setBounds(0, 0, 411, 41);
		searchPanel.add(cityText);
		cityText.setText("Enter your city here...");
		
		
		cityText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.firstPanel.setVisible(true);
				frame.secoundPanel.setVisible(true);
				frame.imageLabel.setVisible(true);
				frame.dividerPanel.setVisible(true);
				frame.wallpapperPanel.setVisible(false);
				
				// ENTER TO SAVE
				String text = "Enter your city ...";
				if (!cityText.getText().equals(text) 
						&& !cityText.getText().isEmpty()
						&& !cityText.getText().isBlank()) {
					
					searchWerther();
					
				} else {
					frame.firstPanel.setVisible(false);
					frame.secoundPanel.setVisible(false);
					frame.imageLabel.setVisible(false);
					frame.dividerPanel.setVisible(false);
					frame.wallpapperPanel.setVisible(true);
		            JOptionPane.showMessageDialog(frame, "Enter a City"); 
				}
			}
		});
		cityText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cityText.setText("");
			}
		});
		
		cityText.setColumns(10);
		
		
		
		
		
		
		
		
		

		searchButton = new MyButton("search");
		searchButton.setBounds(0, 37, 411, 51);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.firstPanel.setVisible(true);
				frame.secoundPanel.setVisible(true);
				frame.imageLabel.setVisible(true);
				frame.dividerPanel.setVisible(true);
				frame.wallpapperPanel.setVisible(false);
				
				// ENTER TO SAVE
				String text = "Enter your city ...";
				if (!cityText.getText().equals(text) 
						&& !cityText.getText().isEmpty()
						&& !cityText.getText().isBlank()) {
					
					searchWerther();
					
				} else {
					frame.firstPanel.setVisible(false);
					frame.secoundPanel.setVisible(false);
					frame.imageLabel.setVisible(false);
					frame.dividerPanel.setVisible(false);
					frame.wallpapperPanel.setVisible(true);
		            JOptionPane.showMessageDialog(frame, "Enter a City"); 
				}
			}
		});
		
		searchButton.setForeground(UIManager.getColor("FormattedTextField.caretForeground"));
		searchButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 20));
		searchButton.setHorizontalTextPosition(SwingConstants.CENTER);
		searchButton.setBorder(null);
		searchButton.setBackground(new Color(75, 146, 220));
		searchButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				UIManager.put("Button.select", new Color(3, 59, 90)); // <--- Added ---
				// btnNewButton_2_3.setBackground(new Color(3, 59, 90));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// it's working :)
				UIManager.put("Button.select", Color.pink); // <--- Added ---
				// btnNewButton_2_3.setBackground(Color.pink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchButton.setBackground(new Color(3, 59, 90));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				searchButton.setBackground(new Color(3, 59, 90).brighter());
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				searchButton.setBackground(new Color(3, 59, 90).brighter());
			}
		});
		
		
		
		
		searchPanel.add(searchButton);
		
		
		
		wallpapperPanel = new JPanel(){
            BufferedImage gi = printWallpapper();
            protected void paintComponent(Graphics gi) {
          		  super.paintComponent(gi);
                  gi.drawImage(wallpaperoutput, 0, 0, null);
            }
        };
        
		wallpapperPanel.setBounds(0, 0, 411, 400);
		contentPane.add(wallpapperPanel);
		
		
		
		
		
	}
	

	protected void searchWerther() {
		
		cityName = cityText.getText();
		String weatherValue = backend.wetherApi(cityName);
		
        if (weatherValue != null) {
        	
        	if (cityName.length() <= 5) {
    			cityDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    			//infoLabel.setText(cityName.toUpperCase());
    			System.out.println("FONT SIZE: " + cityDisplay.getFont().getSize());
    			
    		}else {
    			cityDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    			System.out.println("FONT: " + cityDisplay.getFont().getSize());
    		}
    		cityDisplay.setText(cityName.toUpperCase());
            String[] parts = weatherValue.split(","); 
            
            // Assign array elements to individual variables
            String temp = parts[0];
            String humidity = parts[1];
            String windSpeed = parts[2];
            
            String rain = parts[3];
            String shower = parts[4];
            String snowfall = parts[5];
            
            String nrw = parts[6];		// NRW
            String cityName = parts[7];	// city name
            String timezone = parts[8];		// time
            String country = parts[9];	// country
            
            // Print the variables to verify the values
            System.out.println(nrw);
            System.out.println(cityName);
            System.out.println(timezone);
            System.out.println(country);

            tempDisplay.setText(temp);
            windspeedLabel.setText(windSpeed);
            humidityLabel.setText(humidity);
            
            nrwLabel.setText(nrw);			// NRW
            countryLabel.setText(country); // country
            
			
		}else {
			frame.firstPanel.setVisible(false);
			frame.secoundPanel.setVisible(false);
			frame.imageLabel.setVisible(false);
			frame.dividerPanel.setVisible(false);
			frame.wallpapperPanel.setVisible(true);
            JOptionPane.showMessageDialog(frame, "Wrong city"); 
		}
		cityText.setText("");
		
	}

	
	private BufferedImage printWallpapper() {
		try {
			
   			File inputFile = new File("/Users/godspowerogodiunor/eclipse-workspace/API/src/weatherAPI/wallpaler.png");
            wallpaperImage = ImageIO.read(inputFile);
            
            int desiredWidth = 411;
            int desiredHeight = 400;

            wallpaperoutput = new BufferedImage(desiredWidth, desiredHeight, wallpaperImage.getType());
            Graphics2D g2d = wallpaperoutput.createGraphics();

            g2d.drawImage(wallpaperImage, 0, 0, desiredWidth, desiredHeight, null);
            
        } catch (IOException e) {
            System.err.println("Error resizing wallpapper image.");
            e.printStackTrace();
        }
		return wallpaperoutput;
	}
	
	
	
	private BufferedImage printImage() {
		try {
			
          // File inputFile = new File("/Users/godspowerogodiunor/eclipse-workspace/API/src/weatherAPI/sun1.png");
           File inputFile = image(23);

            // Load the original image
            inputImage = ImageIO.read(inputFile);
            
            // Specify the desired width and height
            int desiredWidth = 150;
            int desiredHeight = 160;

            // Create a new buffered image with the desired width and height
            outputImage = new BufferedImage(desiredWidth, desiredHeight, inputImage.getType());

            // Get the Graphics2D object
            Graphics2D g2d = outputImage.createGraphics();

            // Draw the original image resized to the new dimensions
            g2d.drawImage(inputImage, 0, 0, desiredWidth, desiredHeight, null);
            
           // Object obj = g2d.drawImage(outputImage, 0, 0, null);

        } catch (IOException e) {
            System.err.println("Error resizing weather image.");
            e.printStackTrace();
        }
		return outputImage;
		
		
	}
	
	
//	
//	
//	 public File imageWall() {
//		File inputFile = null;
//			
//		return inputFile;
//	}
	
	
	

	 public File image(double graad) {
		double degree = graad;
		File inputFile = null;
		
		if (degree == 23) {
			inputFile = new File("/Users/godspowerogodiunor/eclipse-workspace/API/src/weatherAPI/sun1.png");
				return inputFile;
		}
		if (degree == 18) {
			inputFile = new File("/Users/godspowerogodiunor/eclipse-workspace/API/src/weatherAPI/rain.png");
				return inputFile;
		}
//		if (degree == ) {
//			String cloudy = "Users/godspowerogodiunor/eclipse-workspace/API/src/weatherAPI/cloudy.png";
//				return cloudy;
//		}
//		if (degree <= 0) {
//			String snow = "Users/godspowerogodiunor/eclipse-workspace/API/src/weatherAPI/snow.png";
//				return snow;
//		}
		return inputFile;
	}
	 
	 
	 
}

