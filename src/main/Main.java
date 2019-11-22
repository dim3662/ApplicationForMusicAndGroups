package main;
// Подключение графических библиотек


import com.itextpdf.*;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.styledxmlparser.jsoup.nodes.Document;
import design.Design;
import managerGroup.ManagerGroup;


import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        ManagerGroup managerGroup=new ManagerGroup();
       Design design= new Design(managerGroup);
       design.show();
    }
}
