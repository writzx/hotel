package gs_project.hotel.helpers;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintUIWindow implements ActionListener, Printable {
    JPanel panelToPrint;
    OrientationRequested orient;

    public PrintUIWindow(JPanel f, OrientationRequested or) {
        panelToPrint = f;
        orient = or;
    }

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
            } catch (PrinterException ignored) {
            }
        }
    }
}
