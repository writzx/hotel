package gs_project.hotel.helpers;

import java.awt.*;
import java.awt.event.*;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrinterResolution;
import javax.swing.*;
import java.awt.print.*;
public class PrintUIWindow implements ActionListener, Printable {
    JPanel panelToPrint;
    OrientationRequested orient;

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        panelToPrint.printAll(g);

        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        PrintRequestAttributeSet p = new HashPrintRequestAttributeSet();
        p.add(orient);
        if (job.printDialog(p)) {
            try {
                job.print(p);
            } catch (PrinterException ignored) { }
        }
    }
    
    public PrintUIWindow(JPanel f, OrientationRequested or) {
    	panelToPrint = f;
    	orient = or;
    }
}
