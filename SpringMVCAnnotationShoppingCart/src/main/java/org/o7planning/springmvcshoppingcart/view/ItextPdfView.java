package org.o7planning.springmvcshoppingcart.view;


import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.memorynotfound.model.Course;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        //List<Course> courses = (List<Course>) model.get("courses");
        CartInfo cartInfo = Utils.getCartInSession(request);
        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{10, 60});

        table.addCell("ID");
        table.addCell("Name");

        for (int i = 0; i<cartInfo.getCartLines().size();i++){
        	table.addCell(cartInfo.getCartLines().get(i).getProductInfo().getCode());
        	table.addCell(cartInfo.getCartLines().get(i).getProductInfo().getName());
        	
        }


        document.add(table);
    }

}