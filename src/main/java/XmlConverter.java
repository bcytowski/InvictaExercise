import model.Sentence;
import model.WrapperClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class XmlConverter implements Converter {
    public void generate(WrapperClass sentenceListWrapper, String filePath) {


        try {
            File file = new File(filePath).getCanonicalFile();
            JAXBContext jaxbContext = JAXBContext.newInstance(Sentence.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(sentenceListWrapper, file);
            jaxbMarshaller.marshal(sentenceListWrapper, System.out);


        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }


}

