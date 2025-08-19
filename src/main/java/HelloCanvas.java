import java.awt.*;

public class HelloCanvas extends Canvas {
    public HelloCanvas() { setBackground(Color.WHITE); setSize(640, 360); }

    @Override public void paint(Graphics g) {
        g.setFont(new Font("SansSerif", Font.BOLD, 28));
        g.setColor(Color.BLACK);
        g.drawString("Hello, CheerpJ + Canvas!", 40, 80);
        g.setColor(Color.RED);
        g.fillRect(40, 120, 160, 80);
    }

    public static void main(String[] args) {
        System.out.println("Starting HelloCanvas application...");
        
        try {
            // Wait for CheerpJ to fully initialize
           Thread.sleep(500);
            
            // Create frame without immediately showing it
            Frame f = new Frame("AWT Canvas");
            HelloCanvas canvas = new HelloCanvas();
            
            System.out.println("Created canvas and frame");
            
            f.add(canvas);
            f.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) { 
                    System.exit(0); 
                }
            });
            
            // Set size explicitly instead of pack()
            f.setSize(680, 400);
            f.setResizable(false);
            
            System.out.println("Configured frame, making visible");
            f.setVisible(true);
            
            System.out.println("Canvas application started successfully");
            
        } catch (Exception e) {
            System.err.println("Error starting canvas application: " + e.getMessage());
            e.printStackTrace();
            
            // Try fallback approach
            try {
                System.out.println("Trying fallback approach...");
                Thread.sleep(1000);
                
                Frame fallbackFrame = new Frame("Fallback Canvas");
                fallbackFrame.setSize(640, 360);
                fallbackFrame.add(new HelloCanvas());
                fallbackFrame.setVisible(true);
                
            } catch (Exception fallbackError) {
                System.err.println("Fallback also failed: " + fallbackError.getMessage());
                fallbackError.printStackTrace();
            }
        }
    }
}
