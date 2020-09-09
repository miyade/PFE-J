package tn.pfe.service.TemplatePFE;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.docraptor.ApiClient;
import com.docraptor.ApiException;
import com.docraptor.Doc;
import com.docraptor.DocApi;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import tn.pfe.entity.Site;
import tn.pfe.entity.TemplatePFE;


@Stateless
public class TemplatePFEService  implements TemplatePFEServiceLocal , TemplatePFEServiceRemote{

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;

	@Override
	public void ajouter(TemplatePFE T) {
		// TODO Auto-generated method stub
		em.persist(T);
		Site site = em.find(Site.class, T.getSite().getId());
		site.setTemplatePFE(T);
		em.merge(site);
	}

	@Override
	public TemplatePFE search(int id) {
		// TODO Auto-generated method stub
		return em.find(TemplatePFE.class, id);
	}

	@Override
	public void modifier(TemplatePFE T) {
		// TODO Auto-generated method stub
		em.merge(T);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(search(id));
	}

	@Override
	public void exportTemplateFile(int id) {
		
		TemplatePFE T = search(id);
		// TODO Auto-generated method stub
	    DocApi docraptor = new DocApi();
	    ApiClient client = docraptor.getApiClient();
	   client.setUsername("YOUR_API_KEY_HERE");
	    //client.setDebugging(true);

	    Doc doc = new Doc();
	    doc.setTest(true);                                                   // test documents are free but watermarked
	    doc.setDocumentContent(T.getTemplate());     // supply content directly
	    doc.setDocumentType(Doc.DocumentTypeEnum.PDF);                       // PDF or XLS or XLSX
	    doc.setName("docraptor-java.pdf");                                   // help you find a document later
	    doc.setJavascript(true);                                             // enable JavaScript processing
	    try {
			docraptor.createDoc(doc);
		      byte[] create_response = docraptor.createDoc(doc);
		      FileOutputStream file = new FileOutputStream("C:\\Users\\ROCH\\Desktop\\htmltopdf.pdf");
		      file.write(create_response);
		      file.close();
		      System.err.println("Wrote PDF to /tmp/docraptor-java.pdf");
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}
	
}
